package persistencia;
import aplicacao.Aluno;
import aplicacao.PagamentoMensalidade;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoDAO {

    private static Conexao con;

    public static void setConexao(Conexao conexao) {
        con = conexao;
    }

    public static void inserirAluno(Aluno a1) {
        try {
            con.conectar();

            PreparedStatement instrucao = con.getCon().prepareStatement("INSERT INTO alunos (nome, idade, peso, email, senha) VALUES (?, ?, ?, ?, ?)");
            instrucao.setString(1, a1.getNome());
            instrucao.setInt(2, a1.getIdade());
            instrucao.setFloat(3, a1.getPeso());
            instrucao.setString(4, a1.getEmail());
            instrucao.setString(5, a1.getSenha());

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
            addPagamentoMensalidade(a1.getEmail());
        }
    }

    public static void addPagamentoMensalidade(String email) {
        PagamentoMensalidade pm = null;
        try {
            con.conectar();

            String sql = "SELECT * FROM alunos WHERE email = ?";
            PreparedStatement instrucao = con.getCon().prepareStatement(sql);
            instrucao.setString(1, email);

            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                int id_aluno = rs.getInt("id_aluno");

                pm = new PagamentoMensalidade(id_aluno, "A DEFINIR", 60);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar o Instrutor: " + e.getMessage());
        } finally {
            con.desconectar();
            PagamentoMensalidadeDAO.inserirPagamentoMensalidade(pm);
        }
    }

    public static void alterarAluno(int id, Aluno a1) {
        try {
            con.conectar();
    
            String sql = "UPDATE alunos SET nome = ?, idade = ?, peso = ?, email = ?, senha = ?  WHERE id_aluno = ?";
            PreparedStatement instrucao = con.getCon().prepareStatement(sql);
            
            instrucao.setString(1, a1.getNome());
            instrucao.setInt(2, a1.getIdade());
            instrucao.setFloat(3, a1.getPeso());
            instrucao.setString(4, a1.getEmail());
            instrucao.setString(5, a1.getSenha());
            instrucao.setInt(6, id);
    
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
    
    public static void deletarAlunos(int id) {
        try {
            FichaTreinoDAO.deletarFichaTreinosPA(id);
            con.conectar();
            String sql = "DELETE FROM alunos WHERE id_aluno = ?";
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
    
    public static Aluno buscarAluno(int id) {
        Aluno a1 = null;
        try {
            con.conectar();

            String sql = "SELECT * FROM alunos WHERE id_aluno = ?";
            PreparedStatement instrucao = con.getCon().prepareStatement(sql);
            instrucao.setInt(1, id);

            ResultSet rs = instrucao.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                Float peso = rs.getFloat("peso");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
            
                a1 = new Aluno(nome, idade, peso, email, senha);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar o aluno: " + e.getMessage());
        } finally {
            con.desconectar();
        }
        return a1;
    }

    public static ArrayList<Aluno> retornarLista(String parteNome) {
        ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
    
        try {
            con.conectar();
            String sql = "SELECT * FROM alunos WHERE nome ILIKE ?";
            PreparedStatement instrucao = con.getCon().prepareStatement(sql);
            instrucao.setString(1, "%" + parteNome + "%");
            ResultSet rs = instrucao.executeQuery();
    
            while (rs.next()) {
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                Float peso = rs.getFloat("peso");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
            
                Aluno a1 = new Aluno(nome, idade, peso, email, senha);
    
                listaAlunos.add(a1);
            }
            con.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o aluno: " + e.getMessage());
        }
    
        return listaAlunos;
    }   
    
    public static ArrayList<Aluno> retornarListaCompleta() {
        ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
    
        try {
            con.conectar();
            String sql = "SELECT * FROM alunos";
            PreparedStatement instrucao = con.getCon().prepareStatement(sql);
            ResultSet rs = instrucao.executeQuery();
    
            while (rs.next()) {
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                Float peso = rs.getFloat("peso");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
            
                Aluno a1 = new Aluno(nome, idade, peso, email, senha);
    
                listaAlunos.add(a1);
    
            }
            con.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o aluno: " + e.getMessage());
        }
    
        return listaAlunos;
    }   
}