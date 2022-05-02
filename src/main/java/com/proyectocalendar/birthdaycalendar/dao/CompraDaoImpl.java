package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.CompraDTO;
import com.proyectocalendar.birthdaycalendar.mappers.CompraMapper;
import com.proyectocalendar.birthdaycalendar.security.models.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional // Mantiene coherencia si hay varios accesos a bd. Si uno falla, se hace rollback y se queda como estaba
public class CompraDaoImpl implements CompraDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    CompraMapper compraMapper;

    @Override
    public List<CompraDTO> getComprasPorFiesta(Long fiestaId) {
        Query query = entityManager.createQuery("SELECT c FROM Compra c WHERE c.fiestaId =:fiestaid"); // Nombre de la clase no de la tabla
        query.setParameter("fiestaid", fiestaId);
        return query.getResultList();
    }

    @Override
    public CompraDTO addCompra(CompraDTO compraDTO) {
        //entityManager.merge(compra);
        return compraMapper.toCompraDto(entityManager.merge(compraMapper.toEntCompra(compraDTO)));
    }

    @Override
    public CompraDTO eliminarCompra(Long compraId) {
        Compra compra = entityManager.find(Compra.class, compraId);
        entityManager.remove(compra);
        return compraMapper.toCompraDto(compra);
    }
}
