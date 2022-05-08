package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.FiestaDTO;
import com.proyectocalendar.birthdaycalendar.mappers.FiestaMapper;
import com.proyectocalendar.birthdaycalendar.models.Fiesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional // Mantiene coherencia si hay varios accesos a bd. Si uno falla, se hace rollback y se queda como estaba
public class FiestaServiceImpl implements FiestaService {

    private static final Logger log = LoggerFactory.getLogger(FiestaServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    FiestaMapper fiestaMapper;

    @Override
    public List<FiestaDTO> getFiestasPorUsuario(Long usuarioId) {
        log.info("Fetching fiestas by usuarioId: {}", usuarioId);
        Query query = entityManager.createQuery("SELECT f FROM Fiesta f WHERE f.usuarioId =:usuarioid");
        query.setParameter("usuarioid", usuarioId);
        return query.getResultList();
    }

    @Override
    public List<FiestaDTO> getFiestasPorUsuario(String nombreUsuario) {
        log.info("Fetching fiestas by nombreUsuario: {}", nombreUsuario);
        Query query = entityManager.createQuery("SELECT f FROM Fiesta f INNER JOIN Usuario u ON f.usuarioId = u.usuarioId" +
                " WHERE u.nombreUsuario =:nombreUsuario"); // Nombre de la clase no de la tabla
        query.setParameter("nombreUsuario", nombreUsuario);
        return query.getResultList();
    }

    @Override
    public List<FiestaDTO> getFiesta(Long fiestaId) {
        log.info("Get fiesta by fiestaId: {}", fiestaId);
        Query query = entityManager.createQuery("SELECT f FROM Fiesta f WHERE f.fiestaId =:fiestaid");
        query.setParameter("fiestaid", fiestaId);
        return query.getResultList();
    }

    @Override
    public FiestaDTO addFiesta(FiestaDTO fiestaDTO) {
        log.info("Add fiesta: {}", fiestaDTO.toString());
        Fiesta fiesta = fiestaMapper.toEntFiesta(fiestaDTO);
        Fiesta newFiesta = entityManager.merge(fiesta);
        return fiestaMapper.toFiestaDto(newFiesta);
    }

    @Override
    public FiestaDTO eliminarFiesta(Long fiestaId) {
        log.info("Delete fiesta by fiestaId: {}", fiestaId);
        Fiesta fiesta = entityManager.find(Fiesta.class, fiestaId);
        entityManager.remove(fiesta);
        return fiestaMapper.toFiestaDto(fiesta);
    }
}
