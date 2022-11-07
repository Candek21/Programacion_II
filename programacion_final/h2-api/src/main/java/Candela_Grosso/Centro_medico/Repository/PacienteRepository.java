package Candela_Grosso.Centro_medico.Repository;

import Candela_Grosso.Centro_medico.Entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends  JpaRepository<Paciente,Integer> {
}
