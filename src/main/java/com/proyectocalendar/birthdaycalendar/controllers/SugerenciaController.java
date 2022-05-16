package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dto.Message;
import com.proyectocalendar.birthdaycalendar.dto.SugerenciaDTO;
import com.proyectocalendar.birthdaycalendar.service.SugerenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sugerencias")
@CrossOrigin({"*"})
public class SugerenciaController {

    @Autowired // LLama a SugerenciaDao, Hace directamente una inyeccion de dependencias
    private SugerenciaService sugerenciaService;

    @PreAuthorize("hasRole('ADMIN')") // Para que solo pueda hacer esta peticion el admin
    @GetMapping(value = "/")
    public ResponseEntity<List<SugerenciaDTO>> getSugerencias() {
        return new ResponseEntity<List<SugerenciaDTO>>(sugerenciaService.getSugerencias(), HttpStatus.OK);
    }

    @GetMapping(value = "/{nombreUsuario}")
    public ResponseEntity<List<SugerenciaDTO>> getSugerenciasPorNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
        return new ResponseEntity<List<SugerenciaDTO>>(sugerenciaService.getSugerenciasPorUsuario(nombreUsuario), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addSugerencia (@Valid @RequestBody SugerenciaDTO sugerenciaDTO,  BindingResult bindingResult) { // @RequestBody - Convierte el JSON que recibe a una sugerencia automaticamente
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Campos erróneos"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<SugerenciaDTO>(sugerenciaService.addSugerencia(sugerenciaDTO), HttpStatus.CREATED);
    }
}
