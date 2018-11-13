package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SalaryManager{
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
	public static void createSalary(Salary input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into salary values("+input.getId()+",\""+input.getcreation()+"\",\""+input.getOwner_number()+"\",\""+input.getEmp_num()+"\","+input.getAmount()+ ")";
			Statement st = conn.createStatement();
		 	st.executeUpdate(query);
		 	conn.close();
		 	System.out.println("chala");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	// view all
	public static ArrayList<Salary> allSalary(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from salary";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Salary> results = new ArrayList<Salary>();
	 		
		 	while(rs.next()) {
		 		Salary result = new Salary();
		 		result.setId(rs.getInt(1));
		 		result.setCreation(rs.getTimestamp(2));
			 	result.setOwner_number(rs.getString(3));
			 	result.setEmp_num(rs.getString(4));
			 	result.setAmount(rs.getInt(5));
			 	
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
	public static ArrayList<Salary> allSalary(Employee input){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from salary where emp_num=\""+input.getNumber()+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Salary> results = new ArrayList<Salary>();
	 		
		 	while(rs.next()) {
		 		Salary result = new Salary();
		 		result.setId(rs.getInt(1));
		 		result.setCreation(rs.getTimestamp(2));
			 	result.setOwner_number(rs.getString(3));
			 	result.setEmp_num(rs.getString(4));
			 	result.setAmount(rs.getInt(5));
			 	
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
	
	public static ArrayList<Salary> allSalary(String input){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "\"select * from salary where emp_num=\""+input+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Salary> results = new ArrayList<Salary>();
	 		
		 	while(rs.next()) {
		 		Salary result = new Salary();
		 		result.setId(rs.getInt(1));
		 		result.setCreation(rs.getTimestamp(2));
			 	result.setOwner_number(rs.getString(3));
			 	result.setEmp_num(rs.getString(4));
			 	result.setAmount(rs.getInt(5));
			 	
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