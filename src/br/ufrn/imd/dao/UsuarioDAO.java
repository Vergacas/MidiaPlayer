package br.ufrn.imd.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.ufrn.imd.modelo.Usuario;

/**
 * Essa é a classe de armazenamento de Usuario.
 * 
 * @author jeanv
 * @version 1.10
 */
public class UsuarioDAO {
	private ArrayList<Usuario> usuarios;
	private static UsuarioDAO bdUsuario;
	
	private Integer id = 0;
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Método costrutor de UsuarioDAO que inicializa a classe.
	 * 
	 */
	public UsuarioDAO() {
		usuarios = new ArrayList<Usuario>();
	}
	
	public static UsuarioDAO getIstance() {
		if(bdUsuario == null) {
			bdUsuario = new UsuarioDAO();
		}
		
		return bdUsuario;
	}
	
	/**
	 * Método addUsuario que recebe um Usuario e adiciona a lista de Usuarios
	 * @param u
	 */
	public void addUsuario(Usuario u) {
		id++;
		u.setId(id);
		usuarios.add(u);
	}
	
	/**
	 * Método removerUsuario que recebe um Usuario e o remove da lista de Usuarios
	 * @param u
	 */
	public void removerUsuario(Usuario u) {
		usuarios.remove(u);
	}
	
	/**
	 * Método listarUsuarios que retorna uma string com todos os dados dos usuarios
	 * @return output
	 */
	public String listarUsuarios() {
		String output = "------------------------------------------ " + "\n" ;
		for(Usuario u : usuarios) {
			output += "Nome...: " + u.getNome() + "\tdata nascimento: " + formato.format(u.getDataNasc())
					+ "\nId: " + u.getId() + "\tEmail: " + u.getEmail() + "\n";
			output = "------------------------------------------" + "\n" ;
		}
		
		return output;
	}
}
