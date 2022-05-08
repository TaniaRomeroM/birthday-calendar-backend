package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dto.InvitadoDTO;
import com.proyectocalendar.birthdaycalendar.service.InvitadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invitados")
@CrossOrigin({"*"})
public class InvitadoController {

    @Autowired
    private InvitadoService invitadoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<InvitadoDTO>> getInvitadosPorFiesta(@PathVariable("id") Long fiestaId) {
        return new ResponseEntity<List<InvitadoDTO>>(invitadoService.getInvitadosPorFiesta(fiestaId), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<InvitadoDTO> addInvitado (@RequestBody InvitadoDTO invitadoDTO) {
        return new ResponseEntity<InvitadoDTO>(invitadoService.addInvitado(invitadoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<InvitadoDTO> eliminarInvitado(@PathVariable("id") Long invitadoId) {
        return new ResponseEntity<InvitadoDTO>(invitadoService.eliminarInvitado(invitadoId), HttpStatus.OK);
    }
}
