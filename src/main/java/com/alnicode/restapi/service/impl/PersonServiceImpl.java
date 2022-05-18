package com.alnicode.restapi.service.impl;

import com.alnicode.restapi.dto.PersonRequest;
import com.alnicode.restapi.dto.PersonResponse;
import com.alnicode.restapi.entity.Person;
import com.alnicode.restapi.mapper.IPersonMapper;
import com.alnicode.restapi.repository.IPersonRepository;
import com.alnicode.restapi.service.DeleteService;
import com.alnicode.restapi.service.IPersonService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends DeleteService<Person> implements IPersonService {
    @Autowired
    private IPersonRepository repository;

    @Autowired
    private IPersonMapper mapper;

    @Override
    protected CrudRepository<Person, Long> repository() {
        return repository;
    }

    @Override
    public PersonResponse create(final PersonRequest personRequest) {
        return mapper.toResponse(repository.save(mapper.toEntity(personRequest)));
    }

    @Override
    public List<PersonResponse> getAll() {
        return mapper.toResponses(repository.findAll());
    }

    @Override
    public Optional<PersonResponse> get(final long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Optional<PersonResponse> update(final long id, final PersonRequest personRequest) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }

        final var entity = mapper.toEntity(personRequest);
        entity.setId(id);

        return Optional.of(mapper.toResponse(repository.save(entity)));
    }
}
