package com.alnicode.restapi.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DirectionRequest {
    @NotBlank
    private String country;

    @NotBlank
    private String state;

    @NotBlank
    private String locality;

    @NotBlank
    private String address;
}
