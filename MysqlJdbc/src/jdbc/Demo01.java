package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			String insert="insert into t_user values(null,'Tom','1234',1)";
			Statement stat=conn.createStatement();
			int count=stat.executeUpdate(insert);
			if(count>0){
				System.out.println("注册用户成功");
			}else{
				System.out.println("注册用户失败");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
