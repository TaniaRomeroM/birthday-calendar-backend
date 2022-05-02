package com.proyectocalendar.birthdaycalendar.mappers;

import com.proyectocalendar.birthdaycalendar.dto.CompraDTO;
import com.proyectocalendar.birthdaycalendar.security.models.Compra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Para poder instanciar el mapper con Autowired
public interface CompraMapper {

    Compra toEntCompra(CompraDTO compraDTO);

    CompraDTO toCompraDto(Compra compra);
}