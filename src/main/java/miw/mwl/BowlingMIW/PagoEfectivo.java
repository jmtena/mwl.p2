package miw.mwl.BowlingMIW;

public class PagoEfectivo extends Pago{
	
	public PagoEfectivo(double importe) {
		super(importe);
	}

	public Mensaje pagar(double cantidad_entregada){
		Mensaje respuesta;
		
		if (cantidad_entregada >= importe)
			respuesta = new MensajeOK();
		else
			respuesta = new MensajeError("Cantidad insuficiente");
		
		return respuesta;
	}
	
}
