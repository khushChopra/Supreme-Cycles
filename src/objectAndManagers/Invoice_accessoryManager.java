package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Invoice_accessoryManager{
	public Connection getConnected(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			return conn;
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	// create
	public static void createInvoice_accessory(Invoice_accessory input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into invoice_accessory values("+input.getInvoice_id()+",\""+input.getModel_code()+"\","+input.getQuantity() +")";
	 		Statement st = conn.createStatement();
		 	st.executeUpdate(query);
		 	conn.close();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
		
	
	// view all for particular number
	public static ArrayList<Invoice_accessory> allInvoice_accessory(int queryId){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from invoice_accessory where invoice_id="+queryId;
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Invoice_accessory> results = new ArrayList<Invoice_accessory>();
	 		
		 	while(rs.next()) {
		 		Invoice_accessory result = new Invoice_accessory();
		 		result.setInvoice_id(rs.getInt(1));
			 	result.setModel_code(rs.getString(2));
			 	result.setQuantity(rs.getInt(3));
		 		results.add(result);	 		
		 	}
		 	conn.close();
		 	return results;		 	
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public static ArrayList<Invoice_accessory> allInvoice_accessory(Invoice input){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from invoice_accessory where invoice_id="+input.getId();
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Invoice_accessory> results = new ArrayList<Invoice_accessory>();
	 		
		 	while(rs.next()) {
		 		Invoice_accessory result = new Invoice_accessory();
		 		result.setInvoice_id(rs.getInt(1));
			 	result.setModel_code(rs.getString(2));
			 	result.setQuantity(rs.getInt(3));
		 		results.add(result);	 		
		 	}
		 	conn.close();
		 	return results;		 	
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}