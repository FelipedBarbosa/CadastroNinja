package Springboot.CadastroNinja.Ninjas;
import Springboot.CadastroNinja.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

//Transforma uma classe em uma entidade
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // @ManyToOne um ninja tem apenas uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foring key ou chave estrangeira
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
