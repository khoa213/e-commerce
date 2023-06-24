import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbURL = "jdbc:sqlserver://localhost:1433;instance=sqlexpress;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
        
        try (Connection conn = DriverManager.getConnection(dbURL)) {
            if (conn != null) {
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	}


