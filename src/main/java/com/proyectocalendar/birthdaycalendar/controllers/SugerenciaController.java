package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dao.SugerenciaDao;
import com.proyectocalendar.birthdaycalendar.dto.SugerenciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"*"})
public class SugerenciaController {

    @Autowired // LLama a SugerenciaDao, Hace directamente una inyeccion de dependencias
    private SugerenciaDao sugerenciaDao;

    //@PreAuthorize("hasRole('ADMIN')") // Para que solo pueda hacer esta peticion el admin
    @GetMapping(value = "sugerencias")
    public ResponseEntity<List<SugerenciaDTO>> getSugerencias() {
        return new ResponseEntity<List<SugerenciaDTO>>(sugerenciaDao.getSugerencias(), HttpStatus.OK);
    }

    @GetMapping(value = "sugerencias/{nombreUsuario}")
    public ResponseEntity<List<SugerenciaDTO>> getSugerenciasPorNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
        return new ResponseEntity<List<SugerenciaDTO>>(sugerenciaDao.getSugerenciasPorUsuario(nombreUsuario), HttpStatus.OK);
    }

    @PostMapping(value = "sugerencias/add")
    public ResponseEntity<SugerenciaDTO> addSugerencia (@RequestBody SugerenciaDTO sugerenciaDTO) { // @RequestBody - Convierte el JSON que recibe a una sugerencia automaticamente
        return new ResponseEntity<SugerenciaDTO>(sugerenciaDao.addSugerencia(sugerenciaDTO), HttpStatus.CREATED);
    }
}
