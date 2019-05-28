package lyh.SIMS.database;
import java.sql.*;
public class UserData {
	Connection connection;
	Statement statement;
	ResultSet resultset;
	
	public UserData(){
		
	}
	
	public boolean addUser(String username, String password) {
		//TODO
		return false;
	}
	
	public boolean deleteUser(String username, String password) {
		//TODO
		return false;
	}
	
	public boolean modifypassword(String username, String former) {
		//TODO
		return false;
	}
	
	public boolean vertify(String username) {
		//TODO
		return false;
	}
	
	
	
}