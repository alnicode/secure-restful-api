package com.alnicode.restapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonRequest {
    @NotEmpty
    private String name;

    @NotNull
    @Min(1L)
    private long directionId;
}
