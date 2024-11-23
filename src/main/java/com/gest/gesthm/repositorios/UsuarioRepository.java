package com.gest.gesthm.repository;

import com.gest.gesthm.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Opciones para añadir métodos de búsqueda por username, email, etc.
}
