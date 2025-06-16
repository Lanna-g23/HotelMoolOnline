package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientesDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCliente() {
        try {
            Connection con = conexao.conectar();
            PreparedStatement novoCliente = con.prepareStatement("INSERT INTO clientes " +
                    "(nome, cpf, telefone, email)VALUES  (?, ?, ?, ?);");

            //Setar os parâmetro
            novoCliente.setString(1, "Lanna Giullia");
            novoCliente.setString(2, "111");
            novoCliente.setString(3, "6666666666");
            novoCliente.setString(4, "lanna@gmail.com");


            int linhaAfetada = novoCliente.executeUpdate();
            novoCliente.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }

    public boolean deletarCliente() {
        try {
            Connection con = conexao.conectar();
            PreparedStatement removeCliente = con.prepareStatement("DELETE FROM clientes WHERE id = ?;");
            removeCliente.setInt(1, 1);
            int linhaAfetada = removeCliente.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar cliente: " + erro);
            return false;
        }
    }

    public boolean alterarClientes() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement clienteAlterado = conn.prepareStatement("UPDATE clientes" +
                    " SET nome = ?, cpf = ?, telefone = ?, email = ?  WHERE id = ?;");

            clienteAlterado.setString(1, "Lanna");
            clienteAlterado.setString(2, "776892445-12");
            clienteAlterado.setString(3, "(15)66666666");
            clienteAlterado.setString(4, "lanna@gmail.com");
            clienteAlterado.setInt(5, 10);

            int linhaAfetada = clienteAlterado.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar cliente: " + erro);
            return false;
        }
    }
    public void pesquisarClientes() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaClientes = conndb.prepareStatement("SELECT nome, cpf, telefone, email FROM clientes WHERE id = ?;");
            buscaClientes.setInt(1, 10);

            ResultSet resultado = buscaClientes.executeQuery();
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String telefone = resultado.getString("telefone");
                String email = resultado.getString("email");
                System.out.println("Nome: " + nome + " CPF: " + cpf + " Telefone: " + telefone + " Email: " + email);
            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar cliente: " + erro);
        }
    }
}
