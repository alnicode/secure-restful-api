package com.alnicode.restapi.mapper;

import com.alnicode.restapi.dto.DirectionRequest;
import com.alnicode.restapi.dto.DirectionResponse;
import com.alnicode.restapi.entity.Direction;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface iDirectionMapper {
    @Mapping(target = "owner", source = "person.name")
    DirectionResponse toResponse(Direction entity);
    List<DirectionResponse> toResponses(List<Direction> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "person", ignore = true)
    Direction toEntity(DirectionRequest request);
}
