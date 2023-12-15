package visao;

import aplicacao.Aluno;
import aplicacao.Instrutor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import persistencia.AlunoDAO;
import persistencia.InstrutorDAO;

public class LoginController {

    @FXML
    private Button btnLoginAluno;

    @FXML
    private Button btnLoginInstrutor;

    @FXML
    private TextField labelEmail;

    @FXML
    private TextField labelSenha;

    @FXML
    void goToLoginAluno(ActionEvent event) {
        String email = labelEmail.getText();
        String senha = labelSenha.getText();

        Aluno a1 = AlunoDAO.buscarALogin(email);

        if (a1 != null && email.equals(a1.getEmail()) && senha.equals(a1.getSenha())) {
            System.out.println("PARABÉNS, VOCÊ LOGOU!");
        } else {
            System.out.println("LAMENTO, VOCÊ ERROU SENHA OU EMAIL! =()");
        }
    }

    @FXML
    void goToLoginInstrutor(ActionEvent event) {
        String email = labelEmail.getText();
        String senha = labelSenha.getText();

        Instrutor i1 = InstrutorDAO.buscarALogin(email);

        if (i1 != null && email.equals(i1.getEmail()) && senha.equals(i1.getSenha())) {
            System.out.println("PARABÉNS, VOCÊ LOGOU!");
        } else {
            System.out.println("LAMENTO, VOCÊ ERROU SENHA OU EMAIL! =()");
        }
    }

}
