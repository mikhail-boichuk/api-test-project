package com.megogo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryDto {
    private int id;
    @JsonProperty("external_id")
    private int externalId;
    private String title;
}
