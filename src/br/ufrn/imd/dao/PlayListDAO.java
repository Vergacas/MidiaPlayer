package br.ufrn.imd.dao;

import br.ufrn.imd.modelo.PlayList;

import java.util.ArrayList;

/***
 * Classe de armazenamento de PlayLists
 * @author jeanv
 * @version 1.0
 */
public class PlayListDAO {
	/**
	 * Lista que guarda as playList
	 */
	private ArrayList<PlayList> pls;
	
	/**
	 * atributo que guarda o estado do DAO
	 */
	private static PlayListDAO bdPlayList;
	
	
	/***
	 * Método construtor do PlayListDAO, que inicializa a classe.
	 */
	public PlayListDAO() {
		pls = new ArrayList<PlayList>();
	}
	
	/**
	 * Método que retorna o estado do DAO
	 * @return bdPlayList
	 */
	public static PlayListDAO getInstance() {
		if(bdPlayList == null) {
			bdPlayList = new PlayListDAO();
		}
		
		return bdPlayList;
	}
	
	/**
	 * Método addPlayList adiciona uma nova PlayList a lista
	 * @param PlayList
	 */
	public void addPlayList(PlayList pl) {
		pls.add(pl);
	}
	
	/**
	 * Método listarplayLists para Listar as PlayLists
	 * @return String
	 */
	public String listarplayLists() {
		String output = "---------------------------------------";
		for ( PlayList pl : pls) {
			output += "Nome: " + pl.getNome() +  "\tCriador: " + pl.getCriador() + "\n";
			output += "---------------------------------------" + "\n";
		}
		
		return output;
	}
}
