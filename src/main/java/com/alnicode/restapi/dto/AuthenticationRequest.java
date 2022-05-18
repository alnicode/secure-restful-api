package com.alnicode.restapi.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthenticationRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
