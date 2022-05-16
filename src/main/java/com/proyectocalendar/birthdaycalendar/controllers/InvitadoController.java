package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dto.InvitadoDTO;
import com.proyectocalendar.birthdaycalendar.dto.Message;
import com.proyectocalendar.birthdaycalendar.service.InvitadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> addInvitado (@Valid @RequestBody InvitadoDTO invitadoDTO,  BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Campos erróneos"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<InvitadoDTO>(invitadoService.addInvitado(invitadoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<InvitadoDTO> eliminarInvitado(@PathVariable("id") Long invitadoId) {
        return new ResponseEntity<InvitadoDTO>(invitadoService.eliminarInvitado(invitadoId), HttpStatus.OK);
    }
}
