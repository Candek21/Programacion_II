package Candela_Grosso.Centro_medico.Controller;

import Candela_Grosso.Centro_medico.Entities.Medicos;
import Candela_Grosso.Centro_medico.Service.Servicios_medicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //indica que esta clase va a ser un controlador

public class Controlador_medico {
    @Autowired
    private Servicios_medicos servicios_medicos;


    //PARA LISTAR TODOS LOS MEDICOS
    @GetMapping("/medicos")
    public String obtenerMedicos(Model model){
        model.addAttribute("listadoMedicos", servicios_medicos.obtenerMedicos());
        return "medicos";

    }

    @GetMapping("/nuevoMedico")
    public String nuevoMedico(Model model){
        Medicos medico = new Medicos();
        model.addAttribute("medico", medico);
        return "nuevo_medico";
    }

    @PostMapping("/guardarMedico")
    public String guardarMedicos(@ModelAttribute("medico") Medicos medico){
      servicios_medicos.guardarMedico(medico);
      return "redirect:/medicos";
    }

    @GetMapping("/modificarMedico/{id}")
    public String modificarMedico(@PathVariable(value = "id") int id, Model model){
        Medicos medicos = servicios_medicos.obtenerMedicoPorId(id);
        model.addAttribute("medico", medicos);
        return  "actualizar_medico";
    }

    @GetMapping("/elimiarMedico({id}")
        public String eliminarMedico(@PathVariable(value = "id") int id){
        this.servicios_medicos.eliminarMedico(id);
        return "redirect:/medicos";
    }
}

/* @Override
        public List<Medicos> obtenerMedicos() {
            return null;
        }

        @Override
        public Medicos guardarMedico(Medicos medico) {
            return null;
        }

        @Override
        public Medicos obtenerMedicoPorId(Long id) {
            return null;
        }

        @Override
        public Medicos modificarMedico(Long id, Medicos medico) {
            return null;
        }

        @Override
        public boolean eliminarMedico(Long id) {
            return false;
        }
    };*/
