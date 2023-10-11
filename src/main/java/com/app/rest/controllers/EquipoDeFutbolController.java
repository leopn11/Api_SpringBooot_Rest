package com.app.rest.controllers;

import com.app.rest.controllers.dto.EquipoDeFutbolDTO;
import com.app.rest.entities.EquipoDeFutbol;
import com.app.rest.service.IEquipoDeFutbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipo")
public class EquipoDeFutbolController {

    @Autowired
    private IEquipoDeFutbolService equipoService;

    @GetMapping("/busca/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

      Optional<EquipoDeFutbol> equipoOptional = equipoService.findById(id);

      if(equipoOptional.isPresent()) {
        EquipoDeFutbol equipo = equipoOptional.get();

          EquipoDeFutbolDTO equipoDTO = EquipoDeFutbolDTO.builder()
                  .id(equipo.getId())
                  .nombre(equipo.getNombre())
                  .jugadorDeFutbolList(equipo.getJugadorDeFutbolList())
                  .build();

          return  ResponseEntity.ok(equipoDTO);
      }
      return  ResponseEntity.notFound().build();
    }

    @GetMapping("/todos")
    public ResponseEntity<?> findALl() {
        List<EquipoDeFutbolDTO> equipoList = equipoService.findAll()
                .stream()
                .map(equipo -> EquipoDeFutbolDTO.builder()
                        .id(equipo.getId())
                        .nombre(equipo.getNombre())
                        .jugadorDeFutbolList(equipo.getJugadorDeFutbolList())
                                .build())
                .toList();

        return ResponseEntity.ok(equipoList);

    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody EquipoDeFutbolDTO equipoDTO) throws URISyntaxException {
        if (equipoDTO.getNombre().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        equipoService.save(EquipoDeFutbol.builder()
                .nombre(equipoDTO.getNombre()).build());

        return ResponseEntity.created(new URI("/api/equipo/guardar")).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateEquipo(@PathVariable Long id, @RequestBody EquipoDeFutbolDTO equipoDTO){

        Optional<EquipoDeFutbol> equipoOptional = equipoService.findById(id);
        if (equipoOptional.isPresent()){
            EquipoDeFutbol equipo = equipoOptional.get();
            equipo.setNombre(equipoDTO.getNombre());
            equipoService.save(equipo);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id != null) {
            equipoService.deleteById(id);
            return ResponseEntity.ok("Registro Elimiado");
        }
        return ResponseEntity.badRequest().build();
    }
}
