package com.unbosque.financialsystem.mappers;

import com.unbosque.financialsystem.dto.request.ClienteRequestDTO;
import com.unbosque.financialsystem.dto.response.ClienteResponseDTO;
import com.unbosque.financialsystem.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente toEntity(ClienteRequestDTO dto);

    @Mapping(target = "nombreCompleto", expression = "java(cliente.getPrimerNombre() + \" \" + cliente.getPrimerApellido())")
    ClienteResponseDTO toDto(Cliente cliente);
}