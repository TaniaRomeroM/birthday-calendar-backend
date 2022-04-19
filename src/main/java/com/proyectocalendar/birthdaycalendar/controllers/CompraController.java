package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dao.CompraDao;
import com.proyectocalendar.birthdaycalendar.models.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"*"})
public class CompraController {

    @Autowired
    private CompraDao compraDao;

    @GetMapping(value = "compras/{id}")
    public List<Compra> getComprasPorFiesta(@PathVariable("id") Long fiestaId) {
        return compraDao.getComprasPorFiesta(fiestaId);
    }

    @PostMapping(value = "compras/add")
    public Compra addCompra (@RequestBody Compra compra) {
        //fiesta.setUsuarioId(1);
        compraDao.addCompra(compra);
        return compra;
    }

    @DeleteMapping(value = "compras/eliminar/{id}")
    public Compra eliminarCompra(@PathVariable("id") Long compraId) {
        Compra compra = compraDao.eliminarCompra(compraId);
        return compra;
    }

}
