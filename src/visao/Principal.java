package visao;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import aplicacao.*;
import persistencia.*;

public class Principal extends Application{
	public static void main(String[] args) {

		Conexao c1 = new Conexao();
		AlunoDAO.setConexao(c1);
		InstrutorDAO.setConexao(c1);
		FichaTreinoDAO.setConexao(c1);
		AlunoInstrutorDAO.setConexao(c1);
		PagamentoMensalidadeDAO.setCon(c1);

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("ACADEMIA");
		Button botao = new Button("CLIQUE AQUI");
		botao.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Clicou no botão");		
			}
		});

		StackPane root = new StackPane();
		root.getChildren().addAll(botao);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();

	}
}