import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CmrModelo extends Conector{

	
	
	//INSERTAR REGISTRO EN CMR
	public static void insertar(Cmr cmr){
		PreparedStatement pst;
		try {
			pst = conexion.prepareStatement("INSERT INTO cmr(num_cmr, peso) VALUES (?, ?)");
		
		
		pst.setInt   (1, cmr.getNumCmr());
		pst.setFloat (2, cmr.getPeso());
		
		pst.execute  ();
		System.out.println("CMR INSERTADO CON ÉXITO");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//CONSEGUIR ÜLTIMO ID_CMR
	public static int getId(){
		PreparedStatement pst;
		ResultSet rs;
		try {
			pst = conexion.prepareStatement("select max(id_cmr)  from cmr;");
		rs = pst.executeQuery();
		rs.next();
		
		return rs.getInt(1);
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	
	public static void delete (int id){
		try {
			PreparedStatement pst = conexion.prepareStatement("DELETE FROM cmr WHERE id_cmr = ?");
			pst.setInt(1, id);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("No se ha podido eliminar el registro en 'cmr'");

		}
	
	}
}
