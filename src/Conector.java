import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	
	protected static Connection conexion;
	
	Conector() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/appaita", "root", "");
			
		} catch (SQLException e){
			
			System.err.println("Error en El Conector");
			
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
