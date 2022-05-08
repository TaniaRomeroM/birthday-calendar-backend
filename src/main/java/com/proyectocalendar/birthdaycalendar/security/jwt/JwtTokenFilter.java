package com.proyectocalendar.birthdaycalendar.security.jwt;

import com.proyectocalendar.birthdaycalendar.security.service.UsuarioDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Clase que se ejecuta por cada peticion, comprueba que sea valido el token (utilizando el JwtProvider),
   y si lo es, permite el acceso al recurso */
public class JwtTokenFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UsuarioDetailsServiceImpl usuarioDetailsService;

    /* Comprueba que el token es valido (utilizando el JwtProvider) */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            // Se obtiene el token de la peticion y se comprueba que es valido
            String token = getToken(request);
            if (token != null && jwtProvider.validateToken(token)) {
                // Se obtiene el nombre usuario del token para cargar los detalles del usuario
                String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDetails = usuarioDetailsService.loadUserByUsername(nombreUsuario);

                // Le pasamos el usuario con sus detalles al contexto de autenticacion de spring security
                UsernamePasswordAuthenticationToken passwordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(passwordAuthenticationToken);
            }
        } catch (Exception e) {
            log.error("Fallo en el doFilter {}", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    /* Metodo que obtiene el token de la peticion */
    private String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            // Importante el espacio despues del Bearer, ya que la cabecera de autenticacion viene como Bearer <token>
            return header.replace("Bearer ", "");
        }
        return null;
    }
}