
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbURL = "jdbc:sqlserver://localhost:1433;instance=sqlexpress;databaseName=ShoppingDB;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
		try (Connection conn = DriverManager.getConnection(dbURL)) {
            if (conn != null) {
            	Statement stmt =   (Statement) conn.createStatement();
    			ResultSet rs =   stmt.executeQuery("select * from Products");
    			while (rs.next()) {
    				System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
    			}
    			conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}

}
