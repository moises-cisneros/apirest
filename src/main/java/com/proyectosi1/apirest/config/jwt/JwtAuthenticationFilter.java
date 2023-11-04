package com.proyectosi1.apirest.config.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Obtiene el token JWT de la solicitud.
        final String token = getTokenFromRequest(request);
        final String username;

        // Si no se encuentra un token en la  solicitud, pasa al siguiente filtro en la cadena.
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        // Obtiene el nombre de usuario del token JWT.
        username = jwtService.getUsernameFromToken(token);

        // Si se encuentra un nombre de usuario en el token y no hay autenticación en el contexto de seguridad actual...
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Carga los detalles del usuario utilizando el UserDetailsService.
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Si el token es válido para el usuario...
            if (jwtService.isValidToken(token, userDetails)) {

                // Crea un token de autenticación y lo establece en el contexto de seguridad.
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        // Continúa con la cadena de filtros de seguridad.
        filterChain.doFilter(request, response);
    }

    // Obtiene el token JWT de la solicitud HTTP.
    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Verifica si el encabezado de autorización contiene un token JWT en formato "Bearer".
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer")) {
            return authHeader.substring(7);
        }

        return null;
    }
}
