package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.FiestaDTO;
import com.proyectocalendar.birthdaycalendar.mappers.FiestaMapper;
import com.proyectocalendar.birthdaycalendar.models.Fiesta;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    FiestaMapper fiestaMapper;

    @Override
    public List<FiestaDTO> getFiestasPorUsuario(Long usuarioId) {
        Query query = entityManager.createQuery("SELECT f FROM Fiesta f WHERE f.usuarioId =:usuarioid");
        query.setParameter("usuarioid", usuarioId);
        return query.getResultList();
    }

    @Override
    public List<FiestaDTO> getFiesta(Long fiestaId) {
        Query query = entityManager.createQuery("SELECT f FROM Fiesta f WHERE f.fiestaId =:fiestaid");
        query.setParameter("fiestaid", fiestaId);
        return query.getResultList();
    }

    @Override
    public FiestaDTO addFiesta(FiestaDTO fiestaDTO) {
        Fiesta fiesta = fiestaMapper.toEntFiesta(fiestaDTO);
        Fiesta nwFiesta = entityManager.merge(fiesta);
        return fiestaMapper.toFiestaDto(nwFiesta);
        //return fiestaMapper.toFiestaDto(entityManager.merge(fiestaMapper.toEntFiesta(fiestaDTO)));
    }

    @Override
    public FiestaDTO eliminarFiesta(Long fiestaId) {
        Fiesta fiesta = entityManager.find(Fiesta.class, fiestaId);
        entityManager.remove(fiesta);
        return fiestaMapper.toFiestaDto(fiesta);
    }
}
