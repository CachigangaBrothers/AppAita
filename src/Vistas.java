import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Vistas {

	
	private static SimpleDateFormat sdf;

	
	//MENÚ PRINCIPAL CON 3 OPCIONES (INSERTAR (hecho), BORRAR Y ACTUALIZAR)
	public static void menuPrincipal(){
		Scanner scan = new Scanner (System.in);
		
		final int INSERTAR = 1;
		final int BORRAR = 2;
		final int ACTUALIZAR = 3;
		
		int opcion_menuPrincipal = -1;
		
		ViajeModelo viajeModelo = new ViajeModelo();
		
	//MENÚ PRINCIPAL (INSERTAR-BORRAR-ACTUALIZAR
		do {
			
			System.out.println(INSERTAR + "- INSERTAR");
			System.out.println(BORRAR + "- BORRAR");
			System.out.println(ACTUALIZAR + "- ACTUALIZAR");
			
			opcion_menuPrincipal = scan.nextInt();
			
			switch (opcion_menuPrincipal){
			
			case INSERTAR:
				
				viajeModelo.insertarViaje(crearViaje());
				break;
				
			case BORRAR:
				break;
				
			case ACTUALIZAR:
				break;
				
			default:
				System.err.println("No se reconoce la opción.");
			}
			
			
		} while (opcion_menuPrincipal != 0);
			
		
	//MENÚ BORRAR Y ¿ATUALIZAR? (MOSTRAR Y PEDIR ID DEL VIAJE)
	
		
		
	}
	//EN CONTRUCCIÓN   -----> AHORA SE USA UNA PLANTILLA PREDETERMINADA
	//OBJETIVO -------------> COGER DATOS DE LA INTERFAZ Y DAR VALORES A LAS VARIABLES
	public static Viaje crearViaje (){
		sdf = new SimpleDateFormat();
		Viaje viaje = new Viaje();
		
		
//PRUEBAAAAAAAAAAAAAAA -------> ESTOS VALORES HAY QUE COGERLOS DESDE LA INTERFAZ
		String fecha_str = "1111-05-08"; 
		
		viaje.setFecha        (parseDate (fecha_str));
		viaje.setCarga        ("G");
		viaje.setDescarga     ("Z");
		viaje.setKilometraje  (1012121);
		viaje.setlConsumidos  (500);
		viaje.setKmRecorridos (100000);
		viaje.setlRepostados  (600);
		viaje.setConsumo      (30);
		viaje.setNumCmr       (99999);
		viaje.setPeso         (98525);
		
		viaje.setlConsumidos  (100);
		viaje.setKmRecorridos (1000);
		viaje.setlRepostados  (80);
		viaje.setConsumo      (26.5f);
		
		viaje.setNumCmr       (20000);
		viaje.setPeso         (50000);
//////////////				
		return viaje;
		
	}
	
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

}

































