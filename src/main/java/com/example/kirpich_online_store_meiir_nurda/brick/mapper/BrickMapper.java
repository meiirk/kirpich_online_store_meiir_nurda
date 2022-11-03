package com.example.kirpich_online_store_meiir_nurda.brick.mapper;

import com.example.kirpich_online_store_meiir_nurda.brick.model.Brick;
import com.example.kirpich_online_store_meiir_nurda.brick.model.BrickDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(builder = @Builder(disableBuilder = true),
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BrickMapper {
    BrickMapper INSTANCE = Mappers.getMapper(BrickMapper.class);

    Brick toDtoEntity(BrickDto entity);
}
