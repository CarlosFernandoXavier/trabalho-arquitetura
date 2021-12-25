# trabalho-arquitetura
Este trabalho consite em uma aplicação Rest que utiliza o swagger como documentação e consumo da API

### Pré requisitos:
- Java 11;
- Gradle;
- Git bash (opcional);
- Intellij ou outra ide;
- Ter o o plugin Lombok instalado na sua IDE;
- Habilitar o processamento de anotações da sua IDE;

### Passos para execução do código:
- Abra o gitbash e digite o comando: git clone https://github.com/CarlosFernandoXavier/trabalho-arquitetura.git
- Entre dentro do projeto e digite: **./gradlew clean build**
- Crie um banco no mongoDB Atlas: https://www.mongodb.com/pt-br/cloud/atlas/register
- Insira o usuário, senha e o nome do banco na linha abaixo, encontrada no arquivo application.properties: spring.data.mongodb.uri=mongodb+srv://seu_usuario:sua_senha@cluster0.ytaoj.mongodb.net/nome_do_banco_de_dados 
- Abra o projeto na sua ide e execute o arquivo chamado SistemaApplication

### Link de acesso a aplicação:
http://127.0.0.1:8080/sistema/swagger-ui/index.html

