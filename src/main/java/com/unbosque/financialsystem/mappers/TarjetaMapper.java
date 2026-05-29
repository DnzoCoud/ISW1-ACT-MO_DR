package com.unbosque.financialsystem.mappers;

import com.unbosque.financialsystem.dto.request.TarjetaRequestDTO;
import com.unbosque.financialsystem.dto.response.TarjetaResponseDTO;
import com.unbosque.financialsystem.models.Tarjeta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TarjetaMapper {
    TarjetaMapper INSTANCE = Mappers.getMapper(TarjetaMapper.class);

    Tarjeta toEntity(TarjetaRequestDTO dto);

    @Mapping(target = "franquicia", source = "franquicia.nombre")
    TarjetaResponseDTO toDto(Tarjeta tarjeta);
}