package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.models.Compra;

import java.util.List;

public interface CompraDao {

    List<Compra> getComprasPorFiesta(Long fiestaId);

    void addCompra(Compra compra);

    Compra eliminarCompra(Long compraId);

}
