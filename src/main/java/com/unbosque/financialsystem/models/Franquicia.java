package com.unbosque.financialsystem.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "franquicia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Franquicia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre; // "VISA", "MASTERCARD", "AMEX"
}