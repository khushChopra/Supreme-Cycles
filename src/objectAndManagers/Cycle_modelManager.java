package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Cycle_modelManager{
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
	public static void createCycle_model(Cycle_model c_model) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into cycle_model values( \""+c_model.getModel_code()+"\",\""+c_model.getModel_name()+"\",\""+

					c_model.getBrand_name()+"\",\""+
					c_model.getColor()+"\",\""+
					c_model.getType()+"\",\""+
					c_model.getKit_details()+"\",\""+
					c_model.getFrame_size()+"\",\""+
					c_model.getWeight()+"\",\""+
					c_model.getMaterial()+"\","+
					c_model.getPrice()+",\""+
					c_model.getImage()+"\")";
	 		
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
		
	// read
	public static Cycle_model readCycle_model(String queryModel_code) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from cycle_model where model_code =\""+queryModel_code+"\"";
			//System.out.println(query);
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	Cycle_model result = new Cycle_model();
		 	rs.next();
		 	result.setModel_code(rs.getString(1));
		 	result.setModel_name(rs.getString(2));
		 	result.setBrand_name(rs.getString(3));
		 	result.setColor(rs.getString(4));
		 	result.setType(rs.getString(5));
		 	result.setKit_details(rs.getString(6));
		 	result.setFrame_size(rs.getString(7));
		 	result.setWeight(rs.getString(8));
		 	result.setMaterial(rs.getString(9));
		 	result.setPrice(rs.getInt(10));
		 	result.setImage(rs.getString(11));
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
	
	//update
	public static void updateCycle_model(Cycle_model c_model) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "update cycle_model set "
					+ "model_name = \""+c_model.getModel_name()+"\", "
					+ "brand_name=\""+c_model.getBrand_name()+"\", "
					+ "color=\""+c_model.getColor()+"\", "
					+ "type=\""+c_model.getType()+"\", "
					+ "kit_details=\""+c_model.getKit_details()+"\", "
					+ "frame_size=\""+c_model.getFrame_size()+"\", "
					+ "weight=\""+c_model.getWeight()+"\", "
					+ "material=\""+c_model.getMaterial()+"\", "
					+ "price="+c_model.getPrice()+", "
					+ "image=\""+c_model.getImage()+"\" "
					+ "where model_code = \""+c_model.getModel_code()+"\"";
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
	public static void deleteCycle_model(Cycle_model c_model) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from cycle_model where model_code=\""+c_model.getModel_code()+"\"";	 		
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
	
	public static void deleteCycle_model(String queryModel_code) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from cycle_model where model_code=\""+queryModel_code+"\"";
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
	
	// view all
	public static ArrayList<Cycle_model> allCycle_model(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from cycle_model";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Cycle_model> results = new ArrayList<Cycle_model>();
	 		
		 	while(rs.next()) {
		 		Cycle_model result = new Cycle_model();
		 		result.setModel_code(rs.getString(1));
			 	result.setModel_name(rs.getString(2));
			 	result.setBrand_name(rs.getString(3));
			 	result.setColor(rs.getString(4));
			 	result.setType(rs.getString(5));
			 	result.setKit_details(rs.getString(6));
			 	result.setFrame_size(rs.getString(7));
			 	result.setWeight(rs.getString(8));
			 	result.setMaterial(rs.getString(9));
			 	result.setPrice(rs.getInt(10));
			 	result.setImage(rs.getString(11));
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