package vistas;

import java.util.Scanner;

import clases.Utilidad;
import modelos.BusquedaModelo;

public class VistaBuscar {
	
	final static int CONSUMO = 1;
	final static int LUGAR = 2;
	
	static Scanner scan = new Scanner(System.in);
	static int seleccion = -1;
	
	static String tipo;
	String consumo;
	static String colOrden;
	static String orden;
	
	public static void menuBuscar(){
		int seleccionBuscar = -1;
	do {
		System.out.println(CONSUMO + "- Por Consumo");
		System.out.println(LUGAR + "- Por Lugar");
		
		seleccionBuscar = scan.nextInt();
		
		switch(seleccionBuscar){
		
		case CONSUMO:
			 tipo = seleccionarTipoBusqueda();
			System.out.println("");
			
			float consumo = preguntarFloat();
			System.out.println("");

			 colOrden = seleccionarOrdenBusqueda();
			System.out.println("");

			 orden = seleccionarOrden();
			System.out.println("");

			Utilidad.refrescarConsola();
			BusquedaModelo.busquedaConsumo(tipo, consumo, colOrden, orden); //orden = ASC o DESC // colOrden = ordenar por FECHA...
			seleccionBuscar = 0;
			
			break;
			
		case LUGAR:
			String lugar = seleccionarLugar(); // CARGA / DESCARGA
			String nombre = seleccionarNombre(); //NOMBRE DEL LUGAR DE CARGA/DESCARGA
			 orden = seleccionarOrden(); //ORDENAR POR NOMBRE DE LUGAR DE CARGA, DESCARGA, FECHA...
			 colOrden = seleccionarOrdenBusqueda(); // ORDENAR DE MODO ASCENDENTE O DESCENDENTE
			
			BusquedaModelo.busquedaLugar(lugar, nombre, orden, colOrden);
			
			break;
		
		}
		
		
	}while(seleccionBuscar != 0);
	
	}

	private static String seleccionarNombre() {
		Scanner scan = new Scanner (System.in);
		System.out.println("Inserta el nombre que quieres buscar --> ");
			
		return scan.nextLine();
	}

	private static String seleccionarLugar() {
		Scanner scan = new Scanner(System.in);
		final int CARGA = 1;
		final int DESCARGA = 2;
		
		int seleccionLugar = -1;
		
		System.out.println("----- SELECCIONA LUGAR DE... -----");
		System.out.println(CARGA + "- CARGA");
		System.out.println(DESCARGA + "- DESCARGA");
		
		seleccionLugar = scan.nextInt();
		
		switch(seleccionLugar){
		
		case CARGA:
			return "carga";
		case DESCARGA:
			return "descarga";
		default:
			return "carga";
		
		}
	}

	//ELEGIR ENTRE ASCENDENTE Y DESCENDENTE
	private static String seleccionarOrden() {
		
		Scanner scan = new Scanner (System.in);
		
		final int ASC = 1;
		final int DESC = 2;
		
		int seleccionOrden = -1;
		
		
		do {
			System.out.println("----- SELECCIONA -----");
			System.out.println(ASC + "- Ascendente");
			System.out.println (DESC + "- Descendente");
			
			seleccionOrden = scan.nextInt();
			
				switch (seleccionOrden) {
				
				case 1:
					return "asc";
				case 2:
					return "desc";
				default:
					return "asc";
				}
		}while (seleccionOrden != 0);
		
	}

	// PREGUNTA UN NÚMERO Y LO DEVUELVE
	private static float preguntarFloat() {
		Scanner scan = new Scanner (System.in);
		System.out.println("Inserta un número --> ");
	
		return scan.nextFloat();
	}

	//MUESTRA UN MENÚ Y PERMITE ELEGIR EN EL TIPO DE BÚSQUEDA (<, >, =) Y LO DEVUELVE
	private static String seleccionarTipoBusqueda() {
			Scanner scan = new Scanner(System.in);
			
			final int MENOR = 1;
			final int MAYOR = 2;
			final int IGUAL = 3;

			System.out.println("----- SELECCIONA TIPO DE BÚSQUEDA -----");

			System.out.println(MENOR + "- Menor a");
			System.out.println(MAYOR + "- Mayor a");
			System.out.println(IGUAL + "- Igual a");
			
			int seleccion = scan.nextInt();
			
		switch (seleccion){
		case MENOR:
			return "<";		
		case MAYOR:
			return ">";		
		case IGUAL:
			return "=";
		default:
			return "=";
		}
	}
	
	//MUESTRA UN MENÚ Y PERMITE ELEGIR EL ORDEN (CARGA, DESCARGA, FECHA) Y LO DEVUELVE
		private static String seleccionarOrdenBusqueda() {
				Scanner scan = new Scanner(System.in);
				
				final int CARGA = 1;
				final int DESCARGA = 2;
				final int FECHA = 3;
				final int CONSUMO = 4;

				System.out.println("----- ORDENAR POR "
						+ "-----");

				System.out.println(CARGA + "- Lugar de Carga");
				System.out.println(DESCARGA + "- Lugar de Descarga");
				System.out.println(FECHA + "- Fecha");
				System.out.println(CONSUMO + "- Consumo");
				
				int seleccion = scan.nextInt();
				
			switch (seleccion){
			case CARGA:
				return "carga";		
			case DESCARGA:
				return "descarga";		
			case FECHA:
				return "fecha";
			case CONSUMO:
				return "consumo";
			default:
				return "fecha";
			}
			
		}
}
