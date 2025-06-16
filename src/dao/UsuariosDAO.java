package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO {
    //Objeto para instanciar classe Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios " +
                    "(nome, email, senha, role_id)VALUES  (?, ?, md5(?), ?);");

            //Setar os parâmetro
            novoUsuario.setString(1, "lanna");
            novoUsuario.setString(2, "lannaGresi@gmail.com");
            novoUsuario.setString(3, "123354");
            novoUsuario.setInt(4, 1);

            int linhaAfetada = novoUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }

    public boolean deletarUsuario() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement removeUsuario = conn.prepareStatement("DELETE FROM usuarios WHERE id = ?;");
            removeUsuario.setInt(1, 1);
            int linhaAfetada = removeUsuario.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }

    public boolean alterarUsuario() {
        try {
            Connection conn = conexao.conectar();
            PreparedStatement usuarioAlterado = conn.prepareStatement("UPDATE usuarios" +
                    " SET nome = ?, email = ?, senha = md5(?), role_id = ? WHERE id = ?;");

            usuarioAlterado.setString(1, "Lanna");
            usuarioAlterado.setString(2, "LannaGReis@gmail.com");
            usuarioAlterado.setString(3, "123354");
            usuarioAlterado.setInt(4, 1);
            usuarioAlterado.setInt(5, 17); //Alterar usuário c/ chave primária ID=1
            int linhaAfetada = usuarioAlterado.executeUpdate();
            conn.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar usuario: " + erro);
            return false;

        }
    }
    //Query Select
    public void pesquisarUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaUsuario = conndb.prepareStatement("SELECT nome, email"
                    + " FROM usuarios WHERE role_id = ?");
            buscaUsuario.setInt(1,1);

            ResultSet resultado = buscaUsuario.executeQuery();
            while (resultado.next()){
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                System.out.println("Nome: " + nome + " - Email: " + email);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
        }
    }
}

