package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.models.Compra;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CompraDaoImpl implements CompraDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Compra> getComprasPorFiesta(Long fiestaId) {
        Query query = entityManager.createQuery("SELECT c FROM Compra c WHERE c.fiestaId =:fiestaid"); // Nombre de la clase no de la tabla
        query.setParameter("fiestaid", fiestaId);
        return query.getResultList();
    }

    @Override
    public void addCompra(Compra compra) {
        entityManager.merge(compra);
    }

    @Override
    public Compra eliminarCompra(Long compraId) {
        Compra compra = entityManager.find(Compra.class, compraId);
        entityManager.remove(compra);
        return compra;
    }

}
