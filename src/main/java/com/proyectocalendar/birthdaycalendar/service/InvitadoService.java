package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.InvitadoDTO;

import java.util.List;

public interface InvitadoService {

    List<InvitadoDTO> getInvitadosPorFiesta(Long fiestaId);

    InvitadoDTO addInvitado(InvitadoDTO invitadoDTO);

    InvitadoDTO eliminarInvitado(Long invitadoId);
}
