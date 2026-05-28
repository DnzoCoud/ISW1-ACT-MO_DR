package com.unbosque.financialsystem.services.impl;

import com.unbosque.financialsystem.dto.request.TarjetaRequestDTO;
import com.unbosque.financialsystem.dto.response.TarjetaResponseDTO;
import com.unbosque.financialsystem.services.TarjetaService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TarjetaServiceImpl implements TarjetaService {
    @Override
    public TarjetaResponseDTO registrarTarjeta(String clienteId, TarjetaRequestDTO request) {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<TarjetaResponseDTO> listarTarjetasPorCliente(String clienteId) {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public void modificarCupoTotal(String numeroTarjeta, BigDecimal nuevoCupoTotal) {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public void eliminarTarjeta(String numeroTarjeta) {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }
}