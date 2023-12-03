package br.ufrn.imd.dao;

import br.ufrn.imd.modelo.UsuarioVIP;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/***
 * Classe de armazenamento de UsuariosVIP
 * 
 * @author jeanv
 *
 */
public class UsuarioVIPDAO {

	private ArrayList<UsuarioVIP> usuariosVIP;
	private static UsuarioDAO bdUsuarioVIP;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * M�todo costrutor de UsuarioVIPDAO que inicializa a classe.
	 * 
	 */
	public UsuarioVIPDAO() {
		usuariosVIP = new ArrayList<UsuarioVIP>();
	}
	
	public static UsuarioDAO getIstance() {
		if(bdUsuarioVIP == null) {
			bdUsuarioVIP = new UsuarioDAO();
		}
		
		return bdUsuarioVIP;
	}
	
	/**
	 * M�todo addUsuario que recebe um Usuario e adiciona a lista de Usuarios
	 * @param u
	 */
	public void addUsuario(UsuarioVIP u) {
		Integer id = usuariosVIP.size();
		u.setId(id);
		usuariosVIP.add(u);
	}
	
	/**
	 * M�todo removerUsuario que recebe um Usuario e o remove da lista de Usuarios
	 * @param u
	 */
	public void removerUsuario(UsuarioVIP u) {
		usuariosVIP.remove(u);
	}
	
	/**
	 * M�todo listarUsuarios que retorna uma string com todos os dados dos usuarios
	 * @return output
	 */
	public String listarUsuarios() {
		String output = "------------------Usuarios VIPs------------------------ " + "\n" ;
		for(UsuarioVIP u : usuariosVIP) {
			output += "Nome...: " + u.getNome() + "\tdata nascimento: " + formato.format(u.getDataNasc())
					+ "\nId: " + u.getId() + "\tEmail: " + u.getEmail() + "\n";
			output = "------------------------------------------" + "\n" ;
		}
		
		return output;
	}
}
