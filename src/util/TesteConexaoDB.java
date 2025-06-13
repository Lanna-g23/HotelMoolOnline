package util;

/*Classe criada apenas para testar a requisição de conexão ao banco
de dados, de modo a verificar se o SGBD MySQl está rodando na porta 3306,
se os parâmetros como endereço IP do servidor, nome de usuário,
senha e nome do banco de dados estão corretos, utilizando-se
o driver JDBC para MySQL*/

import dao.*;
import model.Adicionais;

import java.sql.Connection;

public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("Conexão estabelcida com sucesso!");

            try {
//                UsuariosDAO usuariosDAO = new UsuariosDAO();
//                usuariosDAO.inserirUsuario();
//                UsuariosDAO usuariosDAO = new UsuariosDAO();
//                usuariosDAO.pesquisarUsuario();
//                UsuariosDAO usuariosDAO = new UsuariosDAO();
//                usuariosDAO.alterarUsuario();
//
//                ClientesDAO clientesDAO = new ClientesDAO();
//                clientesDAO.inserirCliente();
//
//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.inserirQuarto();
//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.deletarQuarto();
//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.alterarQuarto();
//
//                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
//                adicionaisDAO.inserirAdicionais();
//                AdicionaisDAO adicionaisDAO2 = new AdicionaisDAO();
//                adicionaisDAO2.deletarAdicinais();
//                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
//                adicionaisDAO.alterarAdicinais();
//
//                RoleDAO roleDAO = new RoleDAO();
//                roleDAO.inserirCargo();
//                RoleDAO roleDAO2 = new RoleDAO();
//                roleDAO2.deletarRole();
//                RoleDAO roleDAO3 = new RoleDAO();
//                roleDAO3.alterarRole();
//
//                PedidosDAO pedidosDAO = new PedidosDAO();
//                pedidosDAO.inserirPedidos();


                //System.out.println("Usuarios inseridos com sucesso!");
                condb.close();
                System.out.println("Conexão encerrada!");

            } catch (Exception erro) {
                System.out.println("Erro ao conectar ao banco de dados!");
            }
        }else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}