package com.alnicode.restapi.controller;

import com.alnicode.restapi.dto.DirectionRequest;
import com.alnicode.restapi.dto.DirectionResponse;
import com.alnicode.restapi.service.ICrudService;
import com.alnicode.restapi.service.IDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directions")
public class DirectionController extends CrudController<DirectionRequest, DirectionResponse> {
    @Autowired
    private IDirectionService service;

    @Override
    protected ICrudService<DirectionRequest, DirectionResponse> service() {
        return service;
    }
}
