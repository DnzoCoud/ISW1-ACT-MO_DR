package com.unbosque.financialsystem.mappers;

import com.unbosque.financialsystem.dto.request.ClienteRequestDTO;
import com.unbosque.financialsystem.dto.response.ClienteResponseDTO;
import com.unbosque.financialsystem.models.Cliente;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-28T23:40:10-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-9.4.1.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente.ClienteBuilder cliente = Cliente.builder();

        cliente.numeroIdentificacion( dto.getNumeroIdentificacion() );
        cliente.primerNombre( dto.getPrimerNombre() );
        cliente.segundoNombre( dto.getSegundoNombre() );
        cliente.primerApellido( dto.getPrimerApellido() );
        cliente.segundoApellido( dto.getSegundoApellido() );
        cliente.correoElectronico( dto.getCorreoElectronico() );

        return cliente.build();
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
