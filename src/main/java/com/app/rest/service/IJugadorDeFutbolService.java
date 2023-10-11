package com.app.rest.service;

import com.app.rest.entities.JugadorDeFutbol;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IJugadorDeFutbolService {
    List<JugadorDeFutbol> findAll();
    List<JugadorDeFutbol> jugadorRango(BigDecimal minPrecio, BigDecimal maxPrecio);
    Optional<JugadorDeFutbol> findById(Long id);
    void save(JugadorDeFutbol jugador);
    void delete(Long id);
}
