package com.proyectosi1.apirest.config.security;

import com.proyectosi1.apirest.config.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/bodega/**").permitAll()
                        .requestMatchers("/color/**").permitAll()
                        .requestMatchers("/category/**").permitAll()
                        .requestMatchers("/marca/**").permitAll()
                        .requestMatchers("/inventario/**").permitAll()
                        .requestMatchers("/producto/**").permitAll()
                        .requestMatchers("/talla/**").permitAll()
                        .requestMatchers("/role/**").permitAll()
                        .requestMatchers("/permission/**").permitAll()
                        .requestMatchers("/usuario/**").permitAll()
                        .requestMatchers("/nota_ingreso/**").permitAll()
                        .requestMatchers("/ingreso_producto/**").permitAll()
                        .requestMatchers("/notaventa/**").permitAll()
                        .requestMatchers("/tipopago/**").permitAll()
                        .requestMatchers("/detalle_venta/**").permitAll()
                        .requestMatchers("/descuento/**").permitAll()
                        .requestMatchers("/bitacora/**").permitAll()
                        .requestMatchers("/send-email/**").permitAll()
                        .requestMatchers("/imagen/**").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
