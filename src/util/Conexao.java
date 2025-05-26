package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
    //TAREFA DE RETORNO DO INTEVALO: declarar 4 variaveis com o seu tipo terminado e alorcar o valor para cada

    //jdba:mysql://localhost:porta/nome do banco
    private String url;
    private String driver;
    private String usuario;
    private String senha;

    /*inicializar um construtor, de modo que quando essa classe Conexão.java instanciar um objeto,
    o construtor será executado e a classe Conexão.java inicializada*/

    public Conexao() {
        carregarConfiguracoes();
    }

    /* Metodo com os paranmetros do configuração das variaveis de ambiente */
    public void carregarConfiguracoes() {
        Properties props = new Properties();
        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream("config.properties")) {

            props.load(inputPropsConfig);
            url = props.getProperty("url");
            driver = props.getProperty("driver");
            usuario = props.getProperty("usuario");
            senha = props.getProperty("senha");

        } catch (IOException erro) {
            System.out.println("Erro ao carregar configurações: " + erro.getMessage());

        }
    }

    public Connection conectar() {
        //Objeto da conexao inicializar nulo pois não se saber se o banco vai responder
        Connection condb = null;

        try {
            /*Especifica a rota do Driver a ser carregado (JDBC para SGBD MySQL)*/
            Class.forName(driver);

            /*Inicializar o driver ja carregador por meio do metodo getConnection(IP, Porta, Nome do banco, Usuario, Senha)*/

           condb = DriverManager.getConnection(url, usuario, senha);
           return condb;

        } catch (SQLException | ClassNotFoundException erro) {
            System.out.println("Erro ao conectar ao Banco de Dados" + erro);
            return null;
        }
    }
}