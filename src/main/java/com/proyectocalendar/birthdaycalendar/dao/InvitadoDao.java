package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.InvitadoDTO;

import java.util.List;

public interface InvitadoDao {

    List<InvitadoDTO> getInvitadosPorFiesta(Long fiestaId);

    InvitadoDTO addInvitado(InvitadoDTO invitadoDTO);

    InvitadoDTO eliminarInvitado(Long invitadoId);
}
