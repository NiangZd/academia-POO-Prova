package visao;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaInicialAluno {

    @FXML
    private Button btnFichaTreino;

    @FXML
    private Button btnInfoPessoais;

    @FXML
    private Button btnInstrutores;

    @FXML
    private Button btnSair;

    @FXML
    private Label labelUser;

    @FXML
    void sairSistema(ActionEvent event) {
        Stage stage = (Stage) btnInstrutores.getScene().getWindow();

        try {
            // Carrega o arquivo FXML da nova janela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("telaInicial.fxml"));
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
    void verifFicha(ActionEvent event) {

    }

    @FXML
    void verifInfoPessoais(ActionEvent event) {

    }

    @FXML
    void verifInstrutores(ActionEvent event) {
        Stage stage = (Stage) btnInstrutores.getScene().getWindow();

        try {
            // Carrega o arquivo FXML da nova janela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AcessoDeInstrutores.fxml"));
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
