package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessoryCartManager{
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
	public static void createAccessoryCart(AccessoryCart input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			// check if already exists
			if(duplicateAccessoryCart(input)) {
				updateAccessoryCart(input);
				return;
			}
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into acart values( \""+input.getCustomer_number()+"\",\""+input.getAccessory_code()+"\","+input.getQuantity() +")";
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
	
	//update
	public static void updateAccessoryCart(AccessoryCart input) {
		Connection conn = null;
		try {
			if(input.getQuantity()==0) {
				deleteAccessoryCart(input);
				return;
			}
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "update acart set quantity ="+input.getQuantity()+" where customer_number = \""+input.getCustomer_number()+"\" and accessory_code=\""+input.getAccessory_code()+"\"";
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

	// delete
	public static void deleteAccessoryCart(AccessoryCart input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from acart where customer_number = \""+input.getCustomer_number()+"\" and accessory_code=\""+input.getAccessory_code()+"\"";
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
	

	public static void deleteallAccessoryCart(Customer input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from acart where customer_number = \""+input.getNumber()+"\"";
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
	public static ArrayList<AccessoryCart> allCustomerAccessoryCart(String queryNumber){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from acart where customer_number=\""+queryNumber+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <AccessoryCart> results = new ArrayList<AccessoryCart>();
	 		
		 	while(rs.next()) {
		 		AccessoryCart result = new AccessoryCart();
		 		result.setCustomer_number(rs.getString(1));
			 	result.setAccessory_code(rs.getString(2));
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
	
	public static ArrayList<AccessoryCart> allCustomerAccessoryCart(Customer cust){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from acart where customer_number=\""+cust.getNumber()+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <AccessoryCart> results = new ArrayList<AccessoryCart>();
	 		
		 	while(rs.next()) {
		 		AccessoryCart result = new AccessoryCart();
		 		result.setCustomer_number(rs.getString(1));
			 	result.setAccessory_code(rs.getString(2));
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
	
	public static boolean duplicateAccessoryCart(AccessoryCart input){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from acart where customer_number=\""+input.getCustomer_number()+"\" and accessory_code=\""+input.getAccessory_code()+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <AccessoryCart> results = new ArrayList<AccessoryCart>();
	 		
		 	while(rs.next()) {
		 		AccessoryCart result = new AccessoryCart();
		 		result.setCustomer_number(rs.getString(1));
			 	result.setAccessory_code(rs.getString(2));
			 	result.setQuantity(rs.getInt(3));
		 		results.add(result);	 		
		 	}
		 	conn.close();
		 	if(results.size()==0) {
		 		return false;
		 	}
		 	return true;		 	
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
}