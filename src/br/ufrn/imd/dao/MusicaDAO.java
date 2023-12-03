package br.ufrn.imd.dao;

import br.ufrn.imd.modelo.Musica;

import java.util.ArrayList;

/***
 * Essa é a classe de armazenamento de Usuario.
 * 
 * @author jeanv
 * @version 1.0
 */
public class MusicaDAO {

	private ArrayList<Musica> musicas;
	private static MusicaDAO bdMusica;
	
	private Integer id = 0;
	
	/***
	 * Método costrutor de MusicaDAO que inicializa a classe.
	 * 
	 */
	public MusicaDAO() {
		musicas = new ArrayList<Musica>();
	}
	
	public static MusicaDAO getIsntace() {
		if(bdMusica == null) {
			bdMusica = new MusicaDAO();
		}
		return bdMusica;
	}
	
	/***
	 * Método addMusica que adiciona uma musica a lista de musicas
	 * @param m
	 */
	public void addMusica(Musica m) {
		this.id ++;
		m.setId(id);
		musicas.add(m);
	}
	
	/***
	 * Método removerMusica que remove uma musica da lista de musicas
	 * @param m
	 */
	public void removerMusica(Musica m) {
		musicas.remove(m);
	}
	
	/***
	 * método para listar as musicas
	 * @return output
	 */
	public String listarMusicas() {
		String output = "-----------------------------------" + "\n";
		for(Musica m : musicas) {
			output += "Nome: " + m.getNome() + "\tAutor: " + m.getAutor() + "\n";
			output += "-----------------------------------" + "\n";
		}
		return output;
	}
}
