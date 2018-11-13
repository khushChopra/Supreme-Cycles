package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerManager{
	public Connection getConnected(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/k", "Tester","Tester@123");
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
	public static void createCustomer(Customer cust) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into customer values( \""+cust.getNumber()+"\",\""+cust.getName()+"\",\""+cust.getAddress()+"\",\""+cust.getEmail() +"\")";
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
		
	// read
	public static Customer readCustomer(String queryNumber) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from customer where number =\""+queryNumber+"\"";
			//System.out.println(query);
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	Customer result = new Customer();
		 	rs.next();
		 	result.setNumber(rs.getString(1));
		 	result.setName(rs.getString(2));
		 	result.setAddress(rs.getString(3));
		 	result.setEmail(rs.getString(4));
		 	conn.close();
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
		
	

	
	// read
	public static Customer readCustomer(String queryNumber,String queryName) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from customer where number =\""+queryNumber+"\" and name =\""+queryName+"\"";
			//System.out.println(query);
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	Customer result = new Customer();
		 	rs.next();
		 	result.setNumber(rs.getString(1));
		 	result.setName(rs.getString(2));
		 	result.setAddress(rs.getString(3));
		 	result.setEmail(rs.getString(4));
		 	conn.close();
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
		
	
	//update
	public void updateCustomer(Customer cust) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "update customer set name = \""+cust.getName()+"\", address=\""+cust.getAddress()+"\", email=\""+cust.getEmail()+"\" where number = \""+cust.getNumber()+"\"";
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

	// no delete
	
	// view all
	public static ArrayList<Customer> allCustomer(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from customer";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Customer> result = new ArrayList<Customer>();
	 		
		 	while(rs.next()) {
		 		Customer k = new Customer();
		 		k.setName(rs.getString("name"));
		 		k.setNumber(rs.getString("number"));
		 		k.setEmail(rs.getString("email"));
		 		k.setAddress(rs.getString("address"));
		 		result.add(k);	 		
		 	}
		 	conn.close();
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