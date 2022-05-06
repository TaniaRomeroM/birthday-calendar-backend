package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.InvitadoDTO;
import com.proyectocalendar.birthdaycalendar.mappers.InvitadoMapper;
import com.proyectocalendar.birthdaycalendar.security.models.Invitado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class InvitadoDaoImpl implements InvitadoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    InvitadoMapper invitadoMapper;

    @Override
    public List<InvitadoDTO> getInvitadosPorFiesta(Long fiestaId) {
        Query query = entityManager.createQuery("SELECT i FROM Invitado i WHERE i.fiestaId =:fiestaid"); // Nombre de la clase no de la tabla
        query.setParameter("fiestaid", fiestaId);
        return query.getResultList();
    }

    @Override
    public InvitadoDTO addInvitado(InvitadoDTO invitadoDTO) {
        return invitadoMapper.toInvitadoDto(entityManager.merge(invitadoMapper.toEntInvitado(invitadoDTO)));
    }

    @Override
    public InvitadoDTO eliminarInvitado(Long invitadoId) {
        Invitado invitado = entityManager.find(Invitado.class, invitadoId);
        entityManager.remove(invitado);
        return invitadoMapper.toInvitadoDto(invitado);
    }


}
