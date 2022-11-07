package Candela_Grosso.Centro_medico.Service;

import Candela_Grosso.Centro_medico.Entities.*;
import Candela_Grosso.Centro_medico.Repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servicio_turno_implementacion implements Servicio_turno {
    @Autowired
    private TurnoRepository repositorioTurno;

    public List<Turno> obtenerTurnos() {
        return repositorioTurno.findAll();
    }

    @Override
    public void guardarTurno(Turno turno){
        this.repositorioTurno.save(turno);
    }

    @Override
    public void getTurno(int id) {

    }

    @Override
    public Turno obtenerTurnoPorId(int id){
        Optional<Turno> optional= repositorioTurno.findById(id);
        Turno turno = null;
        if(optional.isPresent()){
            turno=optional.get();
        }else {
            throw new RuntimeException("Turno no encontrado. ID: " + id);
        }
        return  turno;
    }

    @Override
    public void  eliminarTurno(int id){
        this.repositorioTurno.deleteById(id);
    }
}
