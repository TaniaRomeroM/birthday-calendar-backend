package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.models.Compras;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ComprasDaoImpl implements ComprasDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Compras> getComprasPorFiesta(Long fiestaId) {
        Query query = entityManager.createQuery("SELECT c FROM Compras c WHERE c.fiestaId =:fiestaid"); // Nombre de la clase no de la tabla
        query.setParameter("fiestaid", fiestaId);
        return query.getResultList();
    }

    @Override
    public void addCompra(Compras compra) {
        entityManager.merge(compra);
    }

    @Override
    public void eliminarCompra(Long compraId) {
        Compras compra = entityManager.find(Compras.class, compraId);
        entityManager.remove(compra);
    }
}
