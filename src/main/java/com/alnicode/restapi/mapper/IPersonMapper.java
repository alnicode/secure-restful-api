package com.alnicode.restapi.mapper;

import com.alnicode.restapi.dto.PersonRequest;
import com.alnicode.restapi.dto.PersonResponse;
import com.alnicode.restapi.entity.Person;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPersonMapper {
    @Mapping(target = "address", expression = "java(entity.getDirection().getFullAddress())")
    PersonResponse toResponse(Person entity);
    List<PersonResponse> toResponses(List<Person> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "direction", ignore = true)
    Person toEntity(PersonRequest request);
}
