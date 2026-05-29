package com.unbosque.financialsystem.services.impl;

import com.unbosque.financialsystem.dto.request.ClienteRequestDTO;
import com.unbosque.financialsystem.dto.request.CrearClienteRequest;
import com.unbosque.financialsystem.dto.response.ClienteResponseDTO;
import com.unbosque.financialsystem.models.Cliente;
import com.unbosque.financialsystem.repositories.ClienteRepository;
import com.unbosque.financialsystem.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository repository;

    @Override
    public Cliente crear(CrearClienteRequest request) {
        Cliente cliente = Cliente.builder()
                .numeroIdentificacion(
                        request.numeroIdentificacion())
                .primerNombre(
                        request.primerNombre())
                .segundoNombre(
                        request.segundoNombre())
                .primerApellido(
                        request.primerApellido())
                .segundoApellido(
                        request.segundoApellido())
                .correoElectronico(
                        request.correoElectronico())
                .build();

        return repository.save(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return repository.findAll();
    }
}