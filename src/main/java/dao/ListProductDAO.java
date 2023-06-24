package dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;
public class ListProductDAO {
	public void search(String characters) throws Exception {
		List<Product> list = new ArrayList<Product>();
		String dbURL = "jdbc:sqlserver://localhost:1433;instance=sqlexpress;databaseName=ShoppingDB;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";
		Connection conn = DriverManager.getConnection(dbURL);
		String sql = "select * from Products where product_name like '%" + characters + "%'";
		Statement stmt =    conn.prepareStatement(sql);
		ResultSet rs =   stmt.executeQuery(sql);
		while(rs.next()) {
            int productId = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            String productDes = rs.getString("product_des");
            float productPrice = rs.getFloat("product_price");
            String productImgSource = rs.getString("product_img_source");
            String productType = rs.getString("product_type");
            String productBrand = rs.getString("product_brand");
            int productQuantity = rs.getInt("product_quantity");
            double productAmount = productPrice * productQuantity;
            Product product = new Product(productId, productName, productDes, productPrice, productImgSource, productType, productBrand);
            
            list.add(product);
            
        }
	}
}
