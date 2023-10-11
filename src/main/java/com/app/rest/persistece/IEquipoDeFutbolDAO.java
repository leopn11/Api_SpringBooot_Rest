package com.app.rest.persistece;

import com.app.rest.entities.EquipoDeFutbol;

import java.util.List;
import java.util.Optional;

public interface IEquipoDeFutbolDAO {

    Optional<EquipoDeFutbol> findById(Long id);
    List<EquipoDeFutbol> findAll();
    void save(EquipoDeFutbol equipo);
    void deleteById(Long id);
}
