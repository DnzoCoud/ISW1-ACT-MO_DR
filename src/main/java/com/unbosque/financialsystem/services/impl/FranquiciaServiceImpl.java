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
    public String detectar(String numeroTarjeta) {
        if (numeroTarjeta.length() == 16 &&
                numeroTarjeta.startsWith("4")) {
            return "VISA";
        }

        if (numeroTarjeta.length() == 16) {

            int prefijo =
                    Integer.parseInt(
                            numeroTarjeta.substring(0, 2));

            if (prefijo >= 51 && prefijo <= 55) {
                return "MASTERCARD";
            }
        }

        if (numeroTarjeta.length() == 15 &&
                (numeroTarjeta.startsWith("34")
                        || numeroTarjeta.startsWith("37"))) {

            return "AMEX";
        }

        throw new IllegalArgumentException(
                "Franquicia no soportada");
    }
}