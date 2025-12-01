Sistema de Cadastro de Ninjas

O Sistema de Cadastro de Ninjas é uma aplicação desenvolvida em arquitetura de camadas utilizando Spring Boot. O projeto tem como objetivo cadastrar ninjas e gerenciar suas respectivas missões. Ele utiliza o banco de dados H2 em memória durante o desenvolvimento, Flyway para versionamento de migrações e adota boas práticas como controle de versão com Git e hospedagem do repositório no GitHub. Além disso, o projeto inclui conteúdos extras abordando banco de dados de forma mais aprofundada.

Visão Geral do Projeto

O sistema foi criado para gerenciar ninjas e suas missões. Cada ninja pode ser associado a apenas uma missão, enquanto uma missão pode estar vinculada a vários ninjas. As funcionalidades principais incluem o cadastro de ninjas com informações como nome, idade, email e rank, a atribuição de missões e o gerenciamento completo das missões e dos ninjas relacionados a elas.

Tecnologias Utilizadas

O projeto utiliza Spring Boot para criação da aplicação web e gerenciamento de dependências, H2 como banco de dados em memória, Flyway para controle de migrações, JPA e Spring Data JPA para mapeamento objeto-relacional, Git e GitHub para versionamento e hospedagem do código, Maven para build e gerenciamento de dependências, Docker para execução externa do banco de dados e SQL para manipulação dos dados.

Design do Banco de Dados

O banco de dados segue uma estrutura simples e funcional. A entidade Ninja contém atributos como id, nome, idade, email e rank. A entidade Missão possui id, título e descrição. A relação entre as entidades é definida da seguinte forma: um ninja pode ter apenas uma missão, enquanto uma missão pode ser atribuída a vários ninjas.

Configuração do Projeto

Para executar o projeto localmente, siga os passos abaixo:

git clone https://github.com/horaciomuller/CadastroDeNinjas.git

cd CadastroDeNinjas

mvn clean install

mvn spring-boot:run

Após a execução, a aplicação estará disponível em:
http://localhost:8080
