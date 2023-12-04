package br.ufrn.imd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


/**
 * Classe main que inicialia o programa e chama a TelaLogin
 * @author jeanv
 *
 */
public class Main extends Application {
	@Override
	/**
	 * classe Main
	 */
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("visao/TelaLogin.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Tela Loging");
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
