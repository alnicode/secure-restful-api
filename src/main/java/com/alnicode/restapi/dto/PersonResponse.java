package com.alnicode.restapi.dto;

import lombok.Data;

@Data
public class PersonResponse {
    private long id;
    private String name;
    private String address;
}
