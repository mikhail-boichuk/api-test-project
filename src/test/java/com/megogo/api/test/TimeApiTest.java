package com.megogo.api.test;

import com.megogo.dto.TimeDto;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class TimeApiTest extends BaseApiTest {

    @SneakyThrows
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate time endpoint returns correct data")
    public void currentTimeTest() {
        var currentTime = client.getCurrentTime();
        var timestamp = Instant.now().truncatedTo(ChronoUnit.SECONDS);

        assertThat(currentTime.getTimestamp())
                .as("API should return correct timestamp")
                .isEqualTo(timestamp);
    }
}
