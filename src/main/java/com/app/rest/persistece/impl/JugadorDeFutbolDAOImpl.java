package com.app.rest.persistece.impl;

import com.app.rest.entities.JugadorDeFutbol;
import com.app.rest.persistece.IJugadorDeFutbolDAO;
import com.app.rest.repository.JugadorDeFutbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class JugadorDeFutbolDAOImpl implements IJugadorDeFutbolDAO {

    @Autowired
    private JugadorDeFutbolRepository jugadorRepository;

    @Override
    public List<JugadorDeFutbol> findAll() {
        return (List<JugadorDeFutbol>) jugadorRepository.findAll();
    }

    @Override
    public List<JugadorDeFutbol> jugadorRango(BigDecimal minPrecio, BigDecimal maxPrecio) {
        return jugadorRepository.jugadorRango(minPrecio, maxPrecio);
    }

    @Override
    public Optional<JugadorDeFutbol> findById(Long id) {
        return jugadorRepository.findById(id);
    }

    @Override
    public void save(JugadorDeFutbol jugador) {
        jugadorRepository.save(jugador);
    }

    @Override
    public void deleteById(Long id) {
        jugadorRepository.deleteById(id);
    }
}
