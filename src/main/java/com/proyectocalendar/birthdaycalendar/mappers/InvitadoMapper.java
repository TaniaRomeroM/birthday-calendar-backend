package com.proyectocalendar.birthdaycalendar.mappers;

import com.proyectocalendar.birthdaycalendar.dto.InvitadoDTO;
import com.proyectocalendar.birthdaycalendar.security.models.Invitado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Para poder instanciar el mapper con Autowired
public interface InvitadoMapper {

    Invitado toEntInvitado(InvitadoDTO invitadoDTO);

    InvitadoDTO toInvitadoDto(Invitado invitado);
}
