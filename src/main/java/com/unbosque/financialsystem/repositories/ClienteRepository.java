package com.unbosque.financialsystem.repositories;

import com.unbosque.financialsystem.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    boolean existsByNumeroIdentificacion(String numeroIdentificacion);
    boolean existsByCorreoElectronico(String correoElectronico);
    Optional<Cliente> findByCorreoElectronico(String correoElectronico);
}