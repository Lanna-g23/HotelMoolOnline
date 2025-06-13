package dao;

import model.Adicionais;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais() {
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
    public boolean deletarAdicinais() {
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

    public boolean alterarAdicinais() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement adicionaisAlterado = conn.prepareStatement("UPDATE adicionais" +
                    " SET nome = ?, preco = ? WHERE id = ?;");

            adicionaisAlterado.setString(1, "Maria");
            adicionaisAlterado.setDouble(2, 112.50);
            adicionaisAlterado.setInt(3, 1);

            int linhaAfetada = adicionaisAlterado.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario:" + erro);
            return false;
        }
    }
}
