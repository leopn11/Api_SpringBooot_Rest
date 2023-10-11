package com.app.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "jugador")
public class JugadorDeFutbol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    @JsonIgnore
    private EquipoDeFutbol equipo;


}
