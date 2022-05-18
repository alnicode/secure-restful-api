package com.alnicode.restapi.dto;

import lombok.Data;

@Data
public class DirectionResponse {
    private long id;
    private String country, state, locality, address, owner;
}
