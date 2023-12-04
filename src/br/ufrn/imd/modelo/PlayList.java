package br.ufrn.imd.modelo;

import java.util.ArrayList;

/**
 * Essa é a classe modelo para PlayLists.
 * 
 * 
 * comtem os atributos(nome, criador e uma Lista de idMusica)
 * @version 1.0
 * @author jeanv
 *
 */
public class PlayList {
	/***
	 * Atributo Nome
	 */
	private String nome;
	/***
	 * Atributo criador
	 */
	private String criador;
	/***
	 * Lista de ids das Musicas
	 */
	private ArrayList<Integer> idMusicas;
	 
	/**
	 * Método getNome que retorna o nome da PlayList.
	 * @return  String nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Método setNome que recebe uma String e modifica o nome da PlayList.
	 * @param String nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método getCriador que retorna o criador da PlayList.
	 * @return String criador
	 */
	public String getCriador() {
		return criador;
	}
	
	/**
	 * Método setCriador que recebe uma String e modifica o criador da PlayList.
	 * @param String criador
	 */
	public void setCriador(String criador) {
		this.criador = criador;
	}
	
	/**
	 * Método getIdMusicas que retorna uma lista de id das Musicas da PlayList.
	 * @return ArrayList<Integer> idMusicas
	 */
	public ArrayList<Integer> getIdMusicas() {
		return idMusicas;
	}
	
	/**
	 * Método addMusica que recebe um Integer e adiciona a lista de id das Musicas da PlayList.
	 * @param ArrayList<Integer> idMusica
	 */
	public void addMusica(Integer idMusica) {
		idMusicas.add(idMusica);
	}
	
	/**
	 * Método removerMusica recebe um Integer e remove um idMusica da lista de Musicas da PlayList.
	 * @param idMusica
	 */
	public void removerMusica(Integer idMusica) {
		idMusicas.remove(idMusica);
	}
	 
}
