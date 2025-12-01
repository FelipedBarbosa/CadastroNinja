package Springboot.CadastroNinja.Ninjas;
import Springboot.CadastroNinja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

//Transforma uma classe em uma entidade
// JPA = Java Persistence API

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "nome")
        private String nome;

        @Column(unique = true)
        private String email;

        @Column(name = "img_url")
        private String imgUrl;

        @Column(name = "idade")
        private int idade;

        @ManyToOne
        @JoinColumn(name = "missao_id")
        private MissoesModel missao;


}




