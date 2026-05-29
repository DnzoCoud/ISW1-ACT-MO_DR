package com.unbosque.financialsystem.mappers;

import com.unbosque.financialsystem.dto.request.ClienteRequestDTO;
import com.unbosque.financialsystem.dto.response.ClienteResponseDTO;
import com.unbosque.financialsystem.models.Cliente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-28T12:19:26-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNumeroIdentificacion( dto.getNumeroIdentificacion() );
        cliente.setPrimerNombre( dto.getPrimerNombre() );
        cliente.setSegundoNombre( dto.getSegundoNombre() );
        cliente.setPrimerApellido( dto.getPrimerApellido() );
        cliente.setSegundoApellido( dto.getSegundoApellido() );
        cliente.setCorreoElectronico( dto.getCorreoElectronico() );

        return cliente;
    }

    @Override
    public ClienteResponseDTO toDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();

        clienteResponseDTO.setNumeroIdentificacion( cliente.getNumeroIdentificacion() );
        clienteResponseDTO.setCorreoElectronico( cliente.getCorreoElectronico() );

        clienteResponseDTO.setNombreCompleto( cliente.getPrimerNombre() + " " + cliente.getPrimerApellido() );

        return clienteResponseDTO;
    }
}
