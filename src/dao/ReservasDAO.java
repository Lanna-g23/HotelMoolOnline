package dao;

import model.Reserva;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservasDAO{

    private Conexao conexao = new Conexao();

    public boolean deletarReseva(Reserva reserva) {

        try {
            Connection conn = conexao.conectar();
            PreparedStatement removeReserva = conn.prepareStatement("DELETE FROM Reservas WHERE id = ?;");
            removeReserva.setInt(1, 1);
            int linhaAfetada = removeReserva.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario:" + erro);
            return false;
        }
    }
    public boolean alterarReserva(Reserva reserva) {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement reservaAlterado = conn.prepareStatement("UPDATE reservas" +
                    " SET pedido_id = ?, quarto_id = ?, adicional_id ?  WHERE id = ?;");

            reservaAlterado.setInt(1, 1);
            reservaAlterado.setInt(2, 1);
            reservaAlterado.setInt(4, 1);
            reservaAlterado.setInt(5, 1); //Alterar usuário c/ chave primária ID=1
            int linhaAfetada = reservaAlterado.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario:" + erro);
            return false;
        }
    }
}
