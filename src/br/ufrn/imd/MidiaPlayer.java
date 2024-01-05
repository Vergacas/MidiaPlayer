package br.ufrn.imd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MidiaPlayer extends Application{
	
	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * M�todo para iniciar a tela de login.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/br/ufrn/imd/visao/TelaLogin.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Tela Loging");
		stage.setResizable(false);
		stage.show();
		
		setStage(stage);
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void setStage(Stage stage) {
		MidiaPlayer.stage = stage;
	}

}
