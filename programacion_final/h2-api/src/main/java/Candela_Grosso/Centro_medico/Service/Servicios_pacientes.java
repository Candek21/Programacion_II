package Candela_Grosso.Centro_medico.Service;

import Candela_Grosso.Centro_medico.Entities.Paciente;

import java.util.List;

public interface Servicios_pacientes {
    //Los métodos son publicos porque es una interfaz

    Paciente guardarPaciente(Paciente paciente);

    //el optional lo que hace es prevenir un error de tipo null
    List<Paciente> obtenerPaciente();

    Paciente modificarPaciente(int id, Paciente paciente);

    boolean eliminarPaciente(int id);

    Paciente obtenerPacientePorId(int id);
}
