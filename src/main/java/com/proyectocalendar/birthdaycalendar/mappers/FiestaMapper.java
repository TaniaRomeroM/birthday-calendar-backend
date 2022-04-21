package com.proyectocalendar.birthdaycalendar.mappers;

import com.proyectocalendar.birthdaycalendar.dto.FiestaDTO;
import com.proyectocalendar.birthdaycalendar.models.Fiesta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") //para poder instanciar el mapper con Autowired
public interface FiestaMapper {

    Fiesta toEntFiesta(FiestaDTO fiestaDTO);

    FiestaDTO toFiestaDto(Fiesta fiesta);
}