package com.unbosque.financialsystem;

import com.unbosque.financialsystem.models.Cliente;
import com.unbosque.financialsystem.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void shouldSaveClient() {

        Cliente cliente = Cliente.builder()
                .numeroIdentificacion("123456")
                .primerNombre("Juan")
                .primerApellido("Perez")
                .correoElectronico("juan@test.com")
                .build();

        Cliente saved = clienteRepository.save(cliente);

        assertNotNull(saved);
        assertEquals(
                "123456",
                saved.getNumeroIdentificacion()
        );
    }
}