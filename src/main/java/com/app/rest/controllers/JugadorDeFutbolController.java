package com.app.rest.controllers;

import com.app.rest.controllers.dto.JugadorDeFutbolDTO;
import com.app.rest.entities.JugadorDeFutbol;
import com.app.rest.service.IJugadorDeFutbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jugador")
public class JugadorDeFutbolController {

    @Autowired
    private IJugadorDeFutbolService jugadorService;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<JugadorDeFutbol> jugadorOptional = jugadorService.findById(id);
        if(jugadorOptional.isPresent()) {

            JugadorDeFutbol jugador = jugadorOptional.get();
            JugadorDeFutbolDTO jugadorDTO = JugadorDeFutbolDTO.builder()
                    .id(jugador.getId())
                    .nombres(jugador.getNombres())
                    .precio(jugador.getPrecio())
                    .equipo(jugador.getEquipo())
                    .build();

            return ResponseEntity.ok(jugadorDTO);
        }
            return ResponseEntity.badRequest().build();
    }

    @GetMapping("/todos")
    public ResponseEntity<?> findAll(){
        List<JugadorDeFutbolDTO> jugadorList = jugadorService.findAll()
                .stream()
                .map(jugadorDeFutbol -> JugadorDeFutbolDTO.builder()
                        .id(jugadorDeFutbol.getId())
                        .nombres(jugadorDeFutbol.getNombres())
                        .precio(jugadorDeFutbol.getPrecio())
                        .equipo(jugadorDeFutbol.getEquipo())
                        .build())
                .toList();

        return ResponseEntity.ok(jugadorList);

    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody JugadorDeFutbolDTO jugadorDTO) throws URISyntaxException {
        if(jugadorDTO.getNombres().isBlank() || jugadorDTO.getPrecio() == null || jugadorDTO.getEquipo() == null) {
            return ResponseEntity.badRequest().build();
        }

        JugadorDeFutbol jugador = JugadorDeFutbol.builder()
                .nombres(jugadorDTO.getNombres())
                .precio(jugadorDTO.getPrecio())
                .equipo(jugadorDTO.getEquipo())
                .build();

        jugadorService.save(jugador);

        return ResponseEntity.created(new URI("/api/jugador/guardar")).build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody JugadorDeFutbolDTO jugadorDTO) {
        Optional<JugadorDeFutbol> jugadorOptional = jugadorService.findById(id);
        if (jugadorOptional.isPresent()) {
            JugadorDeFutbol jugador = jugadorOptional.get();
            jugador.setNombres(jugadorDTO.getNombres());
            jugador.setEquipo(jugadorDTO.getEquipo());
            jugador.setPrecio(jugadorDTO.getPrecio());

            jugadorService.save(jugador);

            return ResponseEntity.ok("actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if (id != null) {
            jugadorService.delete(id);
            return ResponseEntity.ok("Registro Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
