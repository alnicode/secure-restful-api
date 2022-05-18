package com.alnicode.restapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonRequest {
    @NotBlank
    private String name;

    @NotNull
    @Min(1L)
    private long directionId;
}
