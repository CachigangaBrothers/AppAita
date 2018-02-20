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
	
	
		
	
	
}


	
