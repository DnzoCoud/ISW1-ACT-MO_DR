package com.unbosque.financialsystem.services;

import com.unbosque.financialsystem.dto.request.ClienteRequestDTO;
import com.unbosque.financialsystem.dto.request.CrearClienteRequest;
import com.unbosque.financialsystem.dto.response.ClienteResponseDTO;
import com.unbosque.financialsystem.models.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente crear(CrearClienteRequest request);
    List<Cliente> listar();
}