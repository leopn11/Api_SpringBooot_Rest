package com.app.rest.controllers.dto;

import com.app.rest.entities.JugadorDeFutbol;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipoDeFutbolDTO {

    private Long id;
    private String nombre;
    private List<JugadorDeFutbol> jugadorDeFutbolList = new ArrayList<>();

}
