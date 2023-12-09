package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AlunoInstrutorDAO {
    private static Conexao con;

    public static void setConexao(Conexao conexao) {
        con = conexao;
    }

    public static void inserirAlunoInstrutor(int id_fichadetreino, int id_aluno, int id_instrutor) {
        try {
            con.conectar();

            PreparedStatement instrucao = con.getCon().prepareStatement("INSERT INTO alunoinstrutor (id_fichadetreino, id_aluno, id_instrutor) VALUES (?, ?, ?)");
            
            instrucao.setInt(1, id_fichadetreino);
            instrucao.setInt(2, id_aluno);
            instrucao.setInt(3, id_instrutor);

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

    public static void alterarAlunoInstrutor(int id_fichadetreino, int id_aluno, int id_instrutor) {
        try {
            con.conectar();
    
            String sql = "UPDATE alunoinstrutor SET id_fichadetreino = ?, id_aluno = ?, id_instrutor = ?  WHERE id_fichadetreino = ?";
            PreparedStatement instrucao = con.getCon().prepareStatement(sql);
            
            instrucao.setInt(1, id_fichadetreino);
            instrucao.setInt(2, id_aluno);
            instrucao.setInt(3, id_instrutor);
            instrucao.setInt(4, id_fichadetreino);
    
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

    public static void deletarAlunoInstrutorPFT(int id) {
        try {
            con.conectar();
            
            String sql = "DELETE FROM alunoinstrutor WHERE id_fichadetreino = ?";
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

}
