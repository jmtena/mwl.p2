/**
 * 
 */
package miw.mwl.BowlingMIW;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import miw.mwl.BowlingMIWException.*;

/**
 * @author Juan Manuel Tena Escobar
 *
 */
public class PartidaTest {
	
	/**
	 * @uml.property  name="partida"
	 * @uml.associationEnd  
	 */
	private Partida partida;
	/**
	 * @uml.property  name="partida2"
	 * @uml.associationEnd  
	 */
	private Partida partida2;
	
	/**
	 * @uml.property  name="juanma"
	 * @uml.associationEnd  
	 */
	private Persona juanma;
	/**
	 * @uml.property  name="datosTarjetaJuanma"
	 * @uml.associationEnd  
	 */
	private DatosTarjeta datosTarjetaJuanma;
	/**
	 * @uml.property  name="tarjetaJuanma"
	 * @uml.associationEnd  
	 */
	private Tarjeta tarjetaJuanma;
	/**
	 * @uml.property  name="cliente_juanma"
	 * @uml.associationEnd  
	 */
	private Cliente cliente_juanma;
	
	/**
	 * @uml.property  name="pepe"
	 * @uml.associationEnd  
	 */
	private Persona pepe;
	/**
	 * @uml.property  name="datosTarjetaPepe"
	 * @uml.associationEnd  
	 */
	private DatosTarjeta datosTarjetaPepe;
	/**
	 * @uml.property  name="tarjetaPepe"
	 * @uml.associationEnd  
	 */
	private Tarjeta tarjetaPepe;
	/**
	 * @uml.property  name="cliente_pepe"
	 * @uml.associationEnd  
	 */
	private Cliente cliente_pepe;
	
	/**
	 * @uml.property  name="banco"
	 * @uml.associationEnd  
	 */
	private Banco banco;

	public PartidaTest() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/*
	 * Criterio de Aceptación 1
	 * Probar que se crea una partida con número de jugadores menor que el límite
	 */
	@Test
	public void testNumPlayers6 () throws Exception {
		Partida game = new Partida(6);
		assertEquals (game.getNumPlayers(), 6);
	}
	
	@Test(expected =WrongNumPlayersException.class)
	public void testNumPlayers0 () throws Exception {
		new Partida(0);
		fail ("El número de jugadores no puede ser 0");
	}	

	@Test(expected =WrongNumPlayersException.class)
	public void testNumPlayers7 () throws Exception {
		new Partida(7);
		fail ("El número de jugadores no puede ser mayyor que el límite");
	}	
	
	/*
	 * Criterio de aceptación 2
	 * Comprobar que no se admiten nombres en blanco 
	 */
	@Test(expected =Exception.class)
	public void testNoNombreVacio () throws Exception {
		Partida game = new Partida(1);
		game.add(""); 
		fail ("El nombre del jugador no puede estar en blanco");
	}	

	@Test(expected =Exception.class)
	public void testNoNombreEnBlanco () throws Exception {
		Partida game = new Partida(1);
		game.add("          "); 
		fail ("El nombre del jugador no puede estar en blanco");
	}
	
	@Before
	public void before() throws WrongNumPlayersException, ParseException {
		partida = new Partida(2);
		partida2 = new Partida(4);
		
		juanma = new Persona("Juanma", "Tena", "123456-B");
		datosTarjetaJuanma = new DatosTarjeta("1234 5678", new SimpleDateFormat("dd/MM/yyyy").parse("20/05/2019"), "976");
		tarjetaJuanma = new Tarjeta(juanma, datosTarjetaJuanma);
		cliente_juanma = new Cliente(juanma);
		cliente_juanma.asignarTarjeta(datosTarjetaJuanma);
		
		pepe = new Persona("Pepe", "Perez", "654321-A");
		datosTarjetaPepe = new DatosTarjeta("4321 8765", new SimpleDateFormat("dd/MM/yyyy").parse("02/11/2017"), "679");
		tarjetaPepe = new Tarjeta(pepe, datosTarjetaPepe);
		cliente_pepe = new Cliente(pepe);
		cliente_pepe.asignarTarjeta(datosTarjetaPepe);
				
		banco = Banco.getInstance();
		banco.anadirCliente(cliente_juanma);
	}
	
	/*
	 * Nota: los anteriores criterios de aceptación 
	 * ya estaban incluidos en este código
	 * Estos son los criterios de aceptación
	 * implementados para la funcionalidad "Cobro de la partida"
	 * 
	*/
	
	/*
	 * Criterio de Aceptación 1
	 * Calcular del importe correctamente
	 * */
	@Test
	public void calcularImporte(){
		assertEquals(partida.calcular_importe(), 17.80, 0.01);
	}
	
	/*
	 * Criterio de Aceptación 2
	 * Aplicar el descuento para grupos superiores o igual a 4 personas
	 * */
	@Test
	public void calcularImporteConDescuento(){
		assertEquals(partida2.calcular_importe(), 32.60, 0.01);
	}
	
	/*
	 * Criterio de Aceptación 3
	 * Devolver un mensaje de OK cuando la cantidad entregada en efectivo
	 * sea suficiente para pagar o un mensaje de error en caso contrario
	 * */
	@Test
    public void testCobrarEfectivo() {
		Mensaje respuesta;
		
		respuesta = partida.cobrar_efectivo(18.00);
		assertEquals(respuesta.getCodigo(), Mensaje.CODIGO_OK);
		
		respuesta = partida.cobrar_efectivo(10.00);
		assertEquals(respuesta.getCodigo(), Mensaje.CODIGO_ERROR);
    }
	
	/*
	 * Criterio de Aceptación 4
	 * Devolver un mensaje de OK cuando los datos de la tarjeta sean
	 * correctos o un mensaje de error en caso contrario
	 * */
	@Test
    public void testCobrarTarjeta() {
		Mensaje respuesta;
		Mensaje respuesta2;
		
		respuesta= partida.cobrar_tarjeta(tarjetaJuanma, partida.calcular_importe());
		respuesta2= partida.cobrar_tarjeta(tarjetaPepe, partida.calcular_importe());
		
		assertEquals(respuesta.getCodigo(), Mensaje.CODIGO_OK);
		assertEquals(respuesta2.getCodigo(), Mensaje.CODIGO_ERROR);
	}

}












