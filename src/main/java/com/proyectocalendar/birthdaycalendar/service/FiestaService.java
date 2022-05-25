package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.FiestaDTO;

import java.util.List;

public interface FiestaService {

    List<FiestaDTO> getFiestasPorUsuario(String nombreUsuario);

    List<FiestaDTO> getFiesta(Long fiestaId);

    FiestaDTO addFiesta(FiestaDTO fiestaDTO);

    FiestaDTO eliminarFiesta(Long fiestaId);
}
