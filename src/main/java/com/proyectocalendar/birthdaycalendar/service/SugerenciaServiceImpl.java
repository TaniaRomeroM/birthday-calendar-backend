package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.SugerenciaDTO;
import com.proyectocalendar.birthdaycalendar.mappers.SugerenciaMapper;
import com.proyectocalendar.birthdaycalendar.models.Sugerencia;
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
@Transactional
public class SugerenciaServiceImpl implements SugerenciaService {

    private static final Logger log = LoggerFactory.getLogger(SugerenciaServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager; // Sirve para hacer la conexion con la BBDD

    @Autowired
    SugerenciaMapper sugerenciaMapper;

    @Override // Indica que esta reemplazando el metodo de la Interface
    @Transactional
    public List<SugerenciaDTO> getSugerencias() {
        log.info("Fetching sugerencias");
        String query = "FROM Sugerencia"; // Nombre de la clase no de la tabla
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<SugerenciaDTO> getSugerenciasPorUsuario(String nombreUsuario) {
        log.info("Fetching sugerencias by nombreUsuario: {}", nombreUsuario);
        Query query = entityManager.createQuery("SELECT s FROM Sugerencia s INNER JOIN Usuario u ON s.usuarioId = u.usuarioId" +
                " WHERE u.nombreUsuario =:nombreUsuario"); // Nombre de la clase no de la tabla
        query.setParameter("nombreUsuario", nombreUsuario);
        return query.getResultList();
    }

    @Override
    public SugerenciaDTO addSugerencia(SugerenciaDTO sugerenciaDTO) {
        log.info("Add new sugerencia: {}", sugerenciaDTO.toString());
        Sugerencia sugerencia = sugerenciaMapper.toEntSugerencia(sugerenciaDTO);
        Sugerencia newSugerencia = entityManager.merge(sugerencia);
        return sugerenciaMapper.toSugerenciaDto(newSugerencia);
    }

}
