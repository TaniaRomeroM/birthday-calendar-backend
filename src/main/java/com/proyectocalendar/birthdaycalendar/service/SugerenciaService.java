package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.SugerenciaDTO;

import java.util.List;

public interface SugerenciaService {

    List<SugerenciaDTO> getSugerencias();

    List<SugerenciaDTO> getSugerenciasPorUsuario(String nombreUsuario);

    SugerenciaDTO addSugerencia(SugerenciaDTO sugerenciaDTO);
}
