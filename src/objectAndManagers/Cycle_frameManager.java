package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cycle_frameManager{
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
	public static void createCycle_frame(Cycle_frame input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into cycle_frame values( \""+

					input.getFrame_number()+"\",\""+
					input.getModel_code()+"\","+
					input.getPurchase_id()+")";
	 		
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
		
	
	// delete
	public static void deleteCycle_frame(Cycle_frame input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from cycle_frame where frame_number=\""+

					input.getFrame_number()+"\" and model_code=\""+
					input.getModel_code()+"\" and purchase_id="+
					input.getPurchase_id();
	 		
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
	
	
	
	// view all for one cycle type
	public static ArrayList<Cycle_frame> allCycle_frame(int purchase_id){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from cycle_frame where purchase_id="+purchase_id;
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Cycle_frame> results = new ArrayList<Cycle_frame>();
	 		
		 	while(rs.next()) {
		 		Cycle_frame result = new Cycle_frame();
		 		result.setFrame_number(rs.getString(1));
			 	result.setModel_code(rs.getString(2));
			 	result.setPurchase_id(rs.getInt(3));
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
	

	public static ArrayList<Cycle_frame> allCycle_frame(String model_code){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from cycle_frame where (frame_number, model_code) not in (select frame_number, model_code from invoice_frame) and model_code=\""+model_code+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Cycle_frame> results = new ArrayList<Cycle_frame>();
	 		
		 	while(rs.next()) {
		 		Cycle_frame result = new Cycle_frame();
		 		result.setFrame_number(rs.getString(1));
			 	result.setModel_code(rs.getString(2));
			 	result.setPurchase_id(rs.getInt(3));
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
	
	// get number of cycle of specific model_code
	public static int numberOfCycle_frame(String model_code){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select count(*) from cycle_frame where (frame_number, model_code) not in (select frame_number, model_code from invoice_frame) and model_code=\""+model_code+"\"";
			System.out.println(query);
			
			Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	
	 		
		 	while(rs.next()) {
		 		return rs.getInt(1); 		
		 	}
		 	conn.close();
		 	return 0;		 	
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}