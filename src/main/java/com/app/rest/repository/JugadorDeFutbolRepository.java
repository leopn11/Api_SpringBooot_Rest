package com.app.rest.repository;

import com.app.rest.entities.JugadorDeFutbol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface JugadorDeFutbolRepository extends CrudRepository<JugadorDeFutbol, Long> {

    @Query("SELECT j FROM JugadorDeFutbol j WHERE j.precio BETWEEN ?1 AND ?2")
    List<JugadorDeFutbol> jugadorRango(BigDecimal minPrecio, BigDecimal maxPrecio);
}