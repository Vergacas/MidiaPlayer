package br.ufrn.imd.controle;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/***
 * Classe de controle inicial.
 * 
 * 
 * @author jeanv
 * @version 1.0
 */
public class TelaLoginController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnComfimar;

    @FXML
    private CheckBox ckBoxLogado;

    @FXML
    private Label lbSenha;

    @FXML
    private Label lbUsuario;

    @FXML
    private MenuItem mnItemCadastroUsur;

    @FXML
    private TextField tfNomeU;

    @FXML
    private TextField tfSenhaU;

    @FXML
    void abritTelaUsuario(ActionEvent event) throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(null);
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	Stage usuarioStage = new Stage();
    	usuarioStage.setTitle("Cadastro de Usuario");
    	usuarioStage.setResizable(false);
    	Scene scene = new Scene(page);
    	usuarioStage.setScene(scene);
    	
    	TelaCadastroUsuarioController controller = loader.getController();
    	controller.setUsuarioStage(usuarioStage);
    	usuarioStage.showAndWait();
    }

    @FXML
    void cancelar(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void logar(ActionEvent event) {

    }

}
