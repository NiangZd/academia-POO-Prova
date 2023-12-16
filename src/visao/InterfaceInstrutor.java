package visao;

import aplicacao.Instrutor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import persistencia.InstrutorDAO;
import java.io.IOException;

public class InterfaceInstrutor {

    @FXML
    private Button btnAcesso;

    @FXML
    private Button btnCadastrarTreino;

    @FXML
    private Button btnDeslogar;

    @FXML
    private Label labelNome;

    @FXML
    void acessoDeAlunos(ActionEvent event) {
            Stage stage = (Stage) btnAcesso.getScene().getWindow();

            try {
                // Carrega o arquivo FXML da nova janela
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AcessoDeAlunos.fxml"));
                Parent root = loader.load();

                // Cria uma nova cena
                Scene scene = new Scene(root);

                // Define a cena na janela atual
                stage.setScene(scene);

                // Exibe a nova janela
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @FXML
    void cadastroDeFicha(ActionEvent event) {

    }

    @FXML
    void deslogarConta(ActionEvent event) {
        Stage stage = (Stage) btnAcesso.getScene().getWindow();

            try {
                // Carrega o arquivo FXML da nova janela
                FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
                Parent root = loader.load();

                // Cria uma nova cena
                Scene scene = new Scene(root);

                // Define a cena na janela atual
                stage.setScene(scene);

                // Exibe a nova janela
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
