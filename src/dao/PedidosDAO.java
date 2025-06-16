package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirPedidos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoPedido = conndb.prepareStatement("INSERT INTO pedidos" +
                    "(pagamento, usuario_id, cliente_id) VALUES (?, ?, ?);");

            novoPedido.setString(1, "pix");
            novoPedido.setInt(2, 2);
            novoPedido.setInt(3, 1);


            int linhaAfetada = novoPedido.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario:" + erro);
            return false;
        }
    }

    public boolean deletarPedidos() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement removePedidos = conn.prepareStatement("DELETE FROM pedidos WHERE id = ?;");
            removePedidos.setInt(1, 1);
            int linhaAfetada = removePedidos.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar pedido: " + erro);
            return false;
        }
    }

    public boolean alterarPedidos() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement pedidoAlterado = conn.prepareStatement("UPDATE pedidos" +
                    " SET pagamento = ?, usuario_id = ?, cliente_id = ? WHERE id = ?;");

            pedidoAlterado.setString(1, "128.90");
            pedidoAlterado.setInt(2, 2);
            pedidoAlterado.setInt(3, 1);
            pedidoAlterado.setInt(4, 1);

//            pedidoAlterado.setInt(5, 1); //Alterar usuário c/ chave primária ID=1
            int linhaAfetada = pedidoAlterado.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar/ usuario:" + erro);
            return false;
        }
    }

    public void pesquisarPerdidos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaQuartos = conndb.prepareStatement("SELECT nome FROM pedidos WHERE id = ?;");
            buscaQuartos.setInt(1, 1);

            ResultSet resultado = buscaQuartos.executeQuery();
            while (resultado.next()) {
                String nome = resultado.getString("nome");
                System.out.println("Nome:" + nome);
            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar do perdido:" + erro);
        }
    }
}