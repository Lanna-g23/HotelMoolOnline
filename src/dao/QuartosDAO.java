package dao;

import model.Quarto;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirQuarto(/*Usuario usuario*/) {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement novoQuarto = conn.prepareStatement("INSERT INTO quartos " +
                    "(nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel)VALUES  (?, ?, ?, ?, ?, ?);");

            //Setar os parâmetro
            novoQuarto.setString(1, "Marcia");
            novoQuarto.setString(2, "22");
            novoQuarto.setInt(3, 2);
            novoQuarto.setInt(4, 0);
            novoQuarto.setDouble(5, 123.87);
            novoQuarto.setBoolean(6, true);


            int linhaAfetada = novoQuarto.executeUpdate();
            novoQuarto.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario:" + erro);
            return false;
        }
    }

    public boolean deletarQuarto(Quarto quarto) {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement removeQuarto = conn.prepareStatement("DELETE FROM quarto WHERE id = ?;");
            removeQuarto.setInt(1, 1);
            int linhaAfetada = removeQuarto.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario:" + erro);
            return false;
        }
    }
}
