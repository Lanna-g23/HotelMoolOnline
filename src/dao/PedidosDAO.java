package dao;


import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoPedido = conndb.prepareStatement("INSERT INTO pedidos " +
                    "(pagamento, usuario_id, cliente_id) VALUES (?, ?, ?);");

            novoPedido.setInt(1, 3);
            novoPedido.setInt(2, 4);
            novoPedido.setString(3, "Dinheiro");

            int linhaAfetada = novoPedido.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario:" + erro);
            return false;
        }
    }

    public boolean alterarPedidos() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement pedidoAlterado = conn.prepareStatement("UPDATE usuarios" +
                    " SET nome = ?, email = ?, senha = md5(?) + ?," +
                    "role_id = ? WHERE id = ?;");

            pedidoAlterado.setString(1, "Pamela");
            pedidoAlterado.setString(2, "pamellapereto@gmail.com");
            pedidoAlterado.setString(3, "123");
            pedidoAlterado.setInt(4, 1);
            pedidoAlterado.setInt(5, 1); //Alterar usuário c/ chave primária ID=1
            int linhaAfetada = pedidoAlterado.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario:" + erro);
            return false;

        }
    }
}
