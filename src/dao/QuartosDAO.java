package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirQuarto() {
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
            novoQuarto.setBoolean(-6, true);


            int linhaAfetada = novoQuarto.executeUpdate();
            novoQuarto.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }

    public boolean deletarQuarto() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement removeQuarto = conn.prepareStatement("DELETE FROM quartos WHERE id = ?;");
            removeQuarto.setInt(1, 7);
            int linhaAfetada = removeQuarto.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar quarto: " + erro);
            return false;
        }
    }

    public boolean alterarQuarto() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement clienteAlterado = conn.prepareStatement("UPDATE quartos" +
                    " SET nome = ?, numero = ?, qtd_cama_casal = ?, qtd_cama_casal = ?, preco = ?, disponivel = ?  WHERE id = ?;");

            clienteAlterado.setString(1, "Lanna");
            clienteAlterado.setString(2, "22");
            clienteAlterado.setInt(3, 2);
            clienteAlterado.setInt(4, 0);
            clienteAlterado.setDouble(5, 76.87);
            clienteAlterado.setBoolean(6, true);
            clienteAlterado.setInt(7, 8);

            int linhaAfetada = clienteAlterado.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar quarto: " + erro);
            return false;
        }
    }

    public void pesquisarQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaRoles = conndb.prepareStatement("SELECT nome, numero FROM quartos WHERE id = ?;");
            buscaRoles.setInt(1, 9);

            ResultSet resultado = buscaRoles.executeQuery();
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String numero = resultado.getString("numero");
                System.out.println("Nome: " + nome + " Numero: " + numero);
            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar quarto:" + erro);
        }
    }
}