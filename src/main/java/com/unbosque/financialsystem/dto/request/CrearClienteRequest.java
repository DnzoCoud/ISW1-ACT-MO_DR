package com.unbosque.financialsystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CrearClienteRequest(

        @NotBlank
        String numeroIdentificacion,

        @NotBlank
        String primerNombre,

        String segundoNombre,

        @NotBlank
        String primerApellido,

        String segundoApellido,

        @Email
        @NotBlank
        String correoElectronico
) {
}