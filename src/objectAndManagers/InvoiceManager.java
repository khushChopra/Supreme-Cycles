package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InvoiceManager{
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
	public static void createInvoice(Invoice input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into invoice values("+input.getId()+",\""+input.getcreation()+"\",\""+input.getCustomer_number()+"\",\""+input.getAddress()+"\","+input.getAmount()+ ",\""+input.getTransportservice_id()+"\")";
			System.out.println(query);
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
	

	// view all
	public static ArrayList<Invoice> allInvoice(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from invoice";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Invoice> results = new ArrayList<Invoice>();
	 		
		 	while(rs.next()) {
		 		Invoice result = new Invoice();
		 		result.setId(rs.getInt(1));
		 		result.setCreation(rs.getTimestamp(2));
			 	result.setCustomer_number(rs.getString(3));
			 	result.setAddress(rs.getString(4));
			 	result.setAmount(rs.getInt(5));
			 	result.setTransportservice_id(rs.getString(6));			 	
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
	
	// view from number
	public static ArrayList<Invoice> allInvoice(Customer input){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from invoice where customer_number=\""+input.getNumber()+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Invoice> results = new ArrayList<Invoice>();
	 		
		 	while(rs.next()) {
		 		Invoice result = new Invoice();
		 		result.setId(rs.getInt(1));
		 		result.setCreation(rs.getTimestamp(2));
			 	result.setCustomer_number(rs.getString(3));
			 	result.setAddress(rs.getString(4));
			 	result.setAmount(rs.getInt(5));
			 	result.setTransportservice_id(rs.getString(6));			 	
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

	public static ArrayList<Invoice> allInvoice(String queryNumber){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from invoice where customer_number=\""+queryNumber+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Invoice> results = new ArrayList<Invoice>();
	 		
		 	while(rs.next()) {
		 		Invoice result = new Invoice();
		 		result.setId(rs.getInt(1));
		 		result.setCreation(rs.getTimestamp(2));
			 	result.setCustomer_number(rs.getString(3));
			 	result.setAddress(rs.getString(4));
			 	result.setAmount(rs.getInt(5));
			 	result.setTransportservice_id(rs.getString(6));			 	
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

	public static Invoice readInvoice(int id){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from invoice where id="+id;
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	rs.next();
		 	Invoice result = new Invoice();
 			result.setId(rs.getInt(1));
	 		result.setCreation(rs.getTimestamp(2));
		 	result.setCustomer_number(rs.getString(3));
		 	result.setAddress(rs.getString(4));
		 	result.setAmount(rs.getInt(5));
		 	result.setTransportservice_id(rs.getString(6));
		 	return result;
		 		 	
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