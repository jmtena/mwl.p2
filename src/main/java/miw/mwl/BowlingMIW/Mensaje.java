package miw.mwl.BowlingMIW;

public class Mensaje {

	public static int CODIGO_ERROR = -1;
	public static int CODIGO_OK = 0;
	
	/**
	 * @uml.property  name="texto"
	 */
	protected String texto;
	/**
	 * @uml.property  name="codigo"
	 */
	protected int codigo;
	
	public Mensaje(String texto, int codigo){
		this.texto = texto;
		this.codigo = codigo;
	}

	/**
	 * @return
	 * @uml.property  name="texto"
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @return
	 * @uml.property  name="codigo"
	 */
	public int getCodigo() {
		return codigo;
	}
	
}
