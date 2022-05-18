package com.alnicode.restapi.controller;

import com.alnicode.restapi.service.ICrudService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
public abstract class CrudController<Request, Response> {
    protected abstract ICrudService<Request, Response> service();

    @GetMapping
    public ResponseEntity<List<Response>> getAll() {
        return ResponseEntity.ok(service().getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@NotNull @Min(1L) @PathVariable("id") long id) {
        return ResponseEntity.of(service().get(id));
    }

    @PostMapping
    public ResponseEntity<Response> register(@NotNull @Valid @RequestBody Request request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service().create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@NotNull @Valid @RequestBody Request request,
                                           @NotNull @Min(1L) @PathVariable("id") long id) {
        return ResponseEntity.of(service().update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@NotNull @Min(1L) @PathVariable("id") long id) {
        return service().delete(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
