package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RegistDemo {
	public static void main(String[] args) {
		Scanner can=new Scanner(System.in);
		System.out.println("请输入注册信息");
		System.out.println("用户名:");
		String name=can.next();
		System.out.println("密码");
		String pwd=can.next();
		try {
			Connection conn2 = DBUtil.getConn();
			String insert="insert into t_user values(null,'"+name+"','"+pwd+"',1)";
			Statement createStatement = conn2.createStatement();
			int count2 = createStatement.executeUpdate(insert);
			if(count2>0){
				System.out.println("用户注册成功");
			}else{
				System.out.println("用户注册失败");
			}
			conn2.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
