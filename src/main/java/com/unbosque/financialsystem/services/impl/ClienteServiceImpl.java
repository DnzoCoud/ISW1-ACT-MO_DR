package com.unbosque.financialsystem.services.impl;

import com.unbosque.financialsystem.dto.request.ClienteRequestDTO;
import com.unbosque.financialsystem.dto.response.ClienteResponseDTO;
import com.unbosque.financialsystem.services.ClienteService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Override
    public ClienteResponseDTO registrarCliente(ClienteRequestDTO request) {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<ClienteResponseDTO> listarClientes() {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public ClienteResponseDTO obtenerClientePorId(String id) {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }
}