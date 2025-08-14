package Springboot.CadastroNinja.Missoes;
import Springboot.CadastroNinja.Ninjas.NinjaModel;
import jakarta.persistence.*;
import org.springframework.core.NamedInheritableThreadLocal;

import javax.xml.transform.sax.SAXResult;
import java.util.List;

@Entity
@Table (name = "tb_missoes")
public class MissoesModel {


    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    private NinjaModel ninja;
    //  @OneToMany uma missão pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

}
