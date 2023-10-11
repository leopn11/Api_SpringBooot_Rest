package com.app.rest.persistece.impl;

import com.app.rest.entities.EquipoDeFutbol;
import com.app.rest.persistece.IEquipoDeFutbolDAO;
import com.app.rest.repository.EquipoDeFutbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EquipoDeFutbolDAOImpl implements IEquipoDeFutbolDAO {

    @Autowired
    private EquipoDeFutbolRepository equipoRepository;

    @Override
    public Optional<EquipoDeFutbol> findById(Long id) {
        return equipoRepository.findById(id);
    }

    @Override
    public List<EquipoDeFutbol> findAll() {
        return (List<EquipoDeFutbol>) equipoRepository.findAll();
    }

    @Override
    public void save(EquipoDeFutbol equipo) {
        equipoRepository.save(equipo);
    }

    @Override
    public void deleteById(Long id) {
        equipoRepository.deleteById(id);
    }
}
