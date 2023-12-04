package br.ufrn.imd.dao;

import br.ufrn.imd.modelo.UsuarioVIP;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/***
 * Classe de armazenamento de UsuariosVIP
 * 
 * @author jeanv
 * @version 1.10
 *
 */
public class UsuarioVIPDAO {

	private ArrayList<UsuarioVIP> usuariosVIP;
	private static UsuarioVIPDAO bdUsuarioVIP;
	
	private Integer id = 0;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Método costrutor de UsuarioVIPDAO que inicializa a classe.
	 * 
	 */
	public UsuarioVIPDAO() {
		usuariosVIP = new ArrayList<UsuarioVIP>();
	}
	
	public static UsuarioVIPDAO getIstance() {
		if(bdUsuarioVIP == null) {
			bdUsuarioVIP = new UsuarioVIPDAO();
		}
		
		return bdUsuarioVIP;
	}
	
	/**
	 * Método addUsuario que recebe um Usuario e adiciona a lista de Usuarios
	 * @param u
	 */
	public void addUsuario(UsuarioVIP u) {
		id ++;
		u.setId(id);
		usuariosVIP.add(u);
	}
	
	/**
	 * Método removerUsuario que recebe um Usuario e o remove da lista de Usuarios
	 * @param u
	 */
	public void removerUsuario(UsuarioVIP u) {
		usuariosVIP.remove(u);
	}
	
	/**
	 * Método listarUsuarios que retorna uma string com todos os dados dos usuarios
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
