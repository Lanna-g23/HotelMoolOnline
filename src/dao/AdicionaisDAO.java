package dao;

import model.Adicionais;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais(/*Usuario usuario*/) {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement novoAdiciona = conn.prepareStatement("INSERT INTO adicionais " +
                    "(nome, preco) VALUES  (?, ?);");

            //Setar os parâmetro
            novoAdiciona.setString(1, "Matheus");
            novoAdiciona.setDouble(2, 123.0);

            int linhaAfetada = novoAdiciona.executeUpdate();
            novoAdiciona.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario:" + erro);
            return false;
        }
    }

    public boolean deletarAdicinais(Adicionais adicionais) {
        try {
            Connection connd = conexao.conectar();
            PreparedStatement removeAdiciona = connd.prepareStatement("DELETE FROM adicionais WHERE id = ?;");
            removeAdiciona.setInt(1, 1);
            int linhaAfetada = removeAdiciona.executeUpdate();
            connd.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario:" + erro);
            return false;
        }
    }

    public boolean alterarRole() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement adicionaisAlterado = conn.prepareStatement("UPDATE usuarios" +
                    " SET nome = ?, email = ?, senha = md5(?) + ?," +
                    "role_id = ? WHERE id = ?;");

            adicionaisAlterado.setString(1, "Pamela");
            adicionaisAlterado.setString(2, "pamellapereto@gmail.com");
            adicionaisAlterado.setString(3, "123");
            adicionaisAlterado.setInt(4, 1);
            adicionaisAlterado.setInt(5, 1); //Alterar usuário c/ chave primária ID=1
            int linhaAfetada = adicionaisAlterado.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario:" + erro);
            return false;

        }
    }
}