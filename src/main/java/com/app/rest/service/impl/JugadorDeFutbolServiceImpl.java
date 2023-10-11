package com.app.rest.service.impl;

import com.app.rest.entities.JugadorDeFutbol;
import com.app.rest.persistece.IJugadorDeFutbolDAO;
import com.app.rest.service.IJugadorDeFutbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorDeFutbolServiceImpl implements IJugadorDeFutbolService {

    @Autowired
    private IJugadorDeFutbolDAO jugadorDAO;

    @Override
    public List<JugadorDeFutbol> findAll() {
        return jugadorDAO.findAll();
    }

    @Override
    public List<JugadorDeFutbol> jugadorRango(BigDecimal minPrecio, BigDecimal maxPrecio) {
        return jugadorDAO.jugadorRango(minPrecio, maxPrecio);
    }

    @Override
    public Optional<JugadorDeFutbol> findById(Long id) {
        return jugadorDAO.findById(id);
    }

    @Override
    public void save(JugadorDeFutbol jugador) {
        jugadorDAO.save(jugador);
    }

    @Override
    public void delete(Long id) {
        jugadorDAO.deleteById(id);
    }
}
