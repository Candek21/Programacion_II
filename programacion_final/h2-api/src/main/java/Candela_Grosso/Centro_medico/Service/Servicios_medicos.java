package Candela_Grosso.Centro_medico.Service;

import Candela_Grosso.Centro_medico.Entities.Medicos;

import java.util.List;


public interface Servicios_medicos {
    //Los métodos son publicos porque es una interfaz

    List<Medicos> obtenerMedicos();

    Medicos guardarMedico(Medicos medico);

    Medicos obtenerMedicoPorId (int id);

    //Medicos modificarMedico(int id, Medicos medico);

    void eliminarMedico(int id);

}
