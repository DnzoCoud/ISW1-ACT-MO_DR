package com.unbosque.financialsystem.services;

import com.unbosque.financialsystem.dto.request.TarjetaRequestDTO;
import com.unbosque.financialsystem.dto.response.TarjetaResponseDTO;
import java.math.BigDecimal;
import java.util.List;

public interface TarjetaService {
    TarjetaResponseDTO registrarTarjeta(String clienteId, TarjetaRequestDTO request);
    List<TarjetaResponseDTO> listarTarjetasPorCliente(String clienteId);
    void modificarCupoTotal(String numeroTarjeta, BigDecimal nuevoCupoTotal);
    void eliminarTarjeta(String numeroTarjeta);
}