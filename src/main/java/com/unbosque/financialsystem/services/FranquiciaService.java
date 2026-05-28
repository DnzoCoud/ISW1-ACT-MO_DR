package com.unbosque.financialsystem.services;

import com.unbosque.financialsystem.models.Franquicia;
import java.util.List;

public interface FranquiciaService {
    List<Franquicia> listarTodas();
    void cargarFranquiciasIniciales();
}