package miw.mwl.BowlingMIW;

public class Tarjeta {

	/**
	 * @uml.property  name="titular"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Persona titular;
	/**
	 * @uml.property  name="datosTarjeta"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private DatosTarjeta datosTarjeta;
	
	public Tarjeta(Persona titular, DatosTarjeta datosTarjeta){
		this.titular = titular;
		this.datosTarjeta = datosTarjeta;
	}
	
	public Mensaje pagar(double importe){
		//Envío de los datos al banco y recepción de la confirmación
		
		Banco banco = Banco.getInstance();
		Mensaje respuesta  = banco.realizarSolicitudDePagoTarjeta(titular, datosTarjeta);
		
		return respuesta;
	}
	
}
