package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            System.out.println("Erro ao inserir cargo: " + erro);
            return false;
        }
    }

    public boolean deletarRole() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement removeRole = conn.prepareStatement("DELETE FROM roles WHERE id = ?;");
            removeRole.setInt(1, 1);
            int linhaAfetada = removeRole.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar cargo: " + erro);
            return false;
        }
    }

    public boolean alterarRole() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement roleAlterado = conn.prepareStatement("update roles" +
                    " set nome = ? WHERE id = ?");

            roleAlterado.setString(1, "adm");
            roleAlterado.setInt(2, 4);

            int linhaAfetada = roleAlterado.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar cargo: " + erro);
            return false;
        }
    }

    public void pesquisarRoles() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaRoles = conndb.prepareStatement("SELECT nome FROM roles WHERE id = ?;");
            buscaRoles.setInt(1,1);

            ResultSet resultado = buscaRoles.executeQuery();
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                System.out.println("Nome:" + nome);
            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar do cargo:" + erro);
        }
    }
}

