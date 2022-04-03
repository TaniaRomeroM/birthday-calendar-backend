package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository // Hace referencia a la conexion con la BBDD
@Transactional // Min 2:05:44 Da funcionalidad a la clase para poder armar las consultas de SQL a la BBDD, Permite prescindir de crear la transaccion, hacer el commit, el begin, el rollback ...
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager; // Sirve para hacer la conexion con la BBDD

    @Override // Indica que esta reemplazando el metodo de la Interface
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario"; // Nombre de la clase no de la tabla
        return entityManager.createQuery(query).getResultList();
    }
/*
    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }*/

    @Override
    public void registrarUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }
}
