package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.FiestaDTO;

import java.util.List;

public interface FiestaDao {

    List<FiestaDTO> getFiestasPorUsuario(Long fiestaId);

    List<FiestaDTO> getFiestasPorUsuario(String nombreUsuario);

    List<FiestaDTO> getFiesta(Long fiestaId);

    FiestaDTO addFiesta(FiestaDTO fiestaDTO);

    FiestaDTO eliminarFiesta(Long fiestaId);
}
