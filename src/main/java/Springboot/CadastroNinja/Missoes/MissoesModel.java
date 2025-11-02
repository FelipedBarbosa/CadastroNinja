package Springboot.CadastroNinja.Missoes;
import Springboot.CadastroNinja.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.core.NamedInheritableThreadLocal;

import javax.xml.transform.sax.SAXResult;
import java.util.List;

@Entity
@Table (name = "tb_missoes")
public class MissoesModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    //  @OneToMany uma missão pode ter varios ninjas
    @OneToMany(mappedBy = "missao")
    @JsonIgnore
    private List<NinjaModel> ninjas;

}
