package br.ufrn.imd.controle;

import java.io.IOException;
import java.util.Date;

import br.ufrn.imd.dao.UsuarioDAO;
import br.ufrn.imd.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Classe de controle de TelaCadastroUsuario
 * @author jeanv
 *
 */
public class TelaCadastroUsuarioController {
	/**
	 * Atributo Stage
	 */
	private Stage usuarioStage;
	
	/**
	 * Atributo boolean 
	 */
	private boolean btnConfirmarClicked = false;
	
	/**
	 * UsuarioDAO 
	 */
	UsuarioDAO bdUsuario;
	
	/**
	 * botao que cancela o Usuario
	 */
    @FXML
    private Button btnCancelar;
    
    /**
     * botao que confirma o Usuario
     */
    @FXML
    private Button btnConfirmar;
    
    /**
     * DatePicker entrada da dataNasc para Usuario
     */
    @FXML
    private DatePicker dtPickerDtNasc;
    
    /**
     * Label lbDataNasc
     */
    @FXML
    private Label lbDataNasc;
    
    /**
     * Label lbEmai
     */
    @FXML
    private Label lbEmail;
    
    /**
     * Label lbNomeUser
     */
    @FXML
    private Label lbNomeUser;
    
    /**
     * Label lbSenha
     */
    @FXML
    private Label lbSenha;
    
    /**
     * Entrada para emal do usuario
     */
    @FXML
    private TextField tfEmail;
    
    /**
     * Entrada para nome do Usuario
     */
    @FXML
    private TextField tfNomeUser;
    
    /**
     * Entrada para senha do Usuario
     */
    @FXML
    private TextField tfSenha;
    
    /**
     * Método para pegar o estado do btnConfirmarClicked;
     * @return btnConfirmarClicked
     */
    public boolean isBtnConfirmarClicked() {
    	return btnConfirmarClicked;
    }
    
    /**
     * Métod para alterar o estado de btnConfirmarClicked
     * @param boolean btnConfirmarClicked
     */
    public void setBtnConfirmarClicked(boolean btnConfirmarClicked){
    	this.btnConfirmarClicked = btnConfirmarClicked;
    }
    
    /**
     * Método para cancelar a criação de um novo Usuario
     * @param event
     */
    @FXML
    void cancelarUsuario(ActionEvent event) {
    	usuarioStage.close();
    }
    
    /**
     * Método que cria novo usuario e adiciona no UsuarioDAO
     * @param event
     * @throws IOException 
     */
    @FXML
    void inserirUsuario(ActionEvent event) throws IOException {
    	this.btnConfirmarClicked = true;
    	
    	if(this.btnConfirmarClicked) {
    		bdUsuario = UsuarioDAO.getIstance();
    		
    		Usuario u = new Usuario();
    		u.setEmail(tfEmail.getText());
    		u.setNome(tfNomeUser.getText());
    		u.setSenha(tfSenha.getText());
    		
    		Date data = new Date(dtPickerDtNasc.getValue().toEpochDay());
    		u.setDataNasc(data);
    		bdUsuario.addUsuario(u);
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

}
