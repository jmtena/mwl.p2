/**
 * 
 */
package miw.mwl.BowlingMIW;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import miw.mwl.BowlingMIWException.WrongNumPlayersException;

/**
 * @author Agustin
 *
 */
public class Partida {
	
	public static double PRECIO_PARTIDA = 8.90;	
	public static double DESCUENTO_GRUPO = 3.00;
	public static int GRUPO_MINIMO = 4;

	public static final int LOWERLIMIT = 1;
	public static final int UPPERLIMIT = 6;
	/**
	 * @uml.property  name="numPlayers"
	 */
	private int numPlayers;
	/**
	 * @uml.property  name="namePlayers"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.lang.String"
	 */
	private ArrayList <String> namePlayers;
	
	/**
	 * Comprueba el rango de valores para crear una partida
	 * @param numplayers número de jugadores de la partida
	 * @return valor booleano que indica si el valor está dentro del rango
	 */
	private boolean isValidNumPlayers (int numPlayers) {
		return (numPlayers > LOWERLIMIT) && (numPlayers <=  UPPERLIMIT); 
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	public Partida(int numPlayers) throws WrongNumPlayersException {
        if (isValidNumPlayers (numPlayers)) {
		    this.numPlayers = numPlayers;
		    this.namePlayers = new ArrayList<String> ();
		} else { 
			throw new WrongNumPlayersException (numPlayers);
		}
	}

	/**
	 * @return
	 * @uml.property  name="numPlayers"
	 */
	public int getNumPlayers () {
		return numPlayers;
	}

	
	private boolean isValidName(String name) {
		return name.trim().equals("");
	}
	
	public void add(String name) throws Exception {
        if (!isValidName(name)){
        	namePlayers.add(name);
        } else  {
        	throw new Exception ("El nombre del jugador no puede estar vacío");
        } 	
	}
	
	public Mensaje cobrar_efectivo(double cantidad_entregada){
		double importe = calcular_importe();
		
		PagoEfectivo pago = new PagoEfectivo(importe);
		return pago.pagar(cantidad_entregada);
	}
	
	public Mensaje cobrar_tarjeta(){
		double importe = calcular_importe();
		Tarjeta tarjeta = solicitarDatosTarjeta();
		
		return cobrar_tarjeta(tarjeta, importe);
	}
	
	public Mensaje cobrar_tarjeta(Tarjeta tarjeta, double importe){
		PagoTarjeta pago = new PagoTarjeta(importe, tarjeta);
		return pago.pagar();
	}
	
	public double calcular_importe(){
		double importe = Partida.PRECIO_PARTIDA * numPlayers;
		
		if (numPlayers >= Partida.GRUPO_MINIMO)
			importe = importe - Partida.DESCUENTO_GRUPO;
		
		return importe;
	}
	
	public Tarjeta solicitarDatosTarjeta(){
		Scanner scanner = new Scanner(System.in);
		
		String nombre;
		String apellidos;
		String DNI;
		
		System.out.println("Introduzca los datos personales:");
		System.out.print("Nombre:");
		nombre = scanner.next();
		System.out.print("Apellidos:");
		apellidos = scanner.next();
		System.out.print("DNI:");
		DNI = scanner.next();
		
		String numero_tarjeta;
		Date fecha_exp = null;
		String CVC;
		
		System.out.println("Introduzca los datos de la tarjeta:");
		System.out.print("Número de tarjeta:");
		numero_tarjeta = scanner.next();
		System.out.print("Fecha de expiración (DD/MM/YYYY):");
		try {
			fecha_exp = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.next());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.print("CVC (reverso de la tarjeta)");
		CVC = scanner.next();
		scanner.close();
		
		Persona titular = new Persona(nombre, apellidos, DNI);
		DatosTarjeta datosTarjeta = new DatosTarjeta(numero_tarjeta, fecha_exp, CVC);
		
		return new Tarjeta(titular, datosTarjeta);
	}
	
	public static void main (String args[]) {
		
		try {
			new Partida (-1);
		} catch (WrongNumPlayersException e) {
			e.printStackTrace();
		}
		
	}
}





