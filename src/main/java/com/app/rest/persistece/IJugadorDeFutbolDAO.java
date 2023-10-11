package com.app.rest.persistece;

import com.app.rest.entities.JugadorDeFutbol;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IJugadorDeFutbolDAO {

    List<JugadorDeFutbol> findAll();
    List<JugadorDeFutbol> jugadorRango(BigDecimal minPrecio, BigDecimal maxPrecio);
    Optional<JugadorDeFutbol> findById(Long id);
    void save(JugadorDeFutbol jugador);
    void deleteById(Long id);
}
