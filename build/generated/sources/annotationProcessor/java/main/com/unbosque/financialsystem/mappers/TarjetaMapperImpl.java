package com.unbosque.financialsystem.mappers;

import com.unbosque.financialsystem.dto.request.TarjetaRequestDTO;
import com.unbosque.financialsystem.dto.response.TarjetaResponseDTO;
import com.unbosque.financialsystem.models.Franquicia;
import com.unbosque.financialsystem.models.Tarjeta;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-28T23:40:10-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-9.4.1.jar, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class TarjetaMapperImpl implements TarjetaMapper {

    @Override
    public Tarjeta toEntity(TarjetaRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tarjeta.TarjetaBuilder tarjeta = Tarjeta.builder();

        tarjeta.numero( dto.getNumero() );
        tarjeta.fechaVencimiento( dto.getFechaVencimiento() );
        tarjeta.cupoTotal( dto.getCupoTotal() );
        tarjeta.cupoDisponible( dto.getCupoDisponible() );

        return tarjeta.build();
    }

    @Override
    public TarjetaResponseDTO toDto(Tarjeta tarjeta) {
        if ( tarjeta == null ) {
            return null;
        }

        TarjetaResponseDTO tarjetaResponseDTO = new TarjetaResponseDTO();

        tarjetaResponseDTO.setFranquicia( tarjetaFranquiciaNombre( tarjeta ) );
        tarjetaResponseDTO.setNumero( tarjeta.getNumero() );
        tarjetaResponseDTO.setFechaVencimiento( tarjeta.getFechaVencimiento() );
        tarjetaResponseDTO.setEstado( tarjeta.getEstado() );
        tarjetaResponseDTO.setCupoTotal( tarjeta.getCupoTotal() );
        tarjetaResponseDTO.setCupoDisponible( tarjeta.getCupoDisponible() );
        tarjetaResponseDTO.setCupoUtilizado( tarjeta.getCupoUtilizado() );

        return tarjetaResponseDTO;
    }

    private String tarjetaFranquiciaNombre(Tarjeta tarjeta) {
        Franquicia franquicia = tarjeta.getFranquicia();
        if ( franquicia == null ) {
            return null;
        }
        return franquicia.getNombre();
    }
}
