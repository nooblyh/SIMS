package lyh.SIMS.database;
import java.sql.*;
import java.util.Vector;
public class UserData {
	Connection connection;
	Statement statement;
	ResultSet resultset;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/SIMS?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "123";
	
	public UserData(){
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
	
	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public boolean vertify(String username,String password) {
		try {
			statement = connection.createStatement();
	        String sql;
	        sql = "SELECT Password FROM Users WHERE Name='"+username+"';";
	        ResultSet rs = statement.executeQuery(sql);
	        String realpassword = null;
	        // 展开结果集数据库
	        while(rs.next()){
	            // 通过字段检索
	        	realpassword = rs.getString("Password");
	        }
	        // 完成后关闭
	        statement.close();
	        if(realpassword.equals(password))
	        	return true;
	        else return false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
	}
}