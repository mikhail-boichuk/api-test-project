package com.megogo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class TimeDto {
    @JsonProperty("utc_offset")
    private long utcOffset;
    @JsonProperty("timestamp_gmt")
    private Instant timestampGmt;
    @JsonProperty("timestamp_local")
    private Instant timestampLocal;
    private String timezone;
    @JsonProperty("time_local")
    private String timeLocal;
    private Instant timestamp;
}
