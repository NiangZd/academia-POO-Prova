package persistencia;

import aplicacao.Instrutor;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class InstrutorDAO {
    private static Conexao con;

    public static void setConexao(Conexao conexao) {
        con = conexao;
    }

    public static void inserirInstrutor(Instrutor i1) {
        try {
            con.conectar();

            PreparedStatement instrucao = con.getCon().prepareStatement("INSERT INTO instrutores (nome, email, senha) VALUES (?, ?, ?)");
            instrucao.setString(1, i1.getNome());
            instrucao.setString(2, i1.getEmail());
            instrucao.setString(3, i1.getSenha());

            int linhasAfetadas = instrucao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Inserção realizada com sucesso.");
            } else {
                System.out.println("Nenhuma linha afetada durante a inserção.");
            }

        } catch (SQLException e) {
            System.out.println("ERRO NO METODO: " + e.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void alterarInstrutor(int id, Instrutor i1) {
        try {
            con.conectar();

            String sql = "UPDATE instrutores SET nome = ?, email = ?, senha = ?  WHERE id_instrutor = ?";
            PreparedStatement instrucao = con.getCon().prepareStatement(sql);

            instrucao.setString(1, i1.getNome());
            instrucao.setString(2, i1.getEmail());
            instrucao.setString(3, i1.getSenha());
            instrucao.setInt(4, id);

            int linhasAfetadas = instrucao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Alteração realizada com sucesso.");
            } else {
                System.out.println("Nenhuma linha afetada durante a alteração.");
            }
        } catch (SQLException e) {
            System.out.println("ERRO NO METODO: " + e.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void deletarInstrutors(int id) {
        try {

            FichaTreinoDAO.deletarFichaTreinosPI(id);

            con.conectar();

            String sql = "DELETE FROM instrutores WHERE id_instrutor = ?";
            PreparedStatement instrucao = con.getCon().prepareStatement(sql);

            instrucao.setInt(1, id);

            int linhasAfetadas = instrucao.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Alteração realizada com sucesso.");
            } else {
                System.out.println("Nenhuma linha afetada durante a alteração.");
            }

        } catch (SQLException e) {
            System.out.println("ERRO NO METODO: " + e.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static Instrutor buscarInstrutor(int id) {
        Instrutor i1 = null;
        try {
            con.conectar();

            String sql = "SELECT * FROM instrutores WHERE id_instrutor = ?";
            PreparedStatement instrucao = con.getCon().prepareStatement(sql);
            instrucao.setInt(1, id);

            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                i1 = new Instrutor(nome, email, senha);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar o Instrutor: " + e.getMessage());
        } finally {
            con.desconectar();
        }
        return i1;
    }

    public static ArrayList<Instrutor> retornarLista(String parteNome) {
        ArrayList<Instrutor> listaInstrutors = new ArrayList<Instrutor>();

        try {
            con.conectar();
            String sql = "SELECT * FROM instrutores WHERE nome ILIKE ?";
            PreparedStatement instrucao = con.getCon().prepareStatement(sql);
            instrucao.setString(1, "%" + parteNome + "%");
            ResultSet rs = instrucao.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                Instrutor i1 = new Instrutor(nome, email, senha);

                listaInstrutors.add(i1);
            }
            con.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o Instrutor: " + e.getMessage());
        }

        return listaInstrutors;
    }

    public static ArrayList<Instrutor> retornarListaCompleta() {
        ArrayList<Instrutor> listaInstrutors = new ArrayList<Instrutor>();

        try {
            con.conectar();
            String sql = "SELECT * FROM instrutores";
            PreparedStatement instrucao = con.getCon().prepareStatement(sql);
            ResultSet rs = instrucao.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                Instrutor i1 = new Instrutor(nome, email, senha);

                listaInstrutors.add(i1);

            }
            con.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o Instrutor: " + e.getMessage());
        }
        return listaInstrutors;
    }
}