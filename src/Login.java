
import java.sql.*;

public class Login {

	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	public PreparedStatement login;
	private Language lang;
	private DBStatements queries;

	
	public Login() {

		DBConnection co = new DBConnection();
		conn = co.connect();
		
		queries = new DBStatements();
		lang = new Language("english");
	}

	public boolean validateUser(String username, String password) {

		try {

			login = conn
					.prepareStatement(queries.getValidateUserQuery());

			login.setString(1, username);
			login.setString(2, password);

			rs = login.executeQuery();

			if (rs.next()) {
				String msg = String.format("%s : %s",
						lang.getLanguage().get(0), rs.getString("username"));
				System.out.print(msg);
			} else {
				System.out.print(lang.getLanguage().get(6));
			}

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addUser(String username) {

		if (checkUsername(username)) {
			return true;
		}
		return false;
	}

	public boolean checkUsername(String username) {

		try {
			login = conn
					.prepareStatement(queries.getCheckUserNameQuery());
			login.setString(1, username);
			rs = login.executeQuery();

			if (rs.next()) {
				rs.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertUser(String username, String password) {

		try {
			login = conn
					.prepareStatement(queries.getInsertUserQuery());
			login.setString(1, username);
			login.setString(2, password);
			login.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean matchPassword(String password1, String password2) {
		if(!password1.equals(password2)) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfDBExists() {
		return false;
	}

}
