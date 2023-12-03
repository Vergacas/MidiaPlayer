package br.ufrn.imd.controle;

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

public class TelaCadastroUsuarioController {
	
	private Stage usuarioStage;
	private boolean btnConfirmarClicked = false;
	
	UsuarioDAO bdUsuario;
	
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

    @FXML
    private DatePicker dtPickerDtNasc;

    @FXML
    private Label lbDataNasc;

    @FXML
    private Label lbEmail;

    @FXML
    private Label lbNomeUser;

    @FXML
    private Label lbSenha;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNomeUser;

    @FXML
    private TextField tfSenha;
    
    public boolean isBtnConfirmarClicked() {
    	return btnConfirmarClicked;
    }
    
    public void setBtnConfirmarClicked(boolean btnConfirmarClicked){
    	this.btnConfirmarClicked = btnConfirmarClicked;
    }
    
    @FXML
    void cancelarUsuario(ActionEvent event) {
    	usuarioStage.close();
    }

    @FXML
    void inserirUsuario(ActionEvent event) {
    	this.btnConfirmarClicked = true;
    	
    	if(this.btnConfirmarClicked) {
    		bdUsuario = UsuarioDAO.getIstance();
    		
    		Usuario u = new Usuario();
    		u.setEmail(tfEmail.getText());
    		u.setNome(tfNomeUser.getText());
    		u.setSenha(tfSenha.getText());
    		
    		Date data = new Date(dtPickerDtNasc.getValue().toEpochDay());
    		u.setDataNasc(data);
    	}
    	usuarioStage.close();
    }
    
    public void setUsuarioStage(Stage usuarioStage) {
    	this.usuarioStage = usuarioStage;
    }

}
