package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.SugerenciaDTO;

import java.util.List;

public interface SugerenciaDao {

    List<SugerenciaDTO> getSugerencias();

    List<SugerenciaDTO> getSugerenciasPorUsuario(String nombreUsuario);

    SugerenciaDTO addSugerencia(SugerenciaDTO sugerenciaDTO);
}
