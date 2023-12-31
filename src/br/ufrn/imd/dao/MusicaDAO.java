package br.ufrn.imd.dao;

import br.ufrn.imd.modelo.Musica;

import java.util.ArrayList;

/***
 * Essa � a classe de armazenamento de Usuario.
 * 
 * @author jeanv
 * @version 1.0
 */
public class MusicaDAO {

	private ArrayList<Musica> musicas;
	private static MusicaDAO bdMusica;
	
	/***
	 * M�todo costrutor de MusicaDAO que inicializa a classe.
	 * 
	 */
	public MusicaDAO() {
		musicas = new ArrayList<Musica>();
	}
	
	/**
	 * metodo getInstace retorna o DAO, e cria um novo caso esteja vazio
	 * @return
	 */
	public static MusicaDAO getIsntace() {
		if(bdMusica == null) {
			bdMusica = new MusicaDAO();
		}
		return bdMusica;
	}
	
	/***
	 * M�todo addMusica que adiciona uma musica a lista de musicas
	 * @param Musica
	 */
	public void addMusica(Musica m) {
		Integer id = musicas.size();
		m.setId(id);
		musicas.add(m);
	}
	
	/***
	 * M�todo removerMusica que remove uma musica da lista de musicas
	 * @param Musica
	 */
	public void removerMusica(Musica m) {
		musicas.remove(m);
	}
	
	/***
	 * m�todo para listar as musicas
	 * @return String
	 */
	public String listarMusicas() {
		String output = "-----------------------------------" + "\n";
		for(Musica m : musicas) {
			output += "Nome: " + m.getNome() + "\tAutor: " + m.getAutor() + "\n";
			output += "-----------------------------------" + "\n";
		}
		return output;
	}
	
	/**
	 * M�tod getMusica retorna a Lista das Musicas
	 * @return ArrayList<Musica>
	 */
	public ArrayList<Musica> getMusicas() {
		return musicas;
	}
	
}
