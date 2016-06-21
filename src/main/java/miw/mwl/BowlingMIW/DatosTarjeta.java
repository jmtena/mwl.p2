package miw.mwl.BowlingMIW;

import java.util.Date;

public class DatosTarjeta {

	/**
	 * @uml.property  name="numero"
	 */
	private String numero;
	/**
	 * @uml.property  name="fecha_exp"
	 */
	private Date fecha_exp;
	/**
	 * @uml.property  name="cVC"
	 */
	private String CVC;
	
	public DatosTarjeta(String numero, Date fecha_exp, String CVC){
		this.numero = numero;
		this.fecha_exp = fecha_exp;
		this.CVC = CVC;
	}

	/**
	 * @return
	 * @uml.property  name="numero"
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @return
	 * @uml.property  name="fecha_exp"
	 */
	public Date getFecha_exp() {
		return fecha_exp;
	}

	/**
	 * @return
	 * @uml.property  name="cVC"
	 */
	public String getCVC() {
		return CVC;
	}
	
	public boolean igual(DatosTarjeta datos){
		boolean igual_numero = numero.equals(datos.getNumero());
		boolean igual_fecha_exp = (fecha_exp.compareTo(datos.getFecha_exp())==0);
		boolean igual_CVC = CVC.equals(datos.getCVC());
		
		return igual_numero && igual_fecha_exp && igual_CVC;
	}
	
}
