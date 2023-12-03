package br.ufrn.imd.modelo;

/**
 * Esta � a classe modelo UsuarioVIP que herda de Usuario. 
 * 
 *<br>
 * Comtem um atributo (vip do tipo boolean)
 * @author jeanv
 * @version 1.0
 *</br>
 */
public class UsuarioVIP extends Usuario{
	
	private boolean vip;
	
	/**
	 * M�todo isVip que retona vip
	 * @return vip
	 */
	public boolean isVip() {
		return vip;
	}

	/**
	 * M�todo setVip que recebe um boolean e modifica o vip
	 * 
	 * @param vip
	 */
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
	
	
}
