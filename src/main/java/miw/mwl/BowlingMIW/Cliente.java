package miw.mwl.BowlingMIW;

public class Cliente {

	/**
	 * @uml.property  name="persona"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Persona persona;
	/**
	 * @uml.property  name="datosTarjeta"
	 * @uml.associationEnd  
	 */
	private DatosTarjeta datosTarjeta;
	
	public Cliente(Persona persona){
		this.persona = persona;
	}
	
	/**
	 * @return
	 * @uml.property  name="persona"
	 */
	public Persona getPersona(){
		return this.persona;
	}
	
	public void asignarTarjeta(DatosTarjeta datosTarjeta){
		this.datosTarjeta = datosTarjeta;
	}
	
	/**
	 * @return
	 * @uml.property  name="datosTarjeta"
	 */
	public DatosTarjeta getDatosTarjeta(){
		return this.datosTarjeta;
	}
}
