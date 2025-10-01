package Springboot.CadastroNinja.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // GET -- Mandar uma requisicao para mostrar as missoes
    @GetMapping("listar")
    public String listarMissao(){
        return "Missao listadas com sucesso";
    }

    // Post -- Mandar uma requisicao para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada com sucesso";
    }

    // PUT -- Mandar uma requisicao para alterar as missoes
    @PutMapping ("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }

    // Delet -- Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }
}
