package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Purchase_recordManager{
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
	public static void createPurchase_record(Purchase_record input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into purchase_record values("+input.getId()+",\""+input.getcreation()+"\",\""+input.getOwner_number()+"\",\""+input.getDis_num()+"\","+input.getAmount()+ ",0)";
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
	public static void deletePurchase_record(int id) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from purchase_record where id="+id;
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
	

	// update
	public static void closePurchase_record(Purchase_record input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "update purchase_record set closed = 1 where id = "+input.getId();
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
	public static ArrayList<Purchase_record> allPurchase_record(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from purchase_record";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Purchase_record> results = new ArrayList<Purchase_record>();
	 		
		 	while(rs.next()) {
		 		Purchase_record result = new Purchase_record();
		 		result.setId(rs.getInt(1));
		 		result.setCreation(rs.getTimestamp(2));
			 	result.setOwner_number(rs.getString(3));
			 	result.setDis_num(rs.getString(4));
			 	result.setAmount(rs.getInt(5));
			 	result.setClosed(rs.getInt(6));			 	
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
	public static ArrayList<Purchase_record> allPurchase_record(Distributor input){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from purchase_record where dis_num=\""+input.getNumber()+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Purchase_record> results = new ArrayList<Purchase_record>();
	 		
		 	while(rs.next()) {
		 		Purchase_record result = new Purchase_record();
		 		result.setId(rs.getInt(1));
		 		result.setCreation(rs.getTimestamp(2));
			 	result.setOwner_number(rs.getString(3));
			 	result.setDis_num(rs.getString(4));
			 	result.setAmount(rs.getInt(5));
			 	result.setClosed(rs.getInt(6));
			 	
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

	public static ArrayList<Purchase_record> allPurchase_record(String distributor_num){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from purchase_record where dis_num=\""+distributor_num+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Purchase_record> results = new ArrayList<Purchase_record>();
	 		
		 	while(rs.next()) {
		 		Purchase_record result = new Purchase_record();
		 		result.setId(rs.getInt(1));
		 		result.setCreation(rs.getTimestamp(2));
			 	result.setOwner_number(rs.getString(3));
			 	result.setDis_num(rs.getString(4));
			 	result.setAmount(rs.getInt(5));
			 	result.setClosed(rs.getInt(6));
			 	
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
	

	public static Purchase_record readPurchase_record(int id){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from purchase_record where id="+id;
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
	 		if(rs.next()) {
	 			Purchase_record result = new Purchase_record();
		 		result.setId(rs.getInt(1));
		 		result.setCreation(rs.getTimestamp(2));
			 	result.setOwner_number(rs.getString(3));
			 	result.setDis_num(rs.getString(4));
			 	result.setAmount(rs.getInt(5));
			 	result.setClosed(rs.getInt(6));
			 	return result;
	 		}
	 		return null;	 	
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public static boolean all_closedPurchase_record(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from purchase_record where closed=0";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	System.out.println("chalfa");
	 		if(rs.next()) {
	 			return false;
	 		}
	 		conn.close();
 			return true;
 			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

			return true;
	}
	
	
	
}