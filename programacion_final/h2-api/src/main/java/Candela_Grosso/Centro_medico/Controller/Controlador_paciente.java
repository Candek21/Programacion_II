package Candela_Grosso.Centro_medico.Controller;

import Candela_Grosso.Centro_medico.Entities.Paciente;
import Candela_Grosso.Centro_medico.Service.Servicios_pacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController //indica que esta clase va a ser un controlador

public class Controlador_paciente {
    @Autowired
     private Servicios_pacientes servicios_paciente;

    @GetMapping("/pacientes")
    public String obtenerPacientes (Model model){
        model.addAttribute("listadoPacientes", servicios_paciente.obtenerPaciente());
        return "pacientes";
    }

    @GetMapping("/nuevoPaciente")
    public String nuevoPaciente(Model model){
        Paciente paciente = new Paciente();
        model.addAttribute("pacientes", paciente);
        return "nuevo_paciente";
    }

    @PostMapping("/guardarPaciente")
    public String guardarPaciente(@ModelAttribute("paciente") Paciente paciente){
        servicios_paciente.guardarPaciente(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/modificarPaciente/{id}")
    public String modificarPaciente(@PathVariable(value="id") int id, Model model ){
        Paciente paciente = servicios_paciente.obtenerPacientePorId(id);
        model.addAttribute("paciente", paciente);
        return "modificarPacientes";
    }

    @GetMapping("/deletePaciente/{id}")
    public String eliminarPaciente(@PathVariable(value="id") int id){
        servicios_paciente.eliminarPaciente(id);
        return "redirect:/pacientes";
    }
}
