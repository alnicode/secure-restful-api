package com.alnicode.restapi.repository;

import com.alnicode.restapi.entity.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDirectionRepository extends JpaRepository<Direction, Long> {
}
