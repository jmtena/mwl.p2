package miw.mwl.BowlingMIW;

public class PagoTarjeta extends Pago{

	/**
	 * @uml.property  name="tarjeta"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Tarjeta tarjeta;
	
	public PagoTarjeta(double importe, Tarjeta tarjeta) {
		super(importe);
		this.tarjeta = tarjeta;
	}
	
	public Mensaje pagar(){
		return tarjeta.pagar(importe);
	}

}
