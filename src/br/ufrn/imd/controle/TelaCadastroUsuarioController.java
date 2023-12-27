package br.ufrn.imd.controle;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import br.ufrn.imd.dao.UsuarioDAO;
import br.ufrn.imd.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Classe de controle de TelaCadastroUsuario
 * @author jeanv
 *
 */
public class TelaCadastroUsuarioController implements Initializable {
	/**
	 * Atributo Stage
	 */
	private Stage usuarioStage;
	
	/**
	 * UsuarioDAO 
	 */
	UsuarioDAO bdUsuario;
	
	/**
	 * botao que cancela o Usuario
	 */
    @FXML private Button btnCancelar;
    
    /**
     * botao que confirma o Usuario
     */
    @FXML private Button btnConfirmar;
    
    /**
     * DatePicker entrada da dataNasc para Usuario
     */
    @FXML private DatePicker dtPickerDtNasc;
    
    /**
     * Label lbDataNasc
     */
    @FXML private Label lbDataNasc;
    
    /**
     * Label lbEmai
     */
    @FXML private Label lbEmail;
    
    /**
     * Label lbNomeUser
     */
    @FXML private Label lbNomeUser;
    
    /**
     * Label lbSenha
     */
    @FXML private Label lbSenha;
    
    /**
     * Entrada para emal do usuario
     */
    @FXML private TextField tfEmail;
    
    /**
     * Entrada para nome do Usuario
     */
    @FXML private TextField tfNomeUser;
    
    /**
     * Entrada para senha do Usuario
     */
    @FXML private TextField tfSenha;
    
    /**
     * Método para cancelar a criação de um novo Usuario
     * @param event
     */
    @FXML
    void cancelarUsuario() {
    	usuarioStage.close();
    }
    
    /**
     * Método que cria novo usuario e adiciona no UsuarioDAO
     * @param event
     * @throws IOException 
     */
    @FXML
    void inserirUsuario()  {
    	
    	try {
    		bdUsuario = UsuarioDAO.getIstance();
    		
    		Usuario u = new Usuario();
    		u.setEmail(tfEmail.getText());
    		u.setNome(tfNomeUser.getText());
    		u.setSenha(tfSenha.getText());
    		
    		Date data = new Date(dtPickerDtNasc.getValue().toEpochDay());
    		u.setDataNasc(data);
    		bdUsuario.addUsuario(u);
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	usuarioStage.close();
    }
    
    /**
     * Método que altera o estado do Stage 
     * @param usuarioStage
     */
    public void setUsuarioStage(Stage usuarioStage) {
    	this.usuarioStage = usuarioStage;
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		btnCancelar.setOnMouseClicked((MouseEvent e) -> {
			cancelarUsuario(); 
		});
		
		btnCancelar.setOnKeyPressed((KeyEvent e)->{
			cancelarUsuario();
		});
		
		btnConfirmar.setOnMouseClicked((MouseEvent e) -> {
			inserirUsuario();
		});
		
		btnConfirmar.setOnKeyPressed((KeyEvent e)->{
			inserirUsuario();
		});
		
	}

}
