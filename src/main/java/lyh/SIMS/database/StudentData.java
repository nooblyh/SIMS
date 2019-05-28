package lyh.SIMS.database;
import java.sql.*;
public class StudentData {
	Connection connection;
	Statement statement;
	ResultSet resultset;
	
	public StudentData() {
		//TODO
	}
	
	public String[] getByName(String name) {
		//TODO
		return null;
	}
	
	public String[] getByID(String ID) {
		//TODO
		return null;
	}
	
	public boolean insert(String[] student) {
		//TODO
		return false;
	}
	
	public boolean delete(String[] student) {
		//TODO
		return false;
	}
	
	public boolean setByName(String name, String[] attri) {
		//TODO
		return false;
	}
	
	public boolean setByID(String name, String[] attri) {
		//TODO
		return false;
	}
}
