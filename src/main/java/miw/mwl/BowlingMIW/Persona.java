package miw.mwl.BowlingMIW;

public class Persona {

	/**
	 * @uml.property  name="nombre"
	 */
	private String nombre;
	/**
	 * @uml.property  name="apellidos"
	 */
	private String apellidos;
	/**
	 * @uml.property  name="dNI"
	 */
	private String DNI;
	
	public Persona(String nombre,String apellidos, String DNI){
	
		assert nombre!= null && apellidos!=null & DNI!= null;
		assert !nombre.equals("") & !apellidos.equals("") & !DNI.equals("");
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = DNI;
	}

	/**
	 * @return
	 * @uml.property  name="nombre"
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return
	 * @uml.property  name="apellidos"
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @return
	 * @uml.property  name="dNI"
	 */
	public String getDNI() {
		return DNI;
	}
	
}
