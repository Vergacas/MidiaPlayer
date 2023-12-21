package br.ufrn.imd.controle;

import java.io.IOException;

import br.ufrn.imd.dao.UsuarioDAO;
import br.ufrn.imd.modelo.Usuario;
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
 * @version 1.2
 */
public class TelaLoginController {

	private boolean btnConfirmarClicked = false;
	
	UsuarioDAO bdUsuario;
	
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

    public boolean isBtnConfirmarClicked() {
    	return btnConfirmarClicked;
    }
    
    public void setBtnConfirmarClicked(boolean btnConfirmarClicked){
    	this.btnConfirmarClicked = btnConfirmarClicked;
    }
    
    /***
     * Método abriTelaUsuario
     * @param event
     * @throws IOException
     */
    @FXML
    void abrirTelaUsuario(ActionEvent event) throws IOException{
    	
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaCadastroUsuarioController.class.getResource("/br/ufrn/imd/visao/TelaCadastroUsuario.fxml"));
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
    void logar(ActionEvent event) throws IOException {
    	this.btnConfirmarClicked = true;
    	
    	if(this.btnConfirmarClicked) {

        	bdUsuario = UsuarioDAO.getIstance();
        	Usuario user = new Usuario();
        	user.setNome(tfNomeU.getText());
        	user.setSenha(tfSenhaU.getText());
        	
        	user = bdUsuario.testeSegurança(user);
        	
        	if(user != null) {
        		int id = user.getId();
        		
        		FXMLLoader loader = new FXMLLoader();
    	    	loader.setLocation(TelaMidiaPlayController.class.getResource("/br/ufrn/imd/visao/TelaMidiaPlay.fxml"));
    	    	AnchorPane page = (AnchorPane) loader.load();
    	    	
    	    	Stage mpStage = new Stage();
    	    	mpStage.setTitle("Midia Player");
    	    	mpStage.setResizable(false);
    	    	Scene scene = new Scene(page);
    	    	mpStage.setScene(scene);
    	    	
    	    	TelaMidiaPlayController controller = loader.getController();
    	    	
    	    	
    	    	controller.setMidaStage(mpStage);
    	    	controller.setIdUser(id);
    	    	mpStage.show();
    	    	
        	}else {
        		System.out.println("Usuario ou senha incorretos");
        	}    
        	tfNomeU.setText(null);
        	tfSenhaU.setText(null);
    	}
    }

}
