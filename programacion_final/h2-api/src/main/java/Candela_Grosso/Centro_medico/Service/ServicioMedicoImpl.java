package Candela_Grosso.Centro_medico.Service;

import Candela_Grosso.Centro_medico.Entities.Medicos;
import Candela_Grosso.Centro_medico.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//implementa los métedos de medicos

public class ServicioMedicoImpl implements Servicios_medicos {
    @Autowired
    private MedicoRepository repositorioMedico;

    @Override
    public List<Medicos> obtenerMedicos() {
        return repositorioMedico.findAll();
    }

    @Override
    public Medicos guardarMedico(Medicos medico) {
        return repositorioMedico.save(medico);
    }

    @Override
    public void eliminarMedico(int id) {
        this.repositorioMedico.deleteById(id);
    }

    @Override
    public Medicos obtenerMedicoPorId(int id){
        Optional<Medicos> optional = repositorioMedico.findById(id);
        Medicos medico= null;
        if(optional.isPresent()){
            medico = optional.get();
        }else{
            throw new RuntimeException("No existe médico con id " + id);
        }
        return medico;
    }
    /*@Override
    public Medicos modificarMedico(int id, Medicos medico) {
        Medicos medicoSelected = repositorioMedico.findById(id);
        medicoSelected.setMatricula(medicoSelected.getMatricula());
        medicoSelected.setNombre_apellido(medicoSelected.getNombre_apellido());
        return repositorioMedico.save(medicoSelected);
    }*/


}
