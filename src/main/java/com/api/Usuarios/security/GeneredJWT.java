package com.api.Usuarios.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class GeneredJWT {
/*/
    public String Create (){
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String usuarioId = "123";
        String nombreUsuario = "ejemploUsuario";

        Date fechaEmision = new Date();
        Date fechaExpiracion = new Date(fechaEmision.getTime() + 3600000);

        String jwt = Jwts.builder()
                .setSubject(usuarioId)
                .claim("nombreUsuario", nombreUsuario)
                .setIssuedAt(fechaEmision)
                .setExpiration(fechaExpiracion)
                .signWith(secretKey)
                .compact();

        return jwt;
    }
    /*/

}
