package br.ufrn.imd.dao;

import br.ufrn.imd.modelo.PlayList;

import java.util.ArrayList;

/***
 * Classe de armazenamento de PlayLists
 * @author jeanv
 * @version 1.0
 */
public class PlayListDAO {

	private ArrayList<PlayList> pls;
	private static PlayListDAO bdPlayList;
	
	
	/***
	 * Método construtor do PlayListDAO, que inicializa a classe.
	 */
	public PlayListDAO() {
		pls = new ArrayList<PlayList>();
	}
	
	public static PlayListDAO getInstance() {
		if(bdPlayList == null) {
			bdPlayList = new PlayListDAO();
		}
		
		return bdPlayList;
	}
	
	public void addPlayList(PlayList pl) {
		pls.add(pl);
	}
}
