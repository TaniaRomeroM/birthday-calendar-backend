package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.models.Fiesta;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class FiestaDaoImpl implements FiestaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Fiesta> getFiestasPorUsuario(Long usuarioId) {
        Query query = entityManager.createQuery("SELECT f FROM Fiesta f WHERE f.usuarioId =:usuarioid");
        query.setParameter("usuarioid", usuarioId);
        return query.getResultList();
    }

    @Override
    public void addFiesta(Fiesta fiesta) {
        entityManager.merge(fiesta);
    }

    @Override
    public List<Fiesta> getFiesta(Long fiestaId) {
        Query query = entityManager.createQuery("SELECT f FROM Fiesta f WHERE f.fiestaId =:fiestaid");
        query.setParameter("fiestaid", fiestaId);
        return query.getResultList();
    }
}
