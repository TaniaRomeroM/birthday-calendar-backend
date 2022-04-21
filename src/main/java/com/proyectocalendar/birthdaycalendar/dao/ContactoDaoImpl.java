package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.ContactoDTO;
import com.proyectocalendar.birthdaycalendar.mappers.ContactoMapper;
import com.proyectocalendar.birthdaycalendar.models.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository // Hace referencia a la conexion con la BBDD
@Transactional // Min 2:05:44 Da funcionalidad a la clase para poder armar las consultas de SQL a la BBDD, Permite prescindir de crear la transaccion, hacer el commit, el begin, el rollback ...
public class ContactoDaoImpl implements ContactoDao {

    @PersistenceContext
    private EntityManager entityManager; // Sirve para hacer la conexion con la BBDD

    @Autowired
    ContactoMapper contactoMapper;

    @Override // Indica que esta reemplazando el metodo de la Interface
    @Transactional
    public List<ContactoDTO> getContactos() {
        String query = "FROM Contacto"; // Nombre de la clase no de la tabla
        //List<Contacto> contactos = entityManager.createQuery(query).getResultList()
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<ContactoDTO> getContactosPorUsuario(Long usuarioId) {
        Query query = entityManager.createQuery("SELECT c FROM Contacto c WHERE c.usuarioId =:usuarioid"); // Nombre de la clase no de la tabla
        //Query query = entityManager.createNativeQuery("SELECT * FROM calendar.contacto WHERE usuario_id =:usuarioid");
        query.setParameter("usuarioid", usuarioId);
        return query.getResultList();
    }

    @Override
    public List<ContactoDTO> getContacto(Long contactoId) {
        Query query = entityManager.createQuery("SELECT c FROM Contacto c WHERE c.contactoId =:contactoid");
        query.setParameter("contactoid", contactoId);
        return query.getResultList();
    }

    @Override
    public ContactoDTO addContacto(ContactoDTO contactoDTO) {
        Contacto contacto = contactoMapper.toEntContacto(contactoDTO);
        Contacto newContacto = entityManager.merge(contacto);
        return contactoMapper.toContactoDto(newContacto);

        //return contactoMapper.toContactoDto(entityManager.merge(contactoMapper.toEntContacto(contactoDTO)));
    }

    @Override
    public ContactoDTO eliminarContacto(Long contactoId) {
        Contacto contacto = entityManager.find(Contacto.class, contactoId);
        entityManager.remove(contacto);
        return contactoMapper.toContactoDto(contacto);
    }

}
