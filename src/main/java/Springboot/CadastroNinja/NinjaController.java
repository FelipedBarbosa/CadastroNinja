package Springboot.CadastroNinja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/BoasVindas") public String BoasVindas() {
        return  "Essa é minha primeira menssagem nessa rota";
    }
}