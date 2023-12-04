package br.ufrn.imd.modelo;


/**
 * Esta � a classe modelo para Musica.
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
	 * M�todo getId que retorna o id da Musica.
	 * @return Integer id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * M�todo setId que recebe um Integer e modifica o id da Musica.
	 * @param Integer id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * M�todo getNome que retona o nome da Musica.
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * M�todo setNome que recebe uma String e modifica o nome da Musica.
	 * @param String nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * M�todo getAutor que retorna o autor da Musica.
	 * @return String autor
	 */
	public String getAutor() {
		return autor;
	}
	
	/**
	 * M�todo setAutor que recebe uma String e modifica o autor da Musica.
	 * @param String autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
