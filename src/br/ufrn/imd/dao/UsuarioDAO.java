package br.ufrn.imd.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
	 * @throws FileNotFoundException 
	 * 
	 */
	public UsuarioDAO() throws FileNotFoundException {
		usuarios = new ArrayList<Usuario>();
		recuperUsuarios();
		System.out.println(usuarios.size());
	}
	
	public static UsuarioDAO getIstance() throws FileNotFoundException {
		if(bdUsuario == null) {
			bdUsuario = new UsuarioDAO();
		}
		return bdUsuario;
	}
	
	/**
	 * Método addUsuario que recebe um Usuario e adiciona a lista de Usuarios
	 * @param u
	 * @throws IOException 
	 */
	public void addUsuario(Usuario u) throws IOException {
		id++;
		u.setId(id);
		usuarios.add(u);
		guardarUsuarios();
	}
	
	/**
	 * Método removerUsuario que recebe um Usuario e o remove da lista de Usuarios
	 * @param u
	 */
	public void removerUsuario(Usuario u) {
		usuarios.remove(u);
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
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
	
	public boolean testeSegurança(Usuario u){
		boolean test = false;
		for(Usuario use : usuarios) {
			if(u.getNome().equals(use.getNome())) {
				if(u.getSenha().equals(use.getSenha())) {
					test = true;
					break;
				}
			}
		}
		
		return test;
	}
	
	
	public void guardarUsuarios() throws IOException {
		String caminho = "salvos/usuarios.txt";
		
		FileWriter escritor = new FileWriter(caminho);
		String output = "";
		for(Usuario u : usuarios) {
			output += String.valueOf(u.getId()) + "\n" +
					u.getNome() + "\n" + u.getEmail() + "\n"
					+ u.getSenha() + "\n" + 
					formato.format(u.getDataNasc());
			
		}
		
		escritor.write(output);
		escritor.close();
	}
	
	public void recuperUsuarios() throws FileNotFoundException {
		File file = new File("salvos/usuarios.txt");
		
		Scanner scan = new Scanner(file);
		
		Usuario u = new Usuario();
		
		int cont = 0;
		
		while(scan.hasNextLine()) {
			if(cont == 0) {
				scan.nextLine();
				//u.setId(Integer.valueOf());
			}else if (cont == 1) {
				u.setNome(scan.nextLine());
				
			} else if (cont == 2) {
				u.setEmail(scan.nextLine());
			} else if (cont == 3) {
				u.setSenha(scan.nextLine());
			} else {
				scan.nextLine();
				cont = 0;
				u.setId(usuarios.size());
				usuarios.add(u);
				u = new Usuario();
			}
			cont++;
		}
		scan.close();
	}
}
