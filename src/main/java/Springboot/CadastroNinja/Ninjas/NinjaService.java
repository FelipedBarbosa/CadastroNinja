package Springboot.CadastroNinja.Ninjas;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar Todos os Meus Ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    // Listar todos os meus ninjas por ID
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // Criar um Novo Ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    // Deletar - Tem que ser um metodo void
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById( id);
    }



}
