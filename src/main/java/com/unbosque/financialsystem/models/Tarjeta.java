package com.unbosque.financialsystem.models;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tarjeta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarjeta {

    @Id
    private String numero;

    @Column(name = "fecha_vencimiento", nullable = false)
    private String fechaVencimiento;

    @Column(name = "cupo_total", nullable = false)
    private BigDecimal cupoTotal;

    @Column(name = "cupo_disponible", nullable = false)
    private BigDecimal cupoDisponible;

    @Column(name = "cupo_utilizado")
    private BigDecimal cupoUtilizado;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "franquicia_id")
    private Franquicia franquicia;
}