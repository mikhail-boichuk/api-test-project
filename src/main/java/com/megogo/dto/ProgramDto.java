package com.megogo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class ProgramDto {
    @JsonProperty("external_id")
    private int externalId;
    private String title;
    private CategoryDto category;
    private String season;
    private String episode;
    @JsonIgnore
    private PicturesDto pictures;
    @JsonProperty("start_timestamp")
    private Instant startTimestamp;
    @JsonProperty("end_timestamp")
    private Instant endTimestamp;
    private int id;
    private String start;
    private String end;
    @JsonProperty("schedule_type")
    private String scheduleType;
    @JsonProperty("virtual_object_id")
    private String virtualObjectId;
}
