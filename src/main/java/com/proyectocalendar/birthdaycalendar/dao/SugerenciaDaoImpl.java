package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.SugerenciaDTO;
import com.proyectocalendar.birthdaycalendar.mappers.SugerenciaMapper;
import com.proyectocalendar.birthdaycalendar.security.models.Sugerencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository // Hace referencia a la conexion con la BBDD
@Transactional
public class SugerenciaDaoImpl implements SugerenciaDao {

    @PersistenceContext
    private EntityManager entityManager; // Sirve para hacer la conexion con la BBDD

    @Autowired
    SugerenciaMapper sugerenciaMapper;

    @Override // Indica que esta reemplazando el metodo de la Interface
    @Transactional
    public List<SugerenciaDTO> getSugerencias() {
        String query = "FROM Sugerencia"; // Nombre de la clase no de la tabla
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<SugerenciaDTO> getSugerenciasPorUsuario(String nombreUsuario) {
        Query query = entityManager.createQuery("SELECT s FROM Sugerencia s INNER JOIN Usuario u ON s.usuarioId = u.usuarioId" +
                " WHERE u.nombreUsuario =:nombreUsuario"); // Nombre de la clase no de la tabla
        query.setParameter("nombreUsuario", nombreUsuario);
        return query.getResultList();
    }

    @Override
    public SugerenciaDTO addSugerencia(SugerenciaDTO sugerenciaDTO) {
        Sugerencia sugerencia = sugerenciaMapper.toEntSugerencia(sugerenciaDTO);
        Sugerencia newSugerencia = entityManager.merge(sugerencia);
        return sugerenciaMapper.toSugerenciaDto(newSugerencia);
    }

}
