package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.models.Contacto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository // Hace referencia a la conexion con la BBDD
@Transactional // Min 2:05:44 Da funcionalidad a la clase para poder armar las consultas de SQL a la BBDD, Permite prescindir de crear la transaccion, hacer el commit, el begin, el rollback ...
public class ContactoDaoImp implements ContactoDao {

    @PersistenceContext
    private EntityManager entityManager; // Sirve para hacer la conexion con la BBDD

    @Override // Indica que esta reemplazando el metodo de la Interface
    @Transactional // ¿?
    public List<Contacto> getContactos() {
        String query = "FROM Contacto"; // Nombre de la clase no de la tabla
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Contacto> getContactosPorUsuario(Long usuarioId) {
        Query query = entityManager.createQuery("SELECT c FROM Contacto c WHERE c.usuarioId =:usuarioid"); // Nombre de la clase no de la tabla
        //Query query = entityManager.createNativeQuery("SELECT * FROM calendar.contacto WHERE usuario_id =:usuarioid");
        query.setParameter("usuarioid", usuarioId);
        return query.getResultList();
    }

    @Override
    public void addContacto(Contacto contacto) {
        entityManager.merge(contacto);
    }

/*
    @Override
    public void eliminar(Long id) {
        Empleado empleado = entityManager.find(Empleado.class, id);
        entityManager.remove(empleado);
    }*/
}
