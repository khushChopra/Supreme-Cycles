package objectAndManagers;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessoryManager{
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
	public static void createAccessory(Accessory c_model) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "insert into accessory values( \""+c_model.getModel_code()+"\",\""+c_model.getModel_name()+"\",\""+

					c_model.getBrand_name()+"\",\""+
					c_model.getColor()+"\",\""+
					c_model.getType()+"\",\""+
					c_model.getAccessory_size()+"\","+
					c_model.getPrice()+",\""+
					c_model.getImage()+"\","+
					c_model.getQuantity()+")";
	 		
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
	public static Accessory readAccessory(String queryModel_code) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from accessory where model_code =\""+queryModel_code+"\"";
			//System.out.println(query);
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	Accessory result = new Accessory();
		 	rs.next();
		 	result.setModel_code(rs.getString(1));
		 	result.setModel_name(rs.getString(2));
		 	result.setBrand_name(rs.getString(3));
		 	result.setColor(rs.getString(4));
		 	result.setType(rs.getString(5));
		 	result.setAccessory_size(rs.getString(6));
		 	result.setPrice(rs.getInt(7));
		 	result.setImage(rs.getString(8));
		 	result.setQuantity(rs.getInt(9));
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
	public static void updateAccessory(Accessory c_model) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "update accessory set "
					+ "model_name = \""+c_model.getModel_name()+"\", "
					+ "brand_name=\""+c_model.getBrand_name()+"\", "
					+ "color=\""+c_model.getColor()+"\", "
					+ "type=\""+c_model.getType()+"\", "
					+ "accessory_size=\""+c_model.getAccessory_size()+"\", "
					+ "quantity="+c_model.getQuantity()+", "
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


	//update add stock
	public static void addStockAccessory(ArrayList<Purchase_accessory> list) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			
			for(Purchase_accessory temp: list) {
				String query = "update accessory set quantity= quantity + "+temp.getQuantity()+" where model_code = \""+temp.getModel_code()+"\"";
		 		Statement st = conn.createStatement();
			 	st.executeUpdate(query);
			}
			
		 	conn.close();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	//update subtract stock
	public static void subtractStockAccessory(ArrayList<AccessoryCart> list) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			
			for(AccessoryCart temp: list) {
				String query = "update accessory set quantity= quantity - "+temp.getQuantity()+" where model_code = \""+temp.getAccessory_code()+"\"";
		 		Statement st = conn.createStatement();
			 	st.executeUpdate(query);
			}
			
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
	public static void deleteAccessory(Accessory c_model) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from accessory where model_code=\""+c_model.getModel_code()+"\"";	 		
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
	
	public static void deleteAccessory(String queryModel_code) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "delete from accessory where model_code=\""+queryModel_code+"\"";
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
	public static ArrayList<Accessory> allAccessory(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/k", "Tester","Tester@123");
			String query = "select * from accessory";
	 		Statement st = conn.createStatement();
		 	ResultSet rs = st.executeQuery(query);
		 	ArrayList <Accessory> results = new ArrayList<Accessory>();
	 		
		 	while(rs.next()) {
		 		Accessory result = new Accessory();
		 		result.setModel_code(rs.getString(1));
			 	result.setModel_name(rs.getString(2));
			 	result.setBrand_name(rs.getString(3));
			 	result.setColor(rs.getString(4));
			 	result.setType(rs.getString(5));
			 	result.setAccessory_size(rs.getString(6));
			 	result.setPrice(rs.getInt(7));
			 	result.setImage(rs.getString(8));
			 	result.setQuantity(rs.getInt(9));
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