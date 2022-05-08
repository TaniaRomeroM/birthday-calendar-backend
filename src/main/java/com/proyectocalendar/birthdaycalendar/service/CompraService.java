package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.CompraDTO;

import java.util.List;

public interface CompraService {

    List<CompraDTO> getComprasPorFiesta(Long fiestaId);

    CompraDTO addCompra(CompraDTO compraDTO);

    CompraDTO eliminarCompra(Long compraId);

}
