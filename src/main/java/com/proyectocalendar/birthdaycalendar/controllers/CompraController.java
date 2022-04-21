package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dao.CompraDao;
import com.proyectocalendar.birthdaycalendar.dto.CompraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"*"})
public class CompraController {

    @Autowired
    private CompraDao compraDao;

    @GetMapping(value = "compras/{id}")
    public ResponseEntity<List<CompraDTO>> getComprasPorFiesta(@PathVariable("id") Long fiestaId) {
        return new ResponseEntity<List<CompraDTO>>(compraDao.getComprasPorFiesta(fiestaId), HttpStatus.OK);
    }

    @PostMapping(value = "compras/add")
    public ResponseEntity<CompraDTO> addCompra (@RequestBody CompraDTO compraDTO) {
        //fiesta.setUsuarioId(1);
        /*compraDao.(compra);
        return compra;*/
        return new ResponseEntity<CompraDTO>(compraDao.addCompra(compraDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "compras/eliminar/{id}")
    public ResponseEntity<CompraDTO> eliminarCompra(@PathVariable("id") Long compraId) {
        /*Compra compra = compraDao.eliminarCompra(compraId);
        return compra;*/
        return new ResponseEntity<CompraDTO>(compraDao.eliminarCompra(compraId), HttpStatus.OK);
    }
}
