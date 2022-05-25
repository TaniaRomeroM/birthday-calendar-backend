package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dto.FiestaDTO;
import com.proyectocalendar.birthdaycalendar.dto.Message;
import com.proyectocalendar.birthdaycalendar.service.FiestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin({"*"})
public class FiestaController {

    @Autowired // LLama a FiestaDao, Hace directamente una inyeccion de dependencias
    private FiestaService fiestaService;

    @GetMapping(value = "fiestas/{nombreUsuario}")
    public ResponseEntity<List<FiestaDTO>> getFiestasPorNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
        return new ResponseEntity<List<FiestaDTO>>(fiestaService.getFiestasPorUsuario(nombreUsuario), HttpStatus.OK);
    }

    @GetMapping(value = "fiesta/{id}")
    public ResponseEntity<List<FiestaDTO>> getFiesta(@PathVariable("id") Long fiestaId) {
        return new ResponseEntity<List<FiestaDTO>>(fiestaService.getFiesta(fiestaId), HttpStatus.OK);
    }

    @PostMapping(value = "fiestas/add")
    public ResponseEntity<?> addFiesta (@Valid @RequestBody FiestaDTO fiestaDTO, BindingResult bindingResult) { // @RequestBody - Convierte el JSON que recibe a un usuario automaticamente
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Campos erróneos"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<FiestaDTO>(fiestaService.addFiesta(fiestaDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "fiestas/eliminar/{id}")
    public ResponseEntity<FiestaDTO> eliminarFiesta(@PathVariable("id") Long fiestaId) {
        return new ResponseEntity<FiestaDTO>(fiestaService.eliminarFiesta(fiestaId), HttpStatus.OK);
    }
}
