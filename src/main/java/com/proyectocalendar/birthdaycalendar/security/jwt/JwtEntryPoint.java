package com.proyectocalendar.birthdaycalendar.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Clase que comprueba si hay un token, si no lo hay envia una respuesta 401 (no autorizado)
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    // Se utiliza en desarrollo para ver cual es el metodo que da error
    private static final Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    // El siguiente metodo es necesario al implementar AuthenticationEntryPoint
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) throws IOException, ServletException {
        logger.error("Fallo en el metodo commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
    }
}