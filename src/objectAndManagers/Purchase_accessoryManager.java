package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Purchase_accessoryManager{
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
	public static void createPurchase_accessory(Purchase_accessory input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into purchase_accessory values( \""+

					input.getModel_code()+"\","+
					input.getPurchase_id()+","+
					input.getQuantity()+")";
	 		
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
	public static void deletePurchase_accessory(Purchase_accessory input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from purchase_accessory where model_code=\""+
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
	public static ArrayList<Purchase_accessory> allPurchase_accessory(int purchase_id){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from purchase_accessory where purchase_id="+purchase_id;
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Purchase_accessory> results = new ArrayList<Purchase_accessory>();
	 		
		 	while(rs.next()) {
		 		Purchase_accessory result = new Purchase_accessory();
			 	result.setModel_code(rs.getString(1));
			 	result.setPurchase_id(rs.getInt(2));
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