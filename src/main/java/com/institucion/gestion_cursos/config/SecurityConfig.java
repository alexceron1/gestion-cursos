package com.institucion.gestion_cursos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                        // 1. Permitir acceso PÚBLICO a estas rutas:
                        .requestMatchers("/", "/inscripcion/**", "/donaciones", "/css/**", "/js/**", "/images/**").permitAll()
                        // 2. Todo lo demás (ej. /admin) requiere LOGIN
                        .anyRequest().authenticated()
                )
                // 3. Habilitar el formulario de login por defecto de Spring
                .formLogin(withDefaults());

        return http.build();
    }
}