package miw.mwl.BowlingMIW;

import java.util.ArrayList;
import java.util.ListIterator;

public class Banco {

	/**
	 * @uml.property  name="clientes"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="miw.mwl.BowlingMIW.Cliente"
	 */
	private ArrayList<Cliente> clientes;
	
	private static Banco banco;
	
	public static Banco getInstance(){
		if (banco==null)
			banco = new Banco();
		return banco;
	}
	
	private Banco(){
		this.clientes = new ArrayList<Cliente>();
	}
	
	public void anadirCliente(Cliente c){
		clientes.add(c);
	}
	
	public Cliente buscarCliente(String DNI){
		ListIterator<Cliente> it = clientes.listIterator();
		
		Cliente cliente = null;
		while(it.hasNext()){
			Cliente c = it.next();
			if (c.getPersona().getDNI().equalsIgnoreCase(DNI)){
				cliente = c;
				break;
			}	
		}
		
		return cliente;
	}
	
	public Mensaje realizarSolicitudDePagoTarjeta(Persona titular, DatosTarjeta datosTarjeta){
		//Se comprueba que los datos del titular de la tarjeta
		//coincidan con los datos proporcionados
		
		Cliente cliente = buscarCliente(titular.getDNI());
		if (cliente == null)
			return new MensajeError("Los datos de la tarjeta no son correctos");
		
		DatosTarjeta datosTarjetaCliente = cliente.getDatosTarjeta();
		if (datosTarjetaCliente == null)
			return new MensajeError("Los datos de la tarjeta no son correctos");
		
		if (!datosTarjetaCliente.igual(datosTarjeta))
			return new MensajeError("Los datos de la tarjeta no son correctos");
		
		return new MensajeOK();
	}
	
	
}
