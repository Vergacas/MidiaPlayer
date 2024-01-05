package br.ufrn.imd.controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrn.imd.MidiaPlayer;
import br.ufrn.imd.dao.UsuarioDAO;
import br.ufrn.imd.midiaPlayer.CadastroUsuario;
import br.ufrn.imd.midiaPlayer.Principal;
import br.ufrn.imd.modelo.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
public class TelaLoginController implements Initializable{

	private boolean btnConfirmarClicked = false;
	
	UsuarioDAO bdUsuario;
	
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

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
    void abrirTelaUsuario() {
    	CadastroUsuario cdtu = new CadastroUsuario();
    	try {
			cdtu.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void cancelar() {
    	System.exit(0); 
    }

    @FXML
    void logar(){
    	try {
        	bdUsuario = UsuarioDAO.getIstance();
        	Usuario user = new Usuario();
        	user.setNome(tfNomeU.getText());
        	user.setSenha(tfSenhaU.getText());
        	
        	user = bdUsuario.testeSegurança(user);
        	
        	if(user != null) {
        		int id = user.getId();
        		Principal p = new Principal();
        		
        		try {
        			p.start(new Stage());
        			MidiaPlayer.getStage().close();
        		}catch(Exception e){
            		e.printStackTrace();
            	}
        		
        	}else {
        		System.out.println("Usuario ou senha incorretos");
        		Alert alert = new Alert(AlertType.ERROR);
        		
        		alert.setTitle("ERRO");
        		alert.setContentText("Usuario ou senha incorretos");
        		alert.show();
        	   
        	tfNomeU.setText(null);
        	tfSenhaU.setText(null);	
	    	}
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		btnCancelar.setOnMouseClicked((MouseEvent e) -> {
			cancelar();
		});
		
		btnCancelar.setOnKeyPressed((KeyEvent e)->{
			cancelar();
		});
		
		btnConfirmar.setOnMouseClicked((MouseEvent e) -> {
			logar();
		});
		
		btnConfirmar.setOnKeyPressed((KeyEvent e)->{
			logar();
		});
		
	}

}
