package com.alnicode.restapi.controller;

import com.alnicode.restapi.dto.PersonRequest;
import com.alnicode.restapi.dto.PersonResponse;
import com.alnicode.restapi.service.ICrudService;
import com.alnicode.restapi.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController extends CrudController<PersonRequest, PersonResponse> {
    @Autowired
    private IPersonService service;

    @Override
    protected ICrudService<PersonRequest, PersonResponse> service() {
        return service;
    }
}
