package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.models.Fiesta;

import java.util.List;

public interface FiestaDao {

    List<Fiesta> getFiestasPorUsuario(Long fiestaId);
    void addFiesta(Fiesta fiesta);
    List<Fiesta> getFiesta(Long fiestaId);
}
