import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CombustibleModelo extends Conector{

	
	//INSERTAR REGISTRO EN COMBUSTIBLE
	public static void insertar(Combustible combustible){
		PreparedStatement pst;
		try {
			
			pst = conexion.prepareStatement("INSERT INTO combustible(l_consumidos, km_recorridos, l_repostados, consumo) VALUES (?,?,?,?)");
			
			pst.setFloat (1, combustible.getlConsumidos());
			pst.setFloat (2, combustible.getKmRecorridos());
			pst.setFloat (3, combustible.getlRepostados());
			pst.setFloat (4, combustible.getConsumo());
			
			pst.execute();
			System.out.println("COMBUSTIBLE INSERTADO CON ÉXITO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//CONSEGUIR ÜLTIMO ID_COMBUSTIBLE
	public static int getId(){
		PreparedStatement pst;
		ResultSet rs;
		try {
			pst = conexion.prepareStatement("select max(id_combustible)  from combustible;");
				
		rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
}
