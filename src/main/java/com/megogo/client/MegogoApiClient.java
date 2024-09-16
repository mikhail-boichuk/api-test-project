package com.megogo.client;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.megogo.dto.ScheduleDto;
import com.megogo.dto.TimeDto;
import io.qameta.allure.Step;
import io.qameta.allure.okhttp3.AllureOkHttp3;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

@Slf4j
public class MegogoApiClient {

    private final OkHttpClient client;
    private static final String BASE_URL = "https://epg.megogo.net/";
    private final JsonMapper jsonMapper;

    public MegogoApiClient() {
        // Prettify Allure interceptor
        var allureInterceptor = new AllureOkHttp3();
        allureInterceptor.setRequestTemplate("http-request.ftl");
        allureInterceptor.setResponseTemplate("http-response.ftl");

        // Create OkHttpClient and add Allure interceptor for reporting
        client = new OkHttpClient.Builder().addInterceptor(allureInterceptor).build();

        // create JsonMapper and configure it to properly handle timestamps
        jsonMapper = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .addModule(new JavaTimeModule())
                .build();
    }

    @Step("Request current time from Megogo API")
    public TimeDto getCurrentTime() throws IOException, NullPointerException {
        try (Response response = client.newCall(
                        new Request.Builder().url(BASE_URL + "time").build())
                .execute()

        ) {
            // Obtain response data as JSONObject
            assert response.body() != null;
            var data = (JSONObject) new JSONObject(response.body().string()).get("data");

            return jsonMapper.readValue(data.toString(), TimeDto.class);
        }
    }

    @Step("Request program schedule from Megogo API")
    public ScheduleDto getScheduleById(String id) throws IOException, NullPointerException {
        try (Response response = client.newCall(
                        new Request.Builder().url(BASE_URL + "channel?video_ids=" + id).build())
                .execute()) {
            // obtain response data as JSONArray
            assert response.body() != null;
            var data = (JSONArray) new JSONObject(response.body().string()).get("data");

            return jsonMapper.readValue(data.get(0).toString(), ScheduleDto.class);
        }
    }
}
