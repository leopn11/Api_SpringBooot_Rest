package com.app.rest.controllers.dto;

import com.app.rest.entities.EquipoDeFutbol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JugadorDeFutbolDTO {
    private Long id;
    private String nombres;
    private BigDecimal precio;
    private EquipoDeFutbol equipo;

}
