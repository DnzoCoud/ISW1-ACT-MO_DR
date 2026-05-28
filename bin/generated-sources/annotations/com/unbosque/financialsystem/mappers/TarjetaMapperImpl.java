package com.unbosque.financialsystem.mappers;

import com.unbosque.financialsystem.dto.request.TarjetaRequestDTO;
import com.unbosque.financialsystem.dto.response.TarjetaResponseDTO;
import com.unbosque.financialsystem.models.Franquicia;
import com.unbosque.financialsystem.models.Tarjeta;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-28T12:19:30-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class TarjetaMapperImpl implements TarjetaMapper {

    @Override
    public Tarjeta toEntity(TarjetaRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tarjeta tarjeta = new Tarjeta();

        tarjeta.setNumero( dto.getNumero() );
        tarjeta.setFechaVencimiento( dto.getFechaVencimiento() );
        tarjeta.setCupoTotal( dto.getCupoTotal() );
        tarjeta.setCupoDisponible( dto.getCupoDisponible() );

        return tarjeta;
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
