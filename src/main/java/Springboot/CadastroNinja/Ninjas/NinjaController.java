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
    public NinjaDTO criarNinja (@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Mostrar os Ninjas (READ)
    @GetMapping ("/listar")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar os Ninjas por Id (READ)
    @GetMapping ("/listar/{id}")
    public NinjaDTO listarNinjasPorId (@PathVariable Long id){
        return ninjaService.listarNinjasPorId (id);
    }

    // Alterar Dados Dos Ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }


}