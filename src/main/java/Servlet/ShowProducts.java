package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowProducts
 */
@WebServlet("/ShowProducts")
public class ShowProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello</h1>");
		//out.println("<jsp:include page=\"home.html\"></jsp:include>");
		/*String dbURL = "jdbc:sqlserver://localhost:1433;instance=sqlexpress;databaseName=ShoppingDB;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
		try (Connection conn = DriverManager.getConnection(dbURL)) {
		    if (conn != null) {
		    	Statement stmt =   (Statement) conn.createStatement();
				ResultSet rs =   stmt.executeQuery("select * from Products");*/
				try {
					while (getResultSet().next()) {
						out.println("<tr>");
						out.println("<td>"+
								"<img src="+getResultSet().getString(5)+ " alt=\"iPhone\">"
								+"</td><td>"+"CELLPHONE"+"</td><td>"
								+getResultSet().getString(2)+"</td><td>"
								+"$"+getResultSet().getString(4)+"</td>");
						out.println("</tr>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*conn.close();
		    }
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}*/
		//out.println("<jsp:include page=\"footer.html\"></jsp:include>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	public ResultSet getResultSet() throws SQLException {
		String dbURL = "jdbc:sqlserver://localhost:1433;instance=sqlexpress;databaseName=ShoppingDB;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
		 Connection conn = DriverManager.getConnection(dbURL); 
		 ResultSet rs = null;
		    if (conn != null) {
		    	Statement stmt =   (Statement) conn.createStatement();
				 rs =   stmt.executeQuery("select * from Products");
				
		    }
			return rs;
	
		
	}
}
