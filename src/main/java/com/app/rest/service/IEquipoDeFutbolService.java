package com.app.rest.service;

import com.app.rest.entities.EquipoDeFutbol;

import java.util.List;
import java.util.Optional;

public interface IEquipoDeFutbolService {
    Optional<EquipoDeFutbol> findById(Long id);
    List<EquipoDeFutbol> findAll();
    void save(EquipoDeFutbol equipo);
    void deleteById(Long id);
}
