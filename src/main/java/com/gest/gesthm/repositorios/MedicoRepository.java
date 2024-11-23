package com.gest.gesthm.repository;

import com.gest.gesthm.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // Métodos de consulta específicos para 'Medico' pueden ser definidos aquí
}
