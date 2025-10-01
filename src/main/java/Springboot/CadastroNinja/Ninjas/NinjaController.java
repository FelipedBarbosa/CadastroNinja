package Springboot.CadastroNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/BoasVindas")
    public String BoasVindas() {
        return  "Essa é minha primeira menssagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping ("/Criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    // Procurar Ninja por ID (CREATE)
    @PostMapping ("/todos")
    public String mostrarTodos0sNinjas(){
        return "Mostrar Ninja";
    }

    // Mostrar os Ninjas (READ)
    @PostMapping ("/todosID")
    public String mostrarTodos0sNinjasId(){
        return "Mostrar Ninja Criado";
    }

    // Alterar Dados Dos Ninjas (UPDATE)
    @PutMapping("/AlterarID")
    public String alterarNinjaPorId(){
        return "Alterar Ninja Por ID";
    }
    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Ninja Deletado por Id";
    }


}