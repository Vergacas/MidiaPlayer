package br.ufrn.imd.modelo;

/**
 * Esta é a classe modelo UsuarioVIP que herda de Usuario. 
 * 
 *
 * Comtem um atributo (vip do tipo boolean)
 * @author jeanv
 * @version 1.0
 *
 */
public class UsuarioVIP extends Usuario{
	
	private boolean vip;
	
	/**
	 * Método isVip que retona vip
	 * @return vip
	 */
	public boolean isVip() {
		return vip;
	}

	/**
	 * Método setVip que recebe um boolean e modifica o vip
	 * 
	 * @param vip
	 */
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
	
	
}
