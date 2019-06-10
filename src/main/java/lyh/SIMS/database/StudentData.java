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
	
	public Vector getAll() {
		String sql = "SELECT * from students;";
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);		
			Vector result = new Vector();
			int id,gender,grade,_class,islocal,chinese,mathematics,english;
	        String name,phone;
			while(rs.next()) {
				Vector data = new Vector();
	        	result.addElement(data);
	            id  = rs.getInt("ID");
	            data.addElement(id);
	            name = rs.getString("Name");
	            data.addElement(name);
	            gender = rs.getInt("Gender");
	            if(gender == 1)
	            	data.addElement("男");
	            else
	            	data.addElement("女");
	            islocal = rs.getInt("isLocal");
	            if(gender == 1)
	            	data.addElement("本地生");
	            else
	            	data.addElement("外地生");
	            grade = rs.getInt("grade");
	            data.addElement(grade);
	            _class = rs.getInt("class");
	            data.addElement(_class);
	            chinese = rs.getInt("Chinese");
	            data.addElement(chinese);
	            mathematics = rs.getInt("Mathematics");
	            data.addElement(mathematics);
	            english = rs.getInt("English");
	            data.addElement(english);
	            phone = rs.getString("PhoneNumber");
	            data.addElement(phone);
			}
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
            if(gender == 1)
            	data.addElement("男");
            else
            	data.addElement("女");
            grade = rs.getInt("Grade");
            data.addElement(grade);
            _class = rs.getInt("class");
            data.addElement(_class);
            isLocal = rs.getInt("isLocal");
            if(gender == 1)
            	data.addElement("本地生");
            else
            	data.addElement("外地生");
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
        int id,gender,grade,_class,islocal,chinese,mathematics,english;
        String phone;
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
            grade = rs.getInt("Grade");
            data.addElement(grade);
            _class = rs.getInt("Class");
            data.addElement(_class);
            islocal = rs.getInt("isLocal");
            data.addElement(islocal);
            chinese = rs.getInt("Chinese");
            data.addElement(chinese);
            mathematics = rs.getInt("Mathematics");
            data.addElement(mathematics);
            english = rs.getInt("English");
            data.addElement(english);
            phone = rs.getString("PhoneNumber");
            data.addElement(phone); 
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
	        int id,gender,grade,_class,isLocal;
	        String name,phoneNumber;
	        Vector result = new Vector();
	        // 展开结果集数据库
	        while(rs.next()){
	            // 通过字段检索
	            id  = rs.getInt("ID");
	            result.addElement(id);
	            name  = rs.getString("Name");
	            result.addElement(name);
	            gender = rs.getInt("Gender");
	            result.addElement(gender);
	            grade = rs.getInt("Grade");
	            result.addElement(grade);
	            _class = rs.getInt("class");
	            result.addElement(_class);
	            isLocal = rs.getInt("isLocal");
	            result.addElement(isLocal);
	            phoneNumber  = rs.getString("phoneNumber");
	            result.addElement(phoneNumber);
	        }
	        // 完成后关闭
	        statement.close();
	        return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	public Vector getByClass(int grade, int _class) {
		try {
			statement = connection.createStatement();
	        String sql;
	        sql = "SELECT * FROM Students WHERE Class='"+_class+"' AND "
	        		+ "Grade = '"+ grade +"' ;";
	        ResultSet rs = statement.executeQuery(sql);
	        int id,gender,islocal,chinese,mathematics,english;
	        String name,phone;
	        Vector result = new Vector();
	        // 展开结果集数据库
	        while(rs.next()){
	            // 通过字段检索  	
	        	Vector data = new Vector();
	        	result.addElement(data);
	            id  = rs.getInt("ID");
	            data.addElement(id);
	            name = rs.getString("Name");
	            data.addElement(name);
	            gender = rs.getInt("Gender");
	            data.addElement(gender);
	            islocal = rs.getInt("isLocal");
	            data.addElement(islocal);
	            data.addElement(grade);
	            data.addElement(_class);
	            chinese = rs.getInt("Chinese");
	            data.addElement(chinese);
	            mathematics = rs.getInt("Mathematics");
	            data.addElement(mathematics);
	            english = rs.getInt("English");
	            data.addElement(english);
	            phone = rs.getString("PhoneNumber");
	            data.addElement(phone);
	        }
	        // 完成后关闭
	        statement.close();
	        return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	
	public boolean BasicSet(String[] student) {
		//TODO
		for(int i=0;i<student[6].length();i++)
			if(student[6].charAt(i)>'9'||student[6].charAt(i)<'0')
				return false;
		try {
			statement = connection.createStatement();
			String sql;
			sql = "UPDATE students SET Name = '"
					+ student[1]+"', Gender = '"
					+ student[2]+"', Grade ='"
					+ student[3]+"', Class ='"
					+ student[4]+"', isLocal ='"
					+ student[5]+"', PhoneNumber ='"
					+ student[6]+"' WHERE ID = '"
					+ student[0]+"';";
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return false;
	}
	
	public boolean BasicInsert(String[] student) {
		//TODO
		for(int i=0;i<student[6].length();i++) 
			if(student[6].charAt(i)>'9'||student[6].charAt(i)<'0')
				return false;
		try {
			statement = connection.createStatement();
			String sql;
			sql = "INSERT INTO students (ID,Name,Gender,Grade,Class,isLocal,PhoneNumber)VALUES ('"
					+ student[0]+"',  '"
					+ student[1]+"',  '"
					+ student[2]+"',  '"
					+ student[3]+"',  '"
					+ student[4]+"',  '"
					+ student[5]+"',  '"
					+ student[6]+"');";
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return false;
	}
	
	public boolean delete(int ID) {
		//TODO
		try {
			statement = connection.createStatement();
			String sql = "DELETE FROM students WHERE ID = '"+ID+"';"; 
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean ScoreSet(int ID,String Subject,int Score) {
		//TODO
		try {
			statement = connection.createStatement();
			String sql = "UPDATE FROM students SET "
				+Subject+ "='"+Score
						+ "' WHERE ID = '"+ID+"';"; 
			statement.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
