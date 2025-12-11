package Springboot.CadastroNinja.Ninjas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/BoasVindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela" )
    public String BoasVindas() {
        return  "Essa é minha primeira menssagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping ("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Essa rota cria um novo ninja e insere no banco de dados" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao do ninja")
    })
    public ResponseEntity <String> criarNinja (@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "(ID): " + novoNinja.getId());
    }

    // Mostrar os Ninjas (READ)
    @GetMapping ("/listar")
    public ResponseEntity <List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar os Ninjas por Id (READ)
    @GetMapping ("/listar/{id}")
    @Operation(summary = "Lista o ninja por id", description = "Rota lista um ninja pelo id referido" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    public ResponseEntity <?> listarNinjasPorId (@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja !=null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: " + id + "nao existe em nossos registros");
        }
    }

    // Alterar Dados Dos Ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por id", description = "Essa rota altera o ninja pelo id" )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado, nao foi possivel alterar")
    })
    public ResponseEntity<?> alterarNinjaPorId(
        @Parameter(description = "Usuario manda o id no caminho da requisicao")
        @PathVariable Long id,
        @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisicao ")
        @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: " + id + "nao existe nos nossos registros");
        }
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity <String> deletarNinjaPorId(@PathVariable Long id) {

        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID" + id + "deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + "nao encontrado");
        }
    }
}