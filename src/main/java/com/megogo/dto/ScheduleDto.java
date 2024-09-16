package com.megogo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ScheduleDto {
    private int id;
    @JsonProperty("external_id")
    private int externalId;
    private String title;
    @JsonIgnore
    private PicturesDto pictures;
    @JsonProperty("video_id")
    private int videoId;
    private List<ProgramDto> programs;
}
