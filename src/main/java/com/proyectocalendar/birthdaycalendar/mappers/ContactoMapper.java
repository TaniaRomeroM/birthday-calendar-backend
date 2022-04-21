package com.proyectocalendar.birthdaycalendar.mappers;

import com.proyectocalendar.birthdaycalendar.dto.ContactoDTO;
import com.proyectocalendar.birthdaycalendar.models.Contacto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") //para poder instanciar el mapper con Autowired
public interface ContactoMapper {

    Contacto toEntContacto(ContactoDTO contactoDTO);

    ContactoDTO toContactoDto(Contacto contacto);
}