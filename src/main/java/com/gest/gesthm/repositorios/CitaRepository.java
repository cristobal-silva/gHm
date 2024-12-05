package com.gest.gesthm.repositorios;

import com.gest.gesthm.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    // Aquí puedes añadir consultas personalizadas basadas en la lógica de tu aplicación
}
