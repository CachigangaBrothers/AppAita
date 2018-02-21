import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	public static void listarViajes(){
		try {
			PreparedStatement pst = conexion.prepareStatement("select * from viajes");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()){
				System.out.println(rs.getInt(1) + "- " + rs.getString(2) + " - " + rs.getString(2) + " \t" +"[ " + rs.getDate(7) + " ]");
				
			}
			System.out.println("SE HAN MOSTRADO TODOS LOS VIAJES.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error en listarViajes()");
		}
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


	
