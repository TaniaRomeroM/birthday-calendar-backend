package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.models.Compras;

import java.util.List;

public interface ComprasDao {

    List<Compras> getComprasPorFiesta(Long fiestaId);

    void addCompra(Compras compra);

    void eliminarCompra(Long compraId);


}
