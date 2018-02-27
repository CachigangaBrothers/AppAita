package modelos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Conector;
import clases.Viaje;

public class ViajeModelo extends Conector{

	

	//INSERTAR REGISTRO EN VIAJES
	public static void insertar (Viaje viaje){
		PreparedStatement pst;
		try {		
			
			pst = conexion.prepareStatement("INSERT INTO viajes(carga, descarga, kilometraje, id_combustible, id_cmr, fecha) VALUES (?,?,?,?,?,?)");
			pst.setString(1, viaje.getCarga());
			pst.setString(2, viaje.getDescarga());
			pst.setInt   (3, viaje.getKilometraje());
			pst.setInt   (4, CombustibleModelo.getId());
			pst.setInt   (5, CmrModelo.getId());
			pst.setDate  (6, viaje.getFecha());
			
			pst.execute();
			System.out.println("VIAJE INSERTADO CON ÉXITO");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//LISTAR TODOS LOS VIAJES DE LA BASE DE DATOS SIN NINGÚN FILTRO
	public static void listarViajes(ArrayList<Viaje> viajes){
		
		for (int i = 0; i < viajes.size(); i++){
			Viaje viaje = viajes.get(i);
			System.out.println(viaje.getIdViaje() + "- " + viaje.getCarga() + "  -  " + viaje.getDescarga() + " \t [ " + viaje.getFecha() + " ]");
		}
			System.out.println("SE HAN MOSTRADO TODOS LOS VIAJES.");
			
		}

	
	
	public static ArrayList<Viaje> getViajes(){
		ArrayList<Viaje> lista = new ArrayList<Viaje>();
		try {
			PreparedStatement pst = conexion.prepareStatement("select * from viajes");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()){
				Viaje viaje = new Viaje();
				viaje.setIdViaje(rs.getInt(1));
				viaje.setCarga(rs.getString(2));
				viaje.setDescarga(rs.getString(3));
				viaje.setKilometraje(rs.getInt(4));
				viaje.setIdCombustible(rs.getInt(5));
				viaje.setIdCmr(rs.getInt(6));
				viaje.setFecha(rs.getDate(7));

				lista.add(viaje);
			}
			System.out.println("SE HAN MOSTRADO TODOS LOS VIAJES.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en listarViajes()");
		}
		return lista;
	}
	
	
	public static void delete (int id){
		try {
			PreparedStatement pst = conexion.prepareStatement("DELETE FROM viajes WHERE id_viaje = ?");
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("No se ha podido eliminar el registro en 'viajes'");

		}
	
	}
	
	
		
	
	
}


	
