package vistas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import clases.Cmr;
import clases.Combustible;
import clases.Utilidad;
import clases.Viaje;
import modelos.CmrModelo;
import modelos.CombustibleModelo;
import modelos.ViajeModelo;

public class Vistas {
	
	private static SimpleDateFormat sdf;

	//MENÚ PRINCIPAL CON 3 OPCIONES (INSERTAR (hecho), BORRAR Y ACTUALIZAR)
	public static void menuPrincipal(){
		Scanner scan = new Scanner (System.in);
		
		final int INSERTAR = 1;
		final int BORRAR = 2;
		final int ACTUALIZAR = 3;
		final int BUSCAR = 4;
		
		int opcion_menuPrincipal = -1;
		
		ViajeModelo viajeModelo = new ViajeModelo();
		CmrModelo cmrModelo = new CmrModelo();
		CombustibleModelo combustibleModelo = new CombustibleModelo();
		
	//MENÚ PRINCIPAL (INSERTAR-BORRAR-ACTUALIZAR
		do {
			
			System.out.println(INSERTAR + "- INSERTAR");
			System.out.println(BORRAR + "- BORRAR");
			System.out.println(ACTUALIZAR + "- ACTUALIZAR");
			System.out.println(BUSCAR + "- BUSCAR");
			
			opcion_menuPrincipal = scan.nextInt();
			Utilidad.refrescarConsola();
			
			
			switch (opcion_menuPrincipal){
			
			case INSERTAR:
				Cmr cmr = crearCmr();
				Combustible combustible = crearCombustible();
				Viaje viaje = crearViaje();
				getIDsParaViaje(viaje, cmr, combustible);
				cmrModelo.insertar(cmr);
				combustibleModelo.insertar(combustible);
				viajeModelo.insertar(crearViaje());
				
				break;
				
			case BORRAR:
				
				ViajeModelo.listarViajes(ViajeModelo.getViajes());
				deleteViaje(pedirID());
				
				
				break;
				
			case ACTUALIZAR:
				break;
				
			case BUSCAR:
				VistaBuscar.menuBuscar();
				break;
				
			default:
				System.err.println("No se reconoce la opción.");
			}
			
			
		} while (opcion_menuPrincipal != 0);
			
		
	//MENÚ BORRAR Y ¿ATUALIZAR? (MOSTRAR Y PEDIR ID DEL VIAJE)
	
		
		
	}
	
	//EN CONTRUCCIÓN   -----> AHORA SE USA UNA PLANTILLA PREDETERMINADA
	//OBJETIVO -------------> COGER DATOS DE LA INTERFAZ Y DAR VALORES A LAS VARIABLES   ///////////////////////
	public static Viaje crearViaje (){
		sdf = new SimpleDateFormat();
		Viaje viaje = new Viaje();
				
//PRUEBAAAAAAAAAAAAAAA -------> ESTOS VALORES HAY QUE COGERLOS DESDE LA INTERFAZ
		String fecha_str = "1111-05-08"; 
		
		viaje.setFecha        (parseDate (fecha_str));
		viaje.setCarga        ("G");
		viaje.setDescarga     ("Z");
		viaje.setKilometraje  (1012121);
		
		return viaje;
		
	}
	
	//CREA UN OBJETO DE TIPO CMR Y LO DEVUELVE [DAR LOS VALORES A LAS VARIABLES POR LA INTERFAZ]
	public static Cmr crearCmr (){
		Cmr cmr = new Cmr();
		//PRUEBAAAAAAAAAAAAAAA -------> ESTOS VALORES HAY QUE COGERLOS DESDE LA INTERFAZ
		cmr.setNumCmr       (99999);
		cmr.setPeso         (98525);
		
		return cmr;
	}
	
	//CREA UN OBJETO DE TIPO COMBUSTIBLE Y LO DEVUELVE [DAR LOS VALORES A LAS VARIABLES POR LA INTERFAZ]
	public static Combustible crearCombustible (){
		Combustible combustible = new Combustible();
		//PRUEBAAAAAAAAAAAAAAA -------> ESTOS VALORES HAY QUE COGERLOS DESDE LA INTERFAZ
		combustible.setlConsumidos  (500);
		combustible.setKmRecorridos (100000);
		combustible.setlRepostados  (600);
		combustible.setConsumo      (30);
		
		return combustible;
	}
	                                                                                   /////////////////////////
	//SI SE LE PASA UN STRING CON FORMATO YYYY-MM-DD DEVUELVE UNA FECHA SQL
	public static java.sql.Date parseDate (String fecha){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate = null;
		java.util.Date utilDate;
		try {
		utilDate = sdf.parse(fecha);
		sqlDate = new java.sql.Date (utilDate.getTime());
		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al parsear Fecha");
		}
		return sqlDate;
	}
	
	//SE LE PASA UN VIAJE, CMR Y COMBUSTIBLE Y AÑADE LOS IDs DE CMR Y COMBUSTIBLE A VIAJES
	public static void getIDsParaViaje(Viaje viaje, Cmr cmr, Combustible combustible){	
		viaje.setIdCmr(CmrModelo.getId());
		viaje.setIdCombustible(CombustibleModelo.getId());
		
	}

	//PIDE UN NÚMERO ENTERO Y LO DEVUELVE
	public static int pedirID(){
		Scanner scan = new Scanner (System.in);
		System.out.println("Selecciona --> ");
		return scan.nextInt();
	}
	
	//DADO UN ID ELIMINA LOS REGISTROS DE LAS TABLAS CMR, COMBUSTIBLE Y VIAJES [un viaje entero]
	public static void deleteViaje(int id){
	ViajeModelo.delete (id);
	CmrModelo.delete (id);
	CombustibleModelo.delete(id);
	System.out.println("VIAJE ELIMINADO CON ÉXITO");
	}
	}



































