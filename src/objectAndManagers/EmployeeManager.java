package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EmployeeManager{
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
	public static void createEmployee(Employee input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into employee values( \""+input.getNumber()+"\",\""+input.getName()+"\",\""+input.getAddress()+"\")";
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
	public static void updateEmployee(Employee input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "update employee set name =\""+input.getName()+"\", address=\""+input.getAddress()+"\"  where number = \""+input.getNumber()+"\"";
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
	
	//delete
	public static void deleteeEmployee(Employee input) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from employee where number = \""+input.getNumber()+"\"";
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
	public static ArrayList<Employee> allEmployee(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from employee";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Employee> results = new ArrayList<Employee>();
	 		
		 	while(rs.next()) {
		 		Employee result = new Employee();
		 		result.setNumber(rs.getString(1));
			 	result.setName(rs.getString(2));
			 	result.setAddress(rs.getString(3));
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
	public static Employee getEmployee(String queryNumber){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from employee where number=\""+queryNumber+"\"";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	rs.next();
		 	Employee result = new Employee();
	 		result.setNumber(rs.getString(1));
		 	result.setName(rs.getString(2));
		 	result.setAddress(rs.getString(3));
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