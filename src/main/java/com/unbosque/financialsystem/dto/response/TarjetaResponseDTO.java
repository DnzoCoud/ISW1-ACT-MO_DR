package com.unbosque.financialsystem.dto.response;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TarjetaResponseDTO {
    private String numero;
    private String fechaVencimiento;
    private String franquicia;     // nombre de la franquicia
    private String estado;
    private BigDecimal cupoTotal;
    private BigDecimal cupoDisponible;
    private BigDecimal cupoUtilizado;
}