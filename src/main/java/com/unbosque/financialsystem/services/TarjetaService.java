package com.unbosque.financialsystem.services;

import com.unbosque.financialsystem.dto.request.ActualizarTarjetaRequest;
import com.unbosque.financialsystem.dto.request.CrearTarjetaRequest;
import com.unbosque.financialsystem.dto.request.TarjetaRequestDTO;
import com.unbosque.financialsystem.dto.response.TarjetaResponseDTO;
import com.unbosque.financialsystem.models.Tarjeta;

import java.math.BigDecimal;
import java.util.List;

public interface TarjetaService {
    Tarjeta crear(CrearTarjetaRequest request);
    List<Tarjeta> listar();
    Tarjeta actualizarCupo(
            String numero,
            ActualizarTarjetaRequest request);
    void eliminar(String numero);
}