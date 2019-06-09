package lyh.SIMS.database;
import java.sql.*;
import java.util.Vector;
public class StudentData {
	Connection connection;
	Statement statement;
	ResultSet resultset;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/SIMS?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "123";

	
	
	public StudentData() {
		try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
        
            // 打开链接
            System.out.println("连接数据库...");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
	    }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
	    }
	}
	
	public Vector getMeta() {
		String sql = "DESCRIBE students;";
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);		
			Vector result = new Vector();
			while(rs.next())
				result.add(rs.getString(1));
			statement.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public Vector getBasicMeta() {
		String sql = "DESCRIBE students;";
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);		
			Vector result = new Vector();
			while(rs.next())
				result.add(rs.getString(1));
			statement.close();
			result.remove(7);
			result.remove(7);
			result.remove(7);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Vector getBasic() {
		try {
		statement = connection.createStatement();
        String sql;
        sql = "SELECT * FROM Students;";
        ResultSet rs = statement.executeQuery(sql);
        int id,gender,grade,_class,isLocal;
        String name,phoneNumber;
        Vector result = new Vector();
        // 展开结果集数据库
        while(rs.next()){
            // 通过字段检索
        	Vector data = new Vector();
        	result.addElement(data);
            id  = rs.getInt("ID");
            data.addElement(id);
            name  = rs.getString("Name");
            data.addElement(name);
            gender = rs.getInt("Gender");
            data.addElement(gender);
            grade = rs.getInt("Grade");
            data.addElement(grade);
            _class = rs.getInt("class");
            data.addElement(_class);
            isLocal = rs.getInt("isLocal");
            data.addElement(isLocal);
            phoneNumber  = rs.getString("phoneNumber");
            data.addElement(phoneNumber);
        }
        // 完成后关闭
        statement.close();
        return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Vector getByName(String name) {
		try {
		statement = connection.createStatement();
        String sql;
        sql = "SELECT * FROM Students WHERE Name='"+name+"';";
        ResultSet rs = statement.executeQuery(sql);
        int id,gender,chinese,mathematics,english;
        Vector result = new Vector();
        // 展开结果集数据库
        while(rs.next()){
            // 通过字段检索
        	Vector data = new Vector();
        	result.addElement(data);
            id  = rs.getInt("ID");
            data.addElement(id);
            data.addElement(name);
            gender = rs.getInt("Gender");
            data.addElement(gender);
            chinese = rs.getInt("Chinese");
            data.addElement(chinese);
            mathematics = rs.getInt("Mathematics");
            data.addElement(mathematics);
            english = rs.getInt("English");
            data.addElement(english);
            // 输出数据
            System.out.print("id: " + id);
            System.out.print(", name: " + name);
            System.out.print(", gender: " + gender);
            System.out.print(", chinese: " + chinese);
            System.out.print(", mathematics: " + mathematics);
            System.out.print(", english: " + english);
            System.out.print("\n");
        }
        // 完成后关闭
        statement.close();
        return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Vector getByID(int ID) {
		try {
			statement = connection.createStatement();
	        String sql;
	        sql = "SELECT * FROM Students WHERE ID='"+ID+"';";
	        ResultSet rs = statement.executeQuery(sql);
	        int gender,chinese,mathematics,english;
	        String name;
	        Vector result = new Vector();
	        // 展开结果集数据库
	        while(rs.next()){
	            // 通过字段检索
	        	result.addElement(ID);
	        	name  = rs.getString("Name");
	            result.addElement(name);
	            gender = rs.getInt("Gender");
	            result.addElement(gender);
	            chinese = rs.getInt("Chinese");
	            result.addElement(chinese);
	            mathematics = rs.getInt("Mathematics");
	            result.addElement(mathematics);
	            english = rs.getInt("English");
	            result.addElement(english);
	            // 输出数据
	            System.out.print("id: " + ID);
	            System.out.print(", name: " + name);
	            System.out.print(", gender: " + gender);
	            System.out.print(", chinese: " + chinese);
	            System.out.print(", mathematics: " + mathematics);
	            System.out.print(", english: " + english);
	            System.out.print("\n");
	        }
	        // 完成后关闭
	        statement.close();
	        return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

	public Vector getScoreMeta() {
		// TODO Auto-generated method stub
		String sql = "DESCRIBE students;";
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);		
			Vector result = new Vector();
			while(rs.next())
				result.add(rs.getString(1));
			statement.close();
			result.remove(2);
			result.remove(2);
			result.remove(2);
			result.remove(2);
			result.remove(2);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Vector getScore() {
		// TODO Auto-generated method stub
		try {
			int col = getMeta().size();
			statement = connection.createStatement();
	        String sql;
	        sql = "SELECT * FROM Students;";
	        ResultSet rs = statement.executeQuery(sql);
	        int id,score;
	        String name,phoneNumber;
	        Vector result = new Vector();
	        // 展开结果集数据库
	        while(rs.next()){
	            // 通过字段检索
	        	Vector data = new Vector();
	        	result.addElement(data);
	        	id  = rs.getInt("ID");
	            data.addElement(id);
	            name  = rs.getString("Name");
	            data.addElement(name);
	        	for(int i=8;i<=col;i++) {
	        		score  = rs.getInt(i);
		            data.addElement(score);
	        	}
	        }
	        // 完成后关闭
	        statement.close();
	        return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
}
