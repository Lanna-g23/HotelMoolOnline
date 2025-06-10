package dao;

import model.Cliente;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCliente(/*Usuario usuario*/) {
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
            System.out.println("Erro ao inserir usuario:" + erro);
            return false;
        }
    }

    public boolean deletarCliente(Cliente cliente) {
        try {
            Connection con = conexao.conectar();
            PreparedStatement removeCliente = con.prepareStatement("DELETE FROM clientes WHERE id = ?;");
            removeCliente.setInt(1, 1);
            int linhaAfetada = removeCliente.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario:" + erro);
            return false;
        }
    }
}
