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
        return repository;
    }

    @Override
    public DirectionResponse create(DirectionRequest directionRequest) {
        return mapper.toResponse(repository.save(mapper.toEntity(directionRequest)));
    }

    @Override
    public List<DirectionResponse> getAll() {
        return mapper.toResponses(repository.findAll());
    }

    @Override
    public Optional<DirectionResponse> get(long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Optional<DirectionResponse> update(long id, DirectionRequest directionRequest) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        final var entity = mapper.toEntity(directionRequest);
        entity.setId(id);

        return Optional.of(mapper.toResponse(repository.save(entity)));
    }
}
