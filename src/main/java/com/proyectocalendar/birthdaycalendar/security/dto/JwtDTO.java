package com.proyectocalendar.birthdaycalendar.security.dto;

public class JwtDTO {

    private String token;
    /*private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;*/

    public JwtDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}