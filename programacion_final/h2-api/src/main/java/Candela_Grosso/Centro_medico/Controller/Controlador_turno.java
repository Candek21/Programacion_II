package Candela_Grosso.Centro_medico.Controller;

import Candela_Grosso.Centro_medico.Entities.Turno;
import Candela_Grosso.Centro_medico.Entities.Medicos;
import Candela_Grosso.Centro_medico.Entities.Paciente;
import Candela_Grosso.Centro_medico.Service.Servicios_medicos;
import Candela_Grosso.Centro_medico.Service.Servicios_pacientes;
import Candela_Grosso.Centro_medico.Service.Servicio_turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador_turno {
    @Autowired
    private Servicio_turno serviciosTurno;

    //para elegir el paciente
    @Autowired
    private Servicios_pacientes serviciosPacientes;

    @Autowired
    private Servicios_medicos serviciosMedicos;

    //Listado de turnos
    @GetMapping("/turnos")
    public String verTurnos(Model model){
        model.addAttribute("listadoTurnos", serviciosTurno.obtenerTurnos());
        return "turnos";
    }

    //nuevo turno
    @GetMapping("/nuevoTurno")
    public String nuevoTurno(@PathVariable(value = "id") Long id, Model model){
        Turno turno = new Turno();
        List<Medicos> medicosList= serviciosMedicos.obtenerMedicos();
        List<Paciente> pacienteList = serviciosPacientes.obtenerPaciente();
        model.addAttribute("turno",turno);
        model.addAttribute("pacienteList", pacienteList);
        model.addAttribute("medicosList", medicosList);
        return "Addturnos";
    }

    @PostMapping("/guardarTurno")
    public String guardarTurno(@ModelAttribute("turno") Turno turno){
        serviciosTurno.guardarTurno(turno);
        return "redirect:/turnos";
    }

    //Actualizar turnos
    @GetMapping("/modificarTurno/{id}")
    public String modificarTurno(@PathVariable(value = "id") int id, Model model){
        Turno turno = serviciosTurno.obtenerTurnoPorId(id);
        List<Paciente> pacienteList = serviciosPacientes.obtenerPaciente();
        List<Medicos> medicosList = serviciosMedicos.obtenerMedicos();
        model.addAttribute("pacienteList", pacienteList);
        model.addAttribute("medicoList", medicosList);
        model.addAttribute("turno", turno);
        return "update_turnos";
    }

    //Eliminar turno
    @GetMapping("/eliminarTurno/{id}")
    public String eliminarTurno(@PathVariable (value = "id") int id){
        serviciosTurno.eliminarTurno(id);
        return "redirect:/turnos";
    }
}
