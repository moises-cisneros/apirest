package com.proyectosi1.apirest.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

    private static final String CLAVE_SECRETA = "RXMgbGEgY2xhdmUgZGVsIHByb3llY3RvIHRpZW5kYSAyMDIz";

    public String getToken(UserDetails user) {
        // Método para generar un token JWT a partir de los detalles de usuario.
        return getToken(new HashMap<>(), user);
    }

    private String getToken(Map<String, Object> extraClaims, UserDetails user) {
        // Metodo para generar un token JWT con extra claims
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        // Obtiene la clave (key) a partir de la clave secreta.
        byte[] keyBytes = Decoders.BASE64.decode(CLAVE_SECRETA);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    private <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        // Obtiene una reclamacion especifica (claimsResolver) de un token JWT.
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token) {
        // Obtiene todas las reclamaciones (claims) de un token JWT.
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isValidToken(String token, UserDetails userDetails) {
        // Verifica si un token JWT es válido para un UserDetails especifico.
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        // Verifica si un token JWT ha expirado.
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token) {
        // Obtiene la fecha de expiracion de un token JWT.
        return getClaim(token, Claims::getExpiration);
    }
}
