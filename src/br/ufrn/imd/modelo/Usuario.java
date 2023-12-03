package br.ufrn.imd.modelo;

import java.util.Date;

/**
 * Esta � a classe modelo para usuarios.
 * 
 * <br>
 * contendo os atributos(id, nome, email, data_nasc).
 * @author jeanv
 * @version 1.01
 *</br>
 * 
 */
public class Usuario {
	
	protected Integer id;
	protected String nome;
	protected String email;
	protected String senha;
	protected Date dataNasc;
	
	/**
	 * M�todo getId que retorno o id do usuario.
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * M�todo setId que recebe um Integer, e modifica o id do usuario.
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * M�todo getNome que retorna o nome do Usuario.
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * M�todo setNome que recebe uma String, e modifica o Nome do Usuario.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * M�todo getEmail que retorna o email do Usuario.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * M�todo setEmail que recebe uma string, e modifica o email do Usuario;
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * M�todo getSenha que retorna a senha do Usuario
	 * @return senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * M�todo setSenha que recebe uma String e modifica a senha do Usuario
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * M�todo getDataNasc que retorna a data_nasc do Usuario.
	 * @return
	 */
	public Date getDataNasc() {
		return dataNasc;
	}
	
	/**
	 * M�todo setDataNasc que recebe um Date, e modifica a data_nasc do Usuario.
	 * @param data_nasc
	 */
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
	
}
