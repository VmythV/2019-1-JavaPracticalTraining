package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static String driver;
	static String url;
	static String username;
	static String password;
	static {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/db1";
		username = "root";
		password = "love1314";	
	}

	// 获取连接对象
	public static Connection getConn() 
			throws ClassNotFoundException,
			SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, 
				username, password);
	}

	// 关闭资源
	public static void close(Statement stat, Connection conn) {

		try {
			if (stat != null) {
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
