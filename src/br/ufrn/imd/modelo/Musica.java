package br.ufrn.imd.modelo;


/**
 * Esta � a classe modelo para Musica.
 * 
 * <br>
 * cotem os atributos (nome, autor, url).
 * @author jeanv
 * @version 1.0
 *</br>
 */
public class Musica {
	private Integer id;
	private String nome;
	private String autor;
	private String url;

	/**
	 * M�todo getId que retorna o id da Musica.
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * M�todo setId que recebe um Integer e modifica o id da Musica.
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * M�todo getNome que retona o nome da Musica.
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * M�todo setNome que recebe uma String e modifica o nome da Musica.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * M�todo getAutor que retorna o autor da Musica.
	 * @return autor
	 */
	public String getAutor() {
		return autor;
	}
	
	/**
	 * M�todo setAutor que recebe uma String e modifica o autor da Musica.
	 * @param autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	/**
	 * M�todo getUrl que retorna a url da Musica.
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * M�todo setUrl que recebe uma string e modifica a url da Musica.
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
}
