package com.gest.gesthm.config;

import org.springframework.context.annotation.Bean;
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
            .cors() // Habilitar CORS definido en CorsConfiguration
                .and()
            .csrf().disable() // Desactivar CSRF para APIs
            .authorizeRequests()
                .antMatchers("/api/public/**").permitAll() // Rutas públicas
                .anyRequest().authenticated() // Rutas protegidas
                .and()
            .httpBasic(); // Autenticación básica
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("user") // Usuario
            .password(passwordEncoder().encode("password")) // Contraseña
            .roles("USER"); // Rol
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
