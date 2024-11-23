package com.gest.gesthm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // Desactivado para APIs, activar si se usa en formularios
            .authorizeRequests()
                .antMatchers("/api/public/**").permitAll()  // Permite acceso a rutas públicas
                .anyRequest().authenticated()  // Requiere autenticación para cualquier otra ruta
            .and()
            .httpBasic();  // Utiliza autenticación básica
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER");
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Codificador de contraseñas usando BCrypt
    }
}
