package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransporterManager{
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
	public static void createTransporter(Transporter input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into transporter values( \""+input.getNumber()+"\",\""+input.getName()+"\",\""+input.getAddress()+"\",\""+input.getArea()+"\")";
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
	public static void updateTransporter(Transporter input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "update transporter set name =\""+input.getName()+"\", address=\""+input.getAddress()+"\", area=\""+input.getArea()+"\"  where number = \""+input.getNumber()+"\"";
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


	public static void deleteTransporter(Transporter input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from transporter  where number = \""+input.getNumber()+"\"";
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
	public static ArrayList<Transporter> allTransporter(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from transporter";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Transporter> results = new ArrayList<Transporter>();
	 		
		 	while(rs.next()) {
		 		Transporter result = new Transporter();
		 		result.setNumber(rs.getString(1));
			 	result.setName(rs.getString(2));
			 	result.setAddress(rs.getString(3));
			 	result.setArea(rs.getString(4));
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
	public static Transporter getTransporter(String queryNumber){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from transporter where number=\""+queryNumber+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	rs.next();
		 	Transporter result = new Transporter();
	 		result.setNumber(rs.getString(1));
		 	result.setName(rs.getString(2));
		 	result.setAddress(rs.getString(3));
		 	result.setArea(rs.getString(4));
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