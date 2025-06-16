package util;

/*Classe criada apenas para testar a requisição de conexão ao banco
de dados, de modo a verificar se o SGBD MySQl está rodando na porta 3306,
se os parâmetros como endereço IP do servidor, nome de usuário,
senha e nome do banco de dados estão corretos, utilizando-se
o driver JDBC para MySQL*/

import dao.*;

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
//                UsuariosDAO usuariosDAO2 = new UsuariosDAO();
//                usuariosDAO2.pesquisarUsuario();
//                UsuariosDAO usuariosDAO3 = new UsuariosDAO();
//                usuariosDAO3.alterarUsuario();
//                UsuariosDAO usuariosDAO4 = new UsuariosDAO();
//                usuariosDAO4.pesquisarUsuario();
//
//                ClientesDAO clientesDAO = new ClientesDAO();
//                clientesDAO.inserirCliente();
//                ClientesDAO clientesDAO2 = new ClientesDAO();
//                clientesDAO2.alterarClientes();
//                ClientesDAO clientesDAO3 = new ClientesDAO();
//                clientesDAO3.deletarCliente();
//                ClientesDAO clientesDAO4 = new ClientesDAO();
//                clientesDAO4.pesquisarClientes();
//
//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.inserirQuarto();
//                QuartosDAO quartosDAO2 = new QuartosDAO();
//                quartosDAO2.deletarQuarto();
//                QuartosDAO quartosDAO3 = new QuartosDAO();
//                quartosDAO3.alterarQuarto();
//                QuartosDAO quartosDAO4 = new QuartosDAO();
//                quartosDAO4.pesquisarQuartos();
//
//                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
//                adicionaisDAO.inserirAdicionais();
//                AdicionaisDAO adicionaisDAO2 = new AdicionaisDAO();
//                adicionaisDAO2.deletarAdicinais();
//                AdicionaisDAO adicionaisDAO3 = new AdicionaisDAO();
//                adicionaisDAO3.alterarAdicinais();
//                AdicionaisDAO adicionaisDAO4 = new AdicionaisDAO();
//                adicionaisDAO4.pesquisarAdicionais();
//
//                RoleDAO roleDAO = new RoleDAO();
//                roleDAO.inserirCargo();
//                RoleDAO roleDAO2 = new RoleDAO();
//                roleDAO2.deletarRole();
//                RoleDAO roleDAO3 = new RoleDAO();
//                roleDAO3.alterarRole();
//                RoleDAO roleDAO4 = new RoleDAO();
//                roleDAO4.pesquisarRoles();
//
//                PedidosDAO pedidosDAO = new PedidosDAO();
//                pedidosDAO.inserirPedidos();
//                PedidosDAO pedidosDAO2 = new PedidosDAO();
//                pedidosDAO2.deletarPedidos();
//                PedidosDAO pedidosDAO3 = new PedidosDAO();
//                pedidosDAO3.alterarPedidos();
//                PedidosDAO pedidosDAO4 = new PedidosDAO();
//                pedidosDAO4.pesquisarPerdidos();


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