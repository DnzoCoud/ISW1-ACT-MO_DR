package com.unbosque.financialsystem.repositories;

import com.unbosque.financialsystem.models.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, String> {
    boolean existsByNumero(String numero);
    List<Tarjeta> findByCliente_NumeroIdentificacion(String clienteId);
    Optional<Tarjeta> findByNumeroAndEstado(String numero, String estado);
}