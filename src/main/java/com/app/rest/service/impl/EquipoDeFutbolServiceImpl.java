package com.app.rest.service.impl;

import com.app.rest.entities.EquipoDeFutbol;
import com.app.rest.persistece.IEquipoDeFutbolDAO;
import com.app.rest.service.IEquipoDeFutbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoDeFutbolServiceImpl implements IEquipoDeFutbolService {

    @Autowired
    private IEquipoDeFutbolDAO equipoDAO;

    @Override
    public Optional<EquipoDeFutbol> findById(Long id) {
        return equipoDAO.findById(id);
    }

    @Override
    public List<EquipoDeFutbol> findAll() {
        return equipoDAO.findAll();
    }

    @Override
    public void save(EquipoDeFutbol equipo) {
        equipoDAO.save(equipo);
    }

    @Override
    public void deleteById(Long id) {
        equipoDAO.deleteById(id);
    }
}
