package br.ufrn.imd.modelo;

import java.util.ArrayList;

/**
 * Essa � a classe modelo para PlayLists.
 * 
 * <br>
 * comtem os atributos()
 * @version 1.0
 * @author jeanv
 *</br>
 */
public class PlayList {
	
	private String nome;
	private String criador;
	private ArrayList<Integer> idMusicas;
	 
	/**
	 * M�todo getNome que retorna o nome da PlayList.
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * M�todo setNome que recebe uma String e modifica o nome da PlayList.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * M�todo getCriador que retorna o criador da PlayList.
	 * @return criador
	 */
	public String getCriador() {
		return criador;
	}
	
	/**
	 * M�todo setCriador que recebe uma String e modifica o criador da PlayList.
	 * @param criador
	 */
	public void setCriador(String criador) {
		this.criador = criador;
	}
	
	/**
	 * M�todo getIdMusicas que retorna uma lista de id das Musicas da PlayList.
	 * @return idMusicas
	 */
	public ArrayList<Integer> getIdMusicas() {
		return idMusicas;
	}
	
	/**
	 * M�todo addMusica que recebe um Integer e adiciona a lista de id das Musicas da PlayList.
	 * @param idMusica
	 */
	public void addMusica(Integer idMusica) {
		idMusicas.add(idMusica);
	}
	
	/**
	 * M�todo removerMusica recebe um Integer e remove um idMusica da lista de Musicas da PlayList.
	 * @param idMusica
	 */
	public void removerMusica(Integer idMusica) {
		idMusicas.remove(idMusica);
	}
	 
}
