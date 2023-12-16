package visao;

import aplicacao.Aluno;
import aplicacao.Instrutor;
import aplicacao.UsuarioLogado;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import persistencia.AlunoDAO;
import persistencia.AlunoInstrutorDAO;

import java.io.IOException;
import java.util.*;
import aplicacao.UsuarioLogado;

public class AcessoDeAlunos {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSair;

    @FXML
    private TableView<Aluno> tableView;

    @FXML
    private TextField tfPesquisa;

    private ObservableList<Aluno> observableList = FXCollections.observableArrayList();
    private ArrayList<Aluno> lista;
    private Aluno alunoSelecionado = new Aluno();

    @FXML
    void initialize() {
        criarColunasTabela();
        atualizarTabela();
    }

    @FXML
    void acaoDoBotaoSair(ActionEvent event){
        Stage stage = (Stage) btnSair.getScene().getWindow();

        try {
            // Carrega o arquivo FXML da nova janela
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InterfaceInstrutor.fxml"));
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
    void addAlunoAoInstrutor(ActionEvent event) {
        //Aluno alunoSelecionado = tableView.getSelectionModel().getSelectedItem();
        System.out.println(UsuarioLogado.getId());
        System.out.println(UsuarioLogado.getNome());
        System.out.println(UsuarioLogado.getEmail());
        System.out.println(UsuarioLogado.getSenha());
        //if (alunoSelecionado != null) {
        //}

    }

    void criarColunasTabela() {
        TableColumn<Aluno, String> colunaNome = new TableColumn<>("NOME");
        TableColumn<Aluno, Integer> colunaIdade = new TableColumn<>("IDADE");
        TableColumn<Aluno, String> colunaPeso = new TableColumn<>("PESO");
        TableColumn<Aluno, String> colunaEmail = new TableColumn<>("EMAIL");

        tableView.setColumnResizePolicy(tableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        tableView.getColumns().addAll(colunaNome, colunaIdade, colunaPeso, colunaEmail);

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaIdade.setCellValueFactory(new PropertyValueFactory<>("idade")); 
        colunaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    void atualizarTabela() {
        observableList.clear();
        String termoPesquisa = tfPesquisa.getText();

        if (termoPesquisa.length() == 0) {
            lista = AlunoDAO.retornarListaCompleta();
        } else {
            lista = AlunoDAO.retornarLista(tfPesquisa.getText());
        }

        for (Aluno a : lista) {
            observableList.add(a);
        }

        tableView.getItems().setAll(observableList);
        tableView.getSelectionModel().selectFirst();

    }

    @FXML
    void filtrarRegistros(KeyEvent event) {
        atualizarTabela();
    }

}

