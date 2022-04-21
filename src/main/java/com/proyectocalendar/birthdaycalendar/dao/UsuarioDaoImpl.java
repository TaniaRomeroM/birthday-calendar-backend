package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.UsuarioDTO;
import com.proyectocalendar.birthdaycalendar.mappers.UsuarioMapper;
import com.proyectocalendar.birthdaycalendar.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository // Hace referencia a la conexion con la BBDD
@Transactional // Min 2:05:44 Da funcionalidad a la clase para poder armar las consultas de SQL a la BBDD, Permite prescindir de crear la transaccion, hacer el commit, el begin, el rollback ...
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
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntUsuario(usuarioDTO);
        Usuario newUsuario = entityManager.merge(usuario);
        return usuarioMapper.toUsuarioDto(newUsuario);

        //return usuarioMapper.toUsuarioDto(entityManager.merge(usuarioMapper.toEntUsuario(usuarioDTO)));
    }

    @Override
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
    }

    @Override
    public UsuarioDTO eliminarUsuario(Long usuarioId) {
        Usuario usuario = entityManager.find(Usuario.class, usuarioId);
        entityManager.remove(usuario);
        return usuarioMapper.toUsuarioDto(usuario);
    }
}