import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViajeModelo extends Conector{

	

	
	public void insertarViaje (Viaje viaje){
		
		try {
			
			
			//INSERTAR REGISTRO EN CMR
			PreparedStatement pst = conexion.prepareStatement("INSERT INTO cmr(num_cmr, peso) VALUES (?, ?)");
			
			pst.setInt   (1, viaje.getNumCmr());
			pst.setFloat (2, viaje.getPeso());
			
			pst.execute  ();
			
			
			//CONSEGUIR ID_CMR
			pst = conexion.prepareStatement("select max(id_cmr)  from cmr;");
			ResultSet rs = pst.executeQuery();
			rs.next();
			viaje.setIdCmr(rs.getInt(1));
			
			
			//INSERTAR REGISTRO EN COMBUSTIBLE
			pst = conexion.prepareStatement("INSERT INTO combustible(l_consumidos, km_recorridos, l_repostados, consumo) VALUES (?, ?, ?, ?)");
			
			pst.setFloat (1, viaje.getlConsumidos());
			pst.setFloat (2, viaje.getKmRecorridos());
			pst.setFloat (3, viaje.getlRepostados());
			pst.setFloat (4, viaje.getConsumo());
			
			pst.execute();
			
			
			//CONSEGUIR ID_COMBUSTIBLE
			pst = conexion.prepareStatement("select max(id_combustible)  from combustible;");
			rs = pst.executeQuery();
			rs.next();
			viaje.setIdCombustible(rs.getInt(1));
			
			
			//INSERTAR REGISTRO EN VIAJES
			pst = conexion.prepareStatement("INSERT INTO viajes(carga, descarga, kilometraje, id_combustible, id_cmr, fecha) VALUES (?,?,?,?,?,?)");
			pst.setString(1, viaje.getCarga());
			pst.setString(2, viaje.getDescarga());
			pst.setInt   (3, viaje.getKilometraje());
			pst.setInt   (4, viaje.getIdCombustible());
			pst.setInt   (5, viaje.getIdCmr());
			pst.setDate  (6, viaje.getFecha());
			
			pst.execute();
			
			System.out.println("VIAJE INSERTADO CON ÉXITO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


	
