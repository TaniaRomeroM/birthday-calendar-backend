package com.proyectocalendar.birthdaycalendar.mappers;

import com.proyectocalendar.birthdaycalendar.dto.ContactoDTO;
import com.proyectocalendar.birthdaycalendar.security.models.Contacto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Para poder instanciar el mapper con Autowired
public interface ContactoMapper {

    Contacto toEntContacto(ContactoDTO contactoDTO);

    ContactoDTO toContactoDto(Contacto contacto);
}