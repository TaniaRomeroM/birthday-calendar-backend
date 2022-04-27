package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dao.FiestaDao;
import com.proyectocalendar.birthdaycalendar.dto.ContactoDTO;
import com.proyectocalendar.birthdaycalendar.dto.FiestaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"*"})
public class FiestaController {

    @Autowired // LLama a FiestaDao, Hace directamente una inyeccion de dependencias
    private FiestaDao fiestaDao;

   /* @GetMapping(value = "fiestas/{id}")
    public ResponseEntity<List<FiestaDTO>> getFiestasPorUsuario(@PathVariable("id") Long usuarioId) {
        return new ResponseEntity<List<FiestaDTO>>(fiestaDao.getFiestasPorUsuario(usuarioId), HttpStatus.OK);
    }*/

    @GetMapping(value = "fiestas/{nombreUsuario}")
    public ResponseEntity<List<FiestaDTO>> getFiestasPorNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
        return new ResponseEntity<List<FiestaDTO>>(fiestaDao.getFiestasPorUsuario(nombreUsuario), HttpStatus.OK);
    }

    @GetMapping(value = "fiesta/{id}")
    public ResponseEntity<List<FiestaDTO>> getFiesta(@PathVariable("id") Long fiestaId) {
        return new ResponseEntity<List<FiestaDTO>>(fiestaDao.getFiesta(fiestaId), HttpStatus.OK);
    }

    @PostMapping(value = "fiestas/add")
    public ResponseEntity<FiestaDTO> addFiesta (@RequestBody FiestaDTO fiestaDTO) { // @RequestBody - Convierte el JSON que recibe a un usuario automaticamente
        //fiesta.setUsuarioId(1);
        /*fiestaDao.addFiesta(fiesta);
        return fiesta;*/
        return new ResponseEntity<FiestaDTO>(fiestaDao.addFiesta(fiestaDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "fiestas/eliminar/{id}")
    public ResponseEntity<FiestaDTO> eliminarFiesta(@PathVariable("id") Long fiestaId) {
        /*Fiesta fiesta = fiestaDao.eliminarFiesta(fiestaId);
        return fiesta;*/
        return new ResponseEntity<FiestaDTO>(fiestaDao.eliminarFiesta(fiestaId), HttpStatus.OK);
    }
}
