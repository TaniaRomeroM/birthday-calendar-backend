package com.proyectocalendar.birthdaycalendar.mappers;

import com.proyectocalendar.birthdaycalendar.dto.SugerenciaDTO;
import com.proyectocalendar.birthdaycalendar.models.Sugerencia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Para poder instanciar el mapper con Autowired
public interface SugerenciaMapper {

    Sugerencia toEntSugerencia(SugerenciaDTO sugerenciaDTO);

    SugerenciaDTO toSugerenciaDto(Sugerencia sugerencia);
}
