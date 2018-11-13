package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Transaction_logManager{
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
	public static int createTransaction_log(Transaction_log input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into transaction_log(details,type,amount) values(\""+input.getDetails()+"\",\""+input.getType()+"\","+input.getAmount()+")";
	 		Statement st = conn.createStatement();
	 		st = conn.prepareStatement(query);
	 		int[] arr = {1};
	 		st.executeUpdate(query,arr);
	 		ResultSet rs = st.getGeneratedKeys();
		 	if(rs.next()){
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
	
	// view all
	public static ArrayList<Transaction_log> allTransaction_log(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from transaction_log";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Transaction_log> results = new ArrayList<Transaction_log>();
	 		
		 	while(rs.next()) {
		 		Transaction_log result = new Transaction_log();
		 		result.setId(rs.getInt(1));
			 	result.setDetails(rs.getString(2));
			 	result.setType(rs.getString(3));
			 	result.setAmount(rs.getInt(4));
			 	result.setCreation(rs.getTimestamp(5));
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
	public static Transaction_log getTransaction_log(int id){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from transaction_log where id="+id+"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	rs.next();
		 	Transaction_log result = new Transaction_log();
		 	result.setId(rs.getInt(1));
		 	result.setDetails(rs.getString(2));
		 	result.setType(rs.getString(3));
		 	result.setAmount(rs.getInt(4));
		 	result.setCreation(rs.getTimestamp(5));
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