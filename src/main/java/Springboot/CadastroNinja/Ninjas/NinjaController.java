package Springboot.CadastroNinja.Ninjas;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private  NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/BoasVindas")
    public String BoasVindas() {
        return  "Essa é minha primeira menssagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping ("/criar")
    public NinjaModel criarNinja (@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar os Ninjas (READ)
    @GetMapping ("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar os Ninjas por Id (READ)
    @GetMapping ("/listar/{id}")
    public NinjaModel listarNinjasPorId (@PathVariable Long id){
        return ninjaService.listarNinjasPorId (id);
    }

    // Alterar Dados Dos Ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja Por ID";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }


}