package com.alnicode.restapi.service;

import org.springframework.data.repository.CrudRepository;

public abstract class DeleteService<Entity> {
    protected abstract CrudRepository<Entity, Long> repository();

    public boolean delete(long id) {
        try {
            repository().deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
