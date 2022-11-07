package Candela_Grosso.Centro_medico.Service;

import Candela_Grosso.Centro_medico.Entities.Paciente;
import Candela_Grosso.Centro_medico.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class ServicioPacienteImpl implements Servicios_pacientes {
    @Autowired
    private PacienteRepository repositorioPaciente;

    @Override
    public List<Paciente> obtenerPaciente(){
        return repositorioPaciente.findAll();
    }

    @Override
    public Paciente modificarPaciente(int id, Paciente paciente) {
        return null;
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente){
        return repositorioPaciente.save(paciente);
    }

    /*@Override
    public Paciente modificarPaciente(int id, Paciente paciente) {
        Paciente pacienteSelected = repositorioPaciente.findById(id).get();
        pacienteSelected.setNombre_apellido(pacienteSelected.getNombre_apellido());
        return repositorioPaciente.save(pacienteSelected);
    }*/

    @Override
    public boolean eliminarPaciente(int id){
        this.repositorioPaciente.deleteById(id);
        return false;
    }

    @Override
    public Paciente obtenerPacientePorId(int id) {
        Optional<Paciente> optional = repositorioPaciente.findById(id);
        Paciente paciente = null;
        if(optional.isPresent()){
            paciente = optional.get();
        }
        else{
            throw new RuntimeException("Paciente no encontrado con id " + id);

        }
        return paciente;
    }


}
