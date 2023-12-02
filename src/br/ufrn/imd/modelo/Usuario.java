package br.ufrn.imd.modelo;

import java.util.Date;

public class Usuario {
	private Integer id;
	private String nome;
	private String email;
	private Date data_nasc;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getData_nasc() {
		return data_nasc;
	}
	
	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}
	
	
	
}
