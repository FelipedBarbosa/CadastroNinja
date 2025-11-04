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
    @GetMapping ("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    // Procurar Ninja por ID (CREATE)
    @GetMapping ("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostrar os Ninjas (READ)
    @GetMapping ("/listarID")
    public String mostrarTodos0sNinjasId(){
        return "Mostrar Ninja Criado";
    }

    // Alterar Dados Dos Ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja Por ID";
    }
    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja Deletado por Id";
    }


}