package Springboot.CadastroNinja.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas"; // Tem que retornar o nome da pagina que renderiza
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "redirect:ninjas/ui/listar";
    }

    @PutMapping("/alterar/{id}")
    public String alterarNinjaPorId(@PathVariable Long id, Model model){
        NinjaDTO ninja = ninjaService.atualizarNinja(id);

        if (ninja != null){
            model.addAttribute("ninjas", ninja);
            return "detalhesninja";
        } else {
            model.addAttribute("mensagem", "Ninja nao encontrado");
            return "listarNinjas";
        }
    }




}
