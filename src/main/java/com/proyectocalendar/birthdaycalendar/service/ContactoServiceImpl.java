package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.ContactoDTO;
import com.proyectocalendar.birthdaycalendar.mappers.ContactoMapper;
import com.proyectocalendar.birthdaycalendar.models.Contacto;
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
public class ContactoServiceImpl implements ContactoService {

    private static final Logger log = LoggerFactory.getLogger(ContactoServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager; // Sirve para hacer la conexion con la BBDD

    @Autowired
    ContactoMapper contactoMapper;

    @Override
    public List<ContactoDTO> getContactosPorUsuario(String nombreUsuario) {
        log.info("Fetching contacts by nombreUsuario: {}", nombreUsuario);
        Query query = entityManager.createQuery("SELECT c FROM Contacto c INNER JOIN Usuario u ON c.usuarioId = u.usuarioId" +
                " WHERE u.nombreUsuario =:nombreUsuario"); // Nombre de la clase no de la tabla
        query.setParameter("nombreUsuario", nombreUsuario);
        return query.getResultList();
    }

    @Override
    public List<ContactoDTO> getContactosHoy(String nombreUsuario) {
        log.info("Fetching contacts by date: {}", nombreUsuario);
        Query query = entityManager.createQuery("SELECT c FROM Contacto c INNER JOIN Usuario u ON c.usuarioId = u.usuarioId" +
                " WHERE u.nombreUsuario =:nombreUsuario" +
                " AND month(c.fechanac) = month(now())" +
                " AND day(c.fechanac) = day(now())");
        query.setParameter("nombreUsuario", nombreUsuario);
        return query.getResultList();
    };

    @Override
    public List<ContactoDTO> getContacto(Long contactoId) {
        log.info("Fetching contact: {}", contactoId);
        Query query = entityManager.createQuery("SELECT c FROM Contacto c WHERE c.contactoId =:contactoid");
        query.setParameter("contactoid", contactoId);
        return query.getResultList();
    }

    @Override
    public ContactoDTO addContacto(ContactoDTO contactoDTO) {
        log.info("Add contact: {}", contactoDTO.toString());
        Contacto contacto = contactoMapper.toEntContacto(contactoDTO);
        Contacto newContacto = entityManager.merge(contacto);
        return contactoMapper.toContactoDto(newContacto);
    }

    @Override
    public ContactoDTO eliminarContacto(Long contactoId) {
        Contacto contacto = entityManager.find(Contacto.class, contactoId);
        entityManager.remove(contacto);
        return contactoMapper.toContactoDto(contacto);
    }

}
