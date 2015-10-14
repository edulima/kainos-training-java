import java.awt.Label;
import java.sql.*;


public class Login {
	
	private String username;
	private String password;
	public Connection conn = null;
	public Statement stmt  = null; 
	public ResultSet rs = null;
	public PreparedStatement login;
	private Language lang;
	
//	public Login () {
//		DBConnect co = new DBConnect();
//		conn = co.connect();
//	}

	public Login () {
		
	//	this();
		DBConnect co = new DBConnect();
		lang = new Language("english");
		conn = co.connect();
		
		//setUsername(username);
		//setPassword(password);	
		
//		DBConnect co = new DBConnect();
//		conn = co.connect();
		//validateUser(username, password);
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validateUser(String username, String password) {
		
		try {
			
		   login = conn.prepareStatement("select * from users where username =? and userpassword =?");
		   
		   login.setString(1, username);
		   login.setString(2, password);
		   
		   rs = login.executeQuery();
			
			if(rs.next()) {
			
				String msg = String.format("%s : %s",lang.getLanguage().get(0), rs.getString("username"));
				System.out.print(msg);	
				
			} else {
				
				System.out.print(lang.getLanguage().get(6));
			
			}
		
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean addUser(String username) {
		
		if(checkUsername(username)) {
			return true;
		}
		
		return false;
		
	}
	
	public boolean checkUsername(String username) {
		
		try {
			   login = conn.prepareStatement("select username from users where username=?");
			   login.setString(1, username);
			   rs = login.executeQuery();
				
			   if(rs.next()) {
				   rs.close();
				   return true;
			   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return false;	
	}
	
	public boolean insertUser(String username, String password) {
		
		try {
			   login = conn.prepareStatement("insert into users (username, userpassword) values (?,?)");
			   login.setString(1, username);
			   login.setString(2, password);
			   login.execute();
		
			    return true;
			      
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
	
}
