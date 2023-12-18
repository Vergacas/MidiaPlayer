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
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Método costrutor de UsuarioDAO que inicializa a classe.
	 * @throws FileNotFoundException 
	 * 
	 */
	public UsuarioDAO() throws FileNotFoundException  {
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
		
		u.setId(usuarios.size() + 1);
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
	/***
	 * 
	 * Método testeSegurança, recebe um usuario e retorna um usuario que ja é cadastrado na Lista de Usuarios.
	 * Caso o Nome e a Senha do Usuario recebido nao batam com nenhum Usuario ja cadastrado, é tenornado
	 * um valor nulo.
	 * @param Usuario u
	 * @return Usuario use
	 */
	public Usuario testeSegurança(Usuario u){
		System.out.println("1");
		int cont = 0;
		for(Usuario use : usuarios) {
			System.out.println(cont);
			if(u.getNome().equals(use.getNome())) {
				System.out.println("1");
				if(u.getSenha().equals(use.getSenha())) {
					System.out.println("2");
					return use;
				}
			}
			cont++;
		}
		
		return null;
	}
	
	/***
	 * Método guardarUsuarios escreve todos os dados dos usuarios(separados por ';') em um arquivo 'usuarios.txt', que se 
	 * loacliza na pasta salvos, que fica na raiz do projeto.
	 * cada usuario ocupa uma linha
	 * @throws IOException
	 */
	public void guardarUsuarios() throws IOException {
		String caminho = "salvos/usuarios.txt";
		
		FileWriter escritor = new FileWriter(caminho);
		String output = "";
		for(Usuario u : usuarios) {
			output = String.valueOf(u.getId()) + ";" +
					u.getNome() + ";" + u.getEmail() + ";"
					+ u.getSenha() + ";" + 
					formato.format(u.getDataNasc()) + "\n";
			escritor.write(output);
		}
		
		
		escritor.close();
	}
	
	public void recuperUsuarios() throws FileNotFoundException {
		File file = new File("salvos/usuarios.txt");
		
		Scanner scan = new Scanner(file);
		
		
		while(scan.hasNextLine()) {
			Usuario u = new Usuario();
			String[] dadosUser;
			String recuperar = scan.nextLine();
			dadosUser = recuperar.split(";");
			u.setId(Integer.valueOf(dadosUser[0]));
			u.setNome(dadosUser[1]);
			u.setEmail(dadosUser[2]);
			u.setSenha(dadosUser[3]);
			
			Date data = new Date();
			String[] dadosData = dadosUser[4].split("/");
			data.setDate(Integer.valueOf(dadosData[0]));
			data.setMonth(Integer.valueOf(dadosData[1]));
			data.setYear(Integer.valueOf(dadosData[2]));
			
			u.setDataNasc(data);
			
			usuarios.add(u);
		}
		scan.close();
	}
	
	public Usuario getUsuario(Integer idUser) {
		Usuario u = new Usuario();
		for(Usuario use : usuarios) {
			if(use.getId().equals(idUser)) {
				u = use;
			}
		}
		
		return u;
	}
}
