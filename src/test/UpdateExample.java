package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "Admin@123");

		Statement stmt = con.createStatement();
		
		stmt.executeUpdate("update eproduct set price=6500.00 where name='Tablet';");
		
		System.out.println("Price is updated ");
		
		ResultSet result = stmt.executeQuery("select * from eproduct");

		while (result.next()) {

			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
			System.out.println("Price is " + result.getDouble("price"));
		}
		
		con.close();
	}

}
