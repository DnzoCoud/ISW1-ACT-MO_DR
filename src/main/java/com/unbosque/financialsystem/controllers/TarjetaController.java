package com.unbosque.financialsystem.controllers;

import com.unbosque.financialsystem.dto.request.ActualizarTarjetaRequest;
import com.unbosque.financialsystem.dto.request.CrearTarjetaRequest;
import com.unbosque.financialsystem.models.Tarjeta;
import com.unbosque.financialsystem.services.TarjetaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarjetas")
@RequiredArgsConstructor
public class TarjetaController {

    private final TarjetaService service;

    @PostMapping
    public Tarjeta crear(
            @Valid
            @RequestBody CrearTarjetaRequest request) {

        return service.crear(request);
    }

    @GetMapping
    public List<Tarjeta> listar() {
        return service.listar();
    }

    @PutMapping("/{numero}")
    public Tarjeta actualizar(
            @PathVariable String numero,
            @RequestBody ActualizarTarjetaRequest request) {

        return service.actualizarCupo(
                numero,
                request);
    }

    @DeleteMapping("/{numero}")
    public void eliminar(
            @PathVariable String numero) {

        service.eliminar(numero);
    }
}