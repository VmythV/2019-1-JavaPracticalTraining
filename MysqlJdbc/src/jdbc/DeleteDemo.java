package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteDemo {
	public static void main(String[] args) {
		Scanner can=new Scanner(System.in);
		System.out.println("请输入删除用户名");
		System.out.println("用户名:");
		String name=can.next();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			String insert="delete from t_user where name='"+name+"'";
			Statement stat=conn.createStatement();
			int count=stat.executeUpdate(insert);
			if(count>0){
				System.out.println("用户删除成功");
			}else{
				System.out.println("用户删除失败");
			}
			conn.close();
			stat.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
