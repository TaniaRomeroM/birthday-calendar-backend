package com.proyectocalendar.birthdaycalendar.mappers;

import com.proyectocalendar.birthdaycalendar.dto.UsuarioDTO;
import com.proyectocalendar.birthdaycalendar.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // Para poder instanciar el mapper con Autowired
public interface UsuarioMapper {

    Usuario toEntUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO toUsuarioDto(Usuario usuario);
}