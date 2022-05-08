package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.CompraDTO;
import com.proyectocalendar.birthdaycalendar.mappers.CompraMapper;
import com.proyectocalendar.birthdaycalendar.models.Compra;
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
public class CompraServiceImpl implements CompraService {

    private static final Logger log = LoggerFactory.getLogger(CompraServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    CompraMapper compraMapper;

    @Override
    public List<CompraDTO> getComprasPorFiesta(Long fiestaId) {
        log.info("Get compras by fiestaId: {}", fiestaId);
        Query query = entityManager.createQuery("SELECT c FROM Compra c WHERE c.fiestaId =:fiestaid"); // Nombre de la clase no de la tabla
        query.setParameter("fiestaid", fiestaId);
        return query.getResultList();
    }

    @Override
    public CompraDTO addCompra(CompraDTO compraDTO) {
        log.info("Add compra: {}", compraDTO.toString());
        return compraMapper.toCompraDto(entityManager.merge(compraMapper.toEntCompra(compraDTO)));
    }

    @Override
    public CompraDTO eliminarCompra(Long compraId) {
        log.info("Delete compra by id: {}", compraId);
        Compra compra = entityManager.find(Compra.class, compraId);
        entityManager.remove(compra);
        return compraMapper.toCompraDto(compra);
    }
}
