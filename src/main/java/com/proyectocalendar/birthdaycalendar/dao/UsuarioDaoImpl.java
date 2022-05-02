package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.UsuarioDTO;
import com.proyectocalendar.birthdaycalendar.mappers.UsuarioMapper;
import com.proyectocalendar.birthdaycalendar.security.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository // Hace referencia a la conexion con la BBDD
@Transactional // Mantiene coherencia si hay varios accesos a bd. Si uno falla, se hace rollback y se queda como estaba
public class UsuarioDaoImpl implements UsuarioDao {

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
        //return entityManager.createQuery(query).getResultList();
        /*Usuario usuario = (Usuario) query.getResultList().get(0);
        return usuarioMapper.toUsuarioDto(usuario);*/

        return usuarioMapper.toUsuarioDto((Usuario) query.getResultList().get(0));
    }

    @Override
    public UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntUsuario(usuarioDTO);
        Usuario newUsuario = entityManager.merge(usuario);
        return usuarioMapper.toUsuarioDto(newUsuario);
        //return usuarioMapper.toUsuarioDto(entityManager.merge(usuarioMapper.toEntUsuario(usuarioDTO)));
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntUsuario(usuarioDTO);
        Usuario newUsuario = entityManager.merge(usuario);
        return usuarioMapper.toUsuarioDto(newUsuario);
        //return usuarioMapper.toUsuarioDto(entityManager.merge(usuarioMapper.toEntUsuario(usuarioDTO)));
    }

    @Override
    public boolean verificarCredenciales(UsuarioDTO usuarioDTO) { return false; }

    /*@Override
    public boolean verificarCredenciales(UsuarioDTO usuarioDTO) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuarioDTO.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return false;
        }

        String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return  argon2.verify(passwordHashed, usuarioDTO.getPassword()); // Compara la contrasenya de la BBDD con la que le estamos pasando
    }*/

    @Override
    public UsuarioDTO eliminarUsuario(Long usuarioId) {
        Usuario usuario = entityManager.find(Usuario.class, usuarioId);
        entityManager.remove(usuario);
        return usuarioMapper.toUsuarioDto(usuario);
    }
}