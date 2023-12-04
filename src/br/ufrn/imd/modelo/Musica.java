package br.ufrn.imd.modelo;


/**
 * Esta é a classe modelo para Musica.
 * 
 * 
 * cotem os atributos (nome, autor, url).
 * @author jeanv
 * @version 1.0
 *
 */
public class Musica {
	/***
	 * Atributo Id
	 */
	private Integer id;
	/***
	 * Atributo Nome
	 */
	private String nome;
	/***
	 * Atributo Autor
	 */
	private String autor;
	/***
	 * Método getId que retorna o id da Musica.
	 * @return Integer id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Método setId que recebe um Integer e modifica o id da Musica.
	 * @param Integer id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Método getNome que retona o nome da Musica.
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Método setNome que recebe uma String e modifica o nome da Musica.
	 * @param String nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método getAutor que retorna o autor da Musica.
	 * @return String autor
	 */
	public String getAutor() {
		return autor;
	}
	
	/**
	 * Método setAutor que recebe uma String e modifica o autor da Musica.
	 * @param String autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
