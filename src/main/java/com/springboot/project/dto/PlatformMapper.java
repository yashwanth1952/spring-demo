package com.springboot.project.dto;

import com.springboot.project.entity.Platform;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlatformMapper {

    PlatformMapper INSTANCE= Mappers.getMapper(PlatformMapper.class);

    PlatformDto toDto(Platform platform);

    List<PlatformDto> toDtos(List<Platform> platforms);

    Platform toEntity(PlatformDto platformDto);

}
