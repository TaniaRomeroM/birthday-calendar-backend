package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.UsuarioDTO;
import com.proyectocalendar.birthdaycalendar.mappers.UsuarioMapper;
import com.proyectocalendar.birthdaycalendar.security.models.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository // Hace referencia a la conexion con la BBDD
@Transactional // Mantiene coherencia si hay varios accesos a bd. Si uno falla, se hace rollback y se queda como estaba
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager; // Sirve para hacer la conexion con la BBDD

    @Autowired
    UsuarioMapper usuarioMapper;

    @Override // Indica que esta reemplazando el metodo de la Interface
    @Transactional
    public List<UsuarioDTO> getUsuarios() {
        String query = "FROM Usuario"; // Nombre de la clase no de la tabla
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public UsuarioDTO getUsuarioByNombreUsuario(String nombreUsuario) {
        Query query = entityManager.createQuery("FROM Usuario u Where u.nombreUsuario  =:nombreUsuario");
        query.setParameter("nombreUsuario", nombreUsuario);
        return usuarioMapper.toUsuarioDto((Usuario) query.getResultList().get(0));
    }

    @Override
    public List<UsuarioDTO> getUsuarioById(Long usuarioId) {
        Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.usuarioId =:usuarioid");
        query.setParameter("usuarioid", usuarioId);
        return query.getResultList();
    }

    @Override
    public UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntUsuario(usuarioDTO);
        Usuario newUsuario = entityManager.merge(usuario);
        return usuarioMapper.toUsuarioDto(newUsuario);
    }

    @Override
    public UsuarioDTO eliminarUsuario(Long usuarioId) {
        Usuario usuario = entityManager.find(Usuario.class, usuarioId);
        entityManager.remove(usuario);
        return usuarioMapper.toUsuarioDto(usuario);
    }
}