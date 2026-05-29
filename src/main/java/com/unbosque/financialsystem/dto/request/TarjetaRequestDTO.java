package com.unbosque.financialsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class TarjetaRequestDTO {
    @NotBlank
    private String numero;

    @NotBlank
    private String fechaVencimiento; // MM/YYYY

    @NotNull
    @Positive
    private BigDecimal cupoTotal;

    @NotNull
    @Positive
    private BigDecimal cupoDisponible;
}