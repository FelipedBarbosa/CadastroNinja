package Springboot.CadastroNinja.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

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
}
