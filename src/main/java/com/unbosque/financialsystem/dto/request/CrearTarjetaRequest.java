package com.unbosque.financialsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record CrearTarjetaRequest(

        @NotBlank
        String numero,

        @Pattern(
                regexp = "^(0[1-9]|1[0-2])/\\d{4}$"
        )
        String fechaVencimiento,

        @NotNull
        BigDecimal cupoTotal,

        @NotNull
        BigDecimal cupoDisponible,

        @NotBlank
        String numeroIdentificacionCliente
) {
}
