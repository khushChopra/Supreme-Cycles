package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FulfillmentManager{
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
	public static boolean createFulfillment(Customer input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			if(readFulfillment(input)!=null) {
				return false;
			}			
			String query = "insert into fulfillment(customer_number,requirements,address,price) values(\""+input.getNumber()+"\",\""+website1.calculations.requirements(input)+"\",\""+input.getAddress()+"\"," +website1.calculations.priceOfBoth(input)+")";
			Statement st = conn.createStatement();
		 	st.executeUpdate(query);
		 	conn.close();
		 	CycleCartManager.deleteallCycleCart(input);
		 	AccessoryCartManager.deleteallAccessoryCart(input);
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
	
	// read
	public static Fulfillment readFulfillment(Customer input){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from fulfillment where customer_number=\""+input.getNumber()+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	if(!rs.next()) {
		 		return null;
		 	}		 	
		 	Fulfillment result = new Fulfillment();
		 	result.setCustomer_number(rs.getString(1));
			result.setRequirements(rs.getString(2));
	 		result.setGenerated_time(rs.getTimestamp(3));
	 		result.setAddress(rs.getString(4));
	 		result.setPrice(rs.getInt(5));
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

	// delete
	public static void deleteFulfillment(Fulfillment input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from fulfillment where customer_number = \""+input.getCustomer_number()+"\" and generated_time="+input.getGenerated_time();
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
	

	public static void deleteFulfillment(Customer input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from fulfillment where customer_number = \""+input.getNumber()+"\"";
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
	public static ArrayList<Fulfillment> allFulfillment(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from fulfillment";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Fulfillment> results = new ArrayList<Fulfillment>();
	 		
		 	while(rs.next()) {
		 		Fulfillment result = new Fulfillment();
		 		result.setCustomer_number(rs.getString(1));
		 		result.setRequirements(rs.getString(2));
		 		result.setGenerated_time(rs.getTimestamp(3));
		 		result.setAddress(rs.getString(4));
		 		result.setPrice(rs.getInt(5));
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