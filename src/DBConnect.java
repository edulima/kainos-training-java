/*
 * Import Connection Objects
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnect {
	
	public Connection conn = null;
	public Statement stmt  = null; 
	public ResultSet rs = null;
	private String dbUsername;
	private String dbPassword;
	
	public Connection connect () {
				  
	  //database credentials
	  String url = "jdbc:mysql://localhost:3306/Users";
	  dbUsername = "root";
	  dbPassword = "ch@ngeme1";
	    	
	   try {
		   
		    DBQueries queries = new DBQueries();
	        Class.forName("com.mysql.jdbc.Driver").newInstance();		       
		    conn = DriverManager.getConnection(url,dbUsername,dbPassword);
		        	  
	    }catch(SQLException se) {
		      se.printStackTrace();	   
		      System.err.print("could not connect" + se.getMessage());
		      
	    } catch(Exception e){
	        e.printStackTrace();
	     }
		return conn;
	 }
	
}
