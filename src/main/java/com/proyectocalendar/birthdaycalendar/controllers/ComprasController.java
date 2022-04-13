package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dao.ComprasDao;
import com.proyectocalendar.birthdaycalendar.models.Compras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"*"})
public class ComprasController {

    @Autowired
    private ComprasDao comprasDao;

    @GetMapping(value = "compras/{id}")
    public List<Compras> getComprasPorFiesta(@PathVariable("id") Long fiestaId) {
        return comprasDao.getComprasPorFiesta(fiestaId);
    }

    @PostMapping(value = "compras/add")
    public Compras addCompra (@RequestBody Compras compra) {
        //fiesta.setUsuarioId(1);
        comprasDao.addCompra(compra);
        return compra;
    }

    @DeleteMapping(value = "compras/eliminar/{id}")
    public void eliminarCompra(@PathVariable("id") Long compraId) {
        comprasDao.eliminarCompra(compraId);
    }
}
