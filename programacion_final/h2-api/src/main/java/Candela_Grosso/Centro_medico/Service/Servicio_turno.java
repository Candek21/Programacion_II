package Candela_Grosso.Centro_medico.Service;

import Candela_Grosso.Centro_medico.Entities.Turno;
import java.util.List;


public interface Servicio_turno {
    //Listamos los turnos
    List<Turno> obtenerTurnos();

    //Dar de alta un turno
    void guardarTurno(Turno turno);

    //Update turno
    void getTurno(int id);

    Turno obtenerTurnoPorId(int id);

    //Eliminar paciente
    void eliminarTurno(int id);
}
