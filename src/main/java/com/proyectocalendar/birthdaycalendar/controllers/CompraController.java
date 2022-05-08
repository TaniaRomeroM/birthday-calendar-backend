package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dto.CompraDTO;
import com.proyectocalendar.birthdaycalendar.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
@CrossOrigin({"*"})
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<CompraDTO>> getComprasPorFiesta(@PathVariable("id") Long fiestaId) {
        return new ResponseEntity<List<CompraDTO>>(compraService.getComprasPorFiesta(fiestaId), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<CompraDTO> addCompra (@RequestBody CompraDTO compraDTO) {
        return new ResponseEntity<CompraDTO>(compraService.addCompra(compraDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<CompraDTO> eliminarCompra(@PathVariable("id") Long compraId) {
        return new ResponseEntity<CompraDTO>(compraService.eliminarCompra(compraId), HttpStatus.OK);
    }
}
