package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dao.FiestaDao;
import com.proyectocalendar.birthdaycalendar.models.Fiesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"*"})
public class FiestaController {

    @Autowired // LLama a FiestaDao, Hace directamente una inyeccion de dependencias
    private FiestaDao fiestaDao;

    @GetMapping(value = "fiestas/{id}")
    public List<Fiesta> getFiestasPorUsuario(@PathVariable("id") Long usuarioId) {
        return fiestaDao.getFiestasPorUsuario(usuarioId);
    }

    @GetMapping(value = "fiesta/{id}")
    public List<Fiesta> getFiesta(@PathVariable("id") Long fiestaId) {
        return fiestaDao.getFiesta(fiestaId);
    }

    @PostMapping(value = "fiestas/add")
    public Fiesta addFiesta (@RequestBody Fiesta fiesta) { // @RequestBody - Convierte el JSON que recibe a un usuario automaticamente
        //fiesta.setUsuarioId(1);
        fiestaDao.addFiesta(fiesta);
        return fiesta;
    }

    @DeleteMapping(value = "fiestas/eliminar/{id}")
    public Fiesta eliminarFiesta(@PathVariable("id") Long fiestaId) {
        Fiesta fiesta = fiestaDao.eliminarFiesta(fiestaId);
        return fiesta;
    }

}
