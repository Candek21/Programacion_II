package Candela_Grosso.Centro_medico.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main_controlador {

    @GetMapping("/")
    public String verHome(){return "index";}
}
