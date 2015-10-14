
public class DBStatements {
	
	
	public String selectUsers() {
		String sql = "SELECT * from users where username = ";
		return sql;
	}
	
	public String getValidateUserQuery() {
		String sql = "select * from users where username =? and userpassword =?";
		return sql;	
	}
	
	public String getCheckUserNameQuery() {
		String sql = "select username from users where username=?";
		return sql;	
	}
	
	public String getInsertUserQuery() {
		String sql = "insert into users (username, userpassword) values (?,?)";
		return sql;	
	}
	
	public String checkIfDBExists() {
		
		String sql = "CREATE DATABASE IF NOT EXISTS ?;";
		return sql;
		
	}
 

}
