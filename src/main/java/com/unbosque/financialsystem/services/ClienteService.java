package com.unbosque.financialsystem.services;

import com.unbosque.financialsystem.dto.request.ClienteRequestDTO;
import com.unbosque.financialsystem.dto.response.ClienteResponseDTO;
import java.util.List;

public interface ClienteService {
    ClienteResponseDTO registrarCliente(ClienteRequestDTO request);
    List<ClienteResponseDTO> listarClientes();
    ClienteResponseDTO obtenerClientePorId(String id);
}