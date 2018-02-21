import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Vistas {

	
	private static SimpleDateFormat sdf;

	
	//MEN� PRINCIPAL CON 3 OPCIONES (INSERTAR (hecho), BORRAR Y ACTUALIZAR)
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
		
	//MEN� PRINCIPAL (INSERTAR-BORRAR-ACTUALIZAR
		do {
			
			System.out.println(INSERTAR + "- INSERTAR");
			System.out.println(BORRAR + "- BORRAR");
			System.out.println(ACTUALIZAR + "- ACTUALIZAR");
			
			opcion_menuPrincipal = scan.nextInt();
			
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
				ViajeModelo.listarViajes();
				deleteViaje(pedirID());
				
				
				break;
				
			case ACTUALIZAR:
				break;
				
			case BUSCAR:
				break;
				
			default:
				System.err.println("No se reconoce la opci�n.");
			}
			
			
		} while (opcion_menuPrincipal != 0);
			
		
	//MEN� BORRAR Y �ATUALIZAR? (MOSTRAR Y PEDIR ID DEL VIAJE)
	
		
		
	}
	//EN CONTRUCCI�N   -----> AHORA SE USA UNA PLANTILLA PREDETERMINADA
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
	
	public static Cmr crearCmr (){
		Cmr cmr = new Cmr();
		//PRUEBAAAAAAAAAAAAAAA -------> ESTOS VALORES HAY QUE COGERLOS DESDE LA INTERFAZ
		cmr.setNumCmr       (99999);
		cmr.setPeso         (98525);
		
		return cmr;
	}
	
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
	
	public static void getIDsParaViaje(Viaje viaje, Cmr cmr, Combustible combustible){
		
		viaje.setIdCmr(CmrModelo.getId());
		viaje.setIdCombustible(CombustibleModelo.getId());
		
	}

	public static int pedirID(){
		Scanner scan = new Scanner (System.in);
		System.out.println("Selecciona --> ");
		return scan.nextInt();
	}
	
public static void deleteViaje(int id){
	ViajeModelo.delete (id);
	CmrModelo.delete (id);
	CombustibleModelo.delete(id);
	System.out.println("VIAJE ELIMINADO CON �XITO");
	}
}

































