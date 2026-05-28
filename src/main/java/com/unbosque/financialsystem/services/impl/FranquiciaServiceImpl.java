package com.unbosque.financialsystem.services.impl;

import com.unbosque.financialsystem.models.Franquicia;
import com.unbosque.financialsystem.repositories.FranquiciaRepository;
import com.unbosque.financialsystem.services.FranquiciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FranquiciaServiceImpl implements FranquiciaService {
    private final FranquiciaRepository franquiciaRepository;

    @Override
    public List<Franquicia> listarTodas() {
        return franquiciaRepository.findAll();
    }

    @Override
    public void cargarFranquiciasIniciales() {
        if (franquiciaRepository.count() == 0) {
            franquiciaRepository.save(new Franquicia(null, "VISA"));
            franquiciaRepository.save(new Franquicia(null, "MASTERCARD"));
            franquiciaRepository.save(new Franquicia(null, "AMEX"));
        }
    }
}