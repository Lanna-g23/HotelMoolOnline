package dao;

import model.Role;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RoleDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCargo() {
        try {
            Connection con = conexao.conectar();
            PreparedStatement novoRole = con.prepareStatement("INSERT INTO roles " +
                    "(nome)VALUES  (?);");

            novoRole.setString(1, "Dono");

            int linhaAfetada = novoRole.executeUpdate();
            novoRole.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario:" + erro);
            return false;
        }
    }

    public boolean deletarRole(Role role) {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement removeRole = conn.prepareStatement("DELETE FROM roles WHERE id = ?;");
            removeRole.setInt(1, 1);
            int linhaAfetada = removeRole.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario:" + erro);
            return false;
        }
    }

    public boolean alterarRole() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement roleAlterado = conn.prepareStatement("UPDATE usuarios" +
                    " SET nome = ?, email = ?, senha = md5(?) + ?," +
                    "role_id = ? WHERE id = ?;");

            roleAlterado.setString(1, "Pamela");
            roleAlterado.setString(2, "pamellapereto@gmail.com");
            roleAlterado.setString(3, "123");
            roleAlterado.setInt(4, 1);
            roleAlterado.setInt(5, 1); //Alterar usuário c/ chave primária ID=1
            int linhaAfetada = roleAlterado.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario:" + erro);
            return false;

        }
    }
}

