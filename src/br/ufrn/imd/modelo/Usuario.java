package br.ufrn.imd.modelo;

import java.util.Date;

public class Usuario {
	
	/**
	 * Esta é a classe modelo para usuarios, contendo os atributos(id, nome, email, data_nasc).
	 * 
	 * <br>
	 * @author jeanv
	 * @version 1.0
	 *</br>
	 * 
	 */
	
	private Integer id;
	private String nome;
	private String email;
	private Date dataNasc;
	
	/**
	 * Método getId que retorno o id do usuario.
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Método setId que recebe um Integer, e modifica o id do usuario.
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Método getNome que retorna o nome do Usuario.
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Método setNome que recebe uma String, e modifica o Nome do Usuario.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método getEmail que retorna o email do Usuario.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Método setEmail que recebe uma string, e modifica o email do Usuario;
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Método getDataNasc que retorna a data_nasc do Usuario.
	 * @return
	 */
	public Date getDataNasc() {
		return dataNasc;
	}
	
	/**
	 * Método setDataNasc que recebe um Date, e modifica a data_nasc do Usuario.
	 * @param data_nasc
	 */
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
	
}
