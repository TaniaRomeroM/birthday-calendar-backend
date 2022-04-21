package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.CompraDTO;

import java.util.List;

public interface CompraDao {

    List<CompraDTO> getComprasPorFiesta(Long fiestaId);

    CompraDTO addCompra(CompraDTO compraDTO);

    CompraDTO eliminarCompra(Long compraId);

}
