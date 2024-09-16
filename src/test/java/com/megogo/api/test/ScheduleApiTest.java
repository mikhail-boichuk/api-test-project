package com.megogo.api.test;

import com.megogo.api.data.DataProviders;
import com.megogo.dto.ProgramDto;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ScheduleApiTest extends BaseApiTest {

    @SneakyThrows
    @Test(dataProviderClass = DataProviders.class, dataProvider = "scheduleIds", threadPoolSize = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate time endpoint")
    public void scheduleTest(String scheduleId) {
        List<ProgramDto> programs = client.getScheduleById(scheduleId).getPrograms();
        var softAssertions = new SoftAssertions();

        assertThat(programs)
                .as("There should be at least one program in schedule")
                .isNotEmpty();

        softAssertions.assertThat(programs)
                .as("In schedule programs should be sorted by start_timestamp")
                .map(ProgramDto::getStartTimestamp)
                .isSortedAccordingTo(Comparator.naturalOrder());

        var currentTimestamp = client.getCurrentTime().getTimestamp();

        softAssertions.assertThat(programs)
                .as("In schedule there should be at least one live program in the schedule")
                .filteredOn(p -> p.getStartTimestamp().isBefore(currentTimestamp) && p.getEndTimestamp().isAfter(currentTimestamp))
                .isNotEmpty();

        softAssertions.assertThat(programs)
                .as("In schedule there should be no programs that ended in the past")
                .filteredOn(p -> p.getEndTimestamp().isBefore(currentTimestamp))
                .isEmpty();

        softAssertions.assertThat(programs)
                .as("In schedule there should be no programs that starts in 24h from now")
                .filteredOn(p -> Duration.between(p.getStartTimestamp(), currentTimestamp).toHours() > 24)
                .isEmpty();

        softAssertions.assertAll();
    }
}
