package Candela_Grosso.Centro_medico.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controlador_login {

    @RequestMapping("/index")
    public String login() {
        return "index";
    }
}
