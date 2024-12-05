package com.gest.gesthm.repositorios;

import com.gest.gesthm.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Aquí puedes añadir métodos específicos de consulta que no están cubiertos por JpaRepository
}
