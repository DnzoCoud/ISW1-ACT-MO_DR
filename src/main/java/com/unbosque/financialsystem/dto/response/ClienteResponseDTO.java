package com.unbosque.financialsystem.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class ClienteResponseDTO {
    private String numeroIdentificacion;
    private String nombreCompleto; // ej: "Juan Pérez"
    private String correoElectronico;
    private List<TarjetaResponseDTO> tarjetas;
}