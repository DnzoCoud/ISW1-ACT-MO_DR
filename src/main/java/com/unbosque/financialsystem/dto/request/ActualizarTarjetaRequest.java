package com.unbosque.financialsystem.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ActualizarTarjetaRequest(

        @NotNull
        BigDecimal cupoTotal
) {
}
