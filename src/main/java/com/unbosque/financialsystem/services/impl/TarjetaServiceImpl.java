package com.unbosque.financialsystem.services.impl;

import com.unbosque.financialsystem.dto.request.ActualizarTarjetaRequest;
import com.unbosque.financialsystem.dto.request.CrearTarjetaRequest;
import com.unbosque.financialsystem.dto.request.TarjetaRequestDTO;
import com.unbosque.financialsystem.dto.response.TarjetaResponseDTO;
import com.unbosque.financialsystem.models.Cliente;
import com.unbosque.financialsystem.models.Franquicia;
import com.unbosque.financialsystem.models.Tarjeta;
import com.unbosque.financialsystem.repositories.ClienteRepository;
import com.unbosque.financialsystem.repositories.FranquiciaRepository;
import com.unbosque.financialsystem.repositories.TarjetaRepository;
import com.unbosque.financialsystem.services.FranquiciaService;
import com.unbosque.financialsystem.services.TarjetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarjetaServiceImpl implements TarjetaService {
    private final TarjetaRepository tarjetaRepository;
    private final ClienteRepository clienteRepository;
    private final FranquiciaRepository franquiciaRepository;
    private final FranquiciaService franquiciaService;

    @Override
    public Tarjeta crear(CrearTarjetaRequest request) {
        if (tarjetaRepository.existsById(
                request.numero())) {

            throw new RuntimeException(
                    "La tarjeta ya existe");
        }

        Cliente cliente =
                clienteRepository.findById(
                                request.numeroIdentificacionCliente())
                        .orElseThrow();

        String nombreFranquicia =
                franquiciaService.detectar(
                        request.numero());

        Franquicia franquicia =
                franquiciaRepository.findByNombre(
                                nombreFranquicia)
                        .orElseThrow();

        BigDecimal cupoUtilizado =
                request.cupoTotal()
                        .subtract(
                                request.cupoDisponible());

        Tarjeta tarjeta = Tarjeta.builder()
                .numero(request.numero())
                .fechaVencimiento(
                        request.fechaVencimiento())
                .cupoTotal(
                        request.cupoTotal())
                .cupoDisponible(
                        request.cupoDisponible())
                .cupoUtilizado(
                        cupoUtilizado)
                .estado("ACTIVO")
                .cliente(cliente)
                .franquicia(franquicia)
                .build();

        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public List<Tarjeta> listar() {
        return tarjetaRepository.findAll();
    }

    @Override
    public Tarjeta actualizarCupo(String numero, ActualizarTarjetaRequest request) {
        Tarjeta tarjeta =
                tarjetaRepository.findById(numero)
                        .orElseThrow(() -> new RuntimeException("La tarjeta no existe"));

        tarjeta.setCupoTotal(
                request.cupoTotal());

        tarjeta.setCupoUtilizado(
                request.cupoTotal()
                        .subtract(
                                tarjeta.getCupoDisponible()));

        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public void eliminar(String numero) {
        Tarjeta tarjeta =
                tarjetaRepository.findById(numero)
                        .orElseThrow();

        tarjeta.setEstado("INACTIVO");

        tarjetaRepository.save(tarjeta);
    }
}