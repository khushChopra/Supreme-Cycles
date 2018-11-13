package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CycleCartManager{
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
	public static void createCycleCart(CycleCart input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			// check if already exists
			if(duplicateCycleCart(input)) {
				updateCycleCart(input);
				return;
			}
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			
			
						
			String query = "insert into ccart values( \""+input.getCustomer_number()+"\",\""+input.getCycle_code()+"\","+input.getQuantity() +")";
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
	public static void updateCycleCart(CycleCart input) {
		Connection conn = null;
		try {
			if(input.getQuantity()==0) {
				deleteCycleCart(input);
				return;
			}
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "update ccart set quantity ="+input.getQuantity()+" where customer_number = \""+input.getCustomer_number()+"\" and cycle_code=\""+input.getCycle_code()+"\"";
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
	public static void deleteCycleCart(CycleCart input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from ccart where customer_number = \""+input.getCustomer_number()+"\" and cycle_code=\""+input.getCycle_code()+"\"";
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
	

	public static void deleteallCycleCart(Customer input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from ccart where customer_number = \""+input.getNumber()+"\"";
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
	public static ArrayList<CycleCart> allCustomerCycleCart(String queryNumber){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from ccart where customer_number=\""+queryNumber+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <CycleCart> results = new ArrayList<CycleCart>();
	 		
		 	while(rs.next()) {
		 		CycleCart result = new CycleCart();
		 		result.setCustomer_number(rs.getString(1));
			 	result.setCycle_code(rs.getString(2));
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
	
	public static ArrayList<CycleCart> allCustomerCycleCart(Customer cust){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from ccart where customer_number=\""+cust.getNumber()+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <CycleCart> results = new ArrayList<CycleCart>();
	 		
		 	while(rs.next()) {
		 		CycleCart result = new CycleCart();
		 		result.setCustomer_number(rs.getString(1));
			 	result.setCycle_code(rs.getString(2));
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

	
	public static boolean duplicateCycleCart(CycleCart input){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from ccart where customer_number=\""+input.getCustomer_number()+"\" and cycle_code=\""+input.getCycle_code()+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <CycleCart> results = new ArrayList<CycleCart>();
	 		
		 	while(rs.next()) {
		 		CycleCart result = new CycleCart();
		 		result.setCustomer_number(rs.getString(1));
			 	result.setCycle_code(rs.getString(2));
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