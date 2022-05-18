package com.alnicode.restapi.service.impl;

import com.alnicode.restapi.dto.DirectionRequest;
import com.alnicode.restapi.dto.DirectionResponse;
import com.alnicode.restapi.entity.Direction;
import com.alnicode.restapi.mapper.IDirectionMapper;
import com.alnicode.restapi.repository.IDirectionRepository;
import com.alnicode.restapi.service.DeleteService;
import com.alnicode.restapi.service.IDirectionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DirectionServiceImpl extends DeleteService<Direction> implements IDirectionService {
    @Autowired
    private IDirectionRepository repository;

    @Autowired
    private IDirectionMapper mapper;

    @Override
    protected CrudRepository<Direction, Long> repository() {
        return null;
    }

    @Override
    public DirectionResponse create(DirectionRequest directionRequest) {
        return null;
    }

    @Override
    public List<DirectionResponse> getAll() {
        return null;
    }

    @Override
    public Optional<DirectionResponse> get(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<DirectionResponse> update(long id, DirectionRequest directionRequest) {
        return Optional.empty();
    }
}
