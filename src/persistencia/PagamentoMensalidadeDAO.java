package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import aplicacao.PagamentoMensalidade;

public class PagamentoMensalidadeDAO {

    private static Conexao con;

    public static void setCon(Conexao con) {
        PagamentoMensalidadeDAO.con = con;
    }
    
    public static void inserirPagamentoMensalidade(PagamentoMensalidade pam) {
        try {
            con.conectar();

            PreparedStatement instrucao = con.getCon().prepareStatement("INSERT INTO pagamentomensalidade (id_aluno, datapagamento, valor) VALUES (?, ?, ?)");
            
            instrucao.setInt(1, pam.getId_aluno());
            instrucao.setString(2, pam.getDatapagamento());
            instrucao.setInt(3, pam.getValor());

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

    /////////////////////////////////////////////////////////////////////////////////////////////////////
                                    // FUNÇÕES JAVAFX LOGIN REGISTRO //
    ////////////////////////////////////////////////////////////////////////////////////////////////////

}