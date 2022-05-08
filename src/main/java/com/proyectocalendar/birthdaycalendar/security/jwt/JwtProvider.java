package com.proyectocalendar.birthdaycalendar.security.jwt;

import com.proyectocalendar.birthdaycalendar.security.models.UsuarioAplicacion;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// Clase que crea el token y valida si esta bien construido
@Component
public class JwtProvider {

    // Se utiliza en desarrollo para ver cual es el metodo que da error
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    /* Valores definidos en application.properties */
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    /* Metodo que genera el token JWT */
    public String generateToken(Authentication authentication) {
        // Se obtiene el usuario de la autenticacion de springsecurity y se castea a nuestro usuario
        UsuarioAplicacion usuarioAplicacion = (UsuarioAplicacion) authentication.getPrincipal();

        List<String> roles = usuarioAplicacion.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        // Se crea el token con los datos del usuario obtenido. Subject-nombreUsuario, fecha creacion , fecha expiracion y alg firma
        return Jwts.builder()
                .setSubject(usuarioAplicacion.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    /* Se obtiene el nombre del usuario a partir del token */
    public String getNombreUsuarioFromToken(String token) {
        /* .getBytes() para que la firma del token sea valida */
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }

    /* Metodo que valida que el token generado es correcto */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("token mal generado");
        } catch (UnsupportedJwtException e) {
            logger.error("token no soportado");
        } catch (ExpiredJwtException e) {
            logger.error("token expirado");
        } catch (IllegalArgumentException e) {
            logger.error("token vacio");
        } catch (SignatureException e) {
            logger.error("fallo en la firma del token");
        }
        return false;
    }
}