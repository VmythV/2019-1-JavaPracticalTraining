package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginDemo {

	public static void main(String[] args) {
		Scanner can=new Scanner(System.in);
		System.out.println("请输入登录信息");
		System.out.println("用户名:");
		String name=can.next();
		System.out.println("密码");
		String pwd=can.next();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
			String findUser="Select * from t_user where name='"+name+"'";
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(findUser);
			if(rs.next()){
				String username=rs.getString("name");
				String password=rs.getString("password");
				if(name.equals(username)){
					if(pwd.equals(password)){
						System.out.println("用户登录成功");
					}else{
						System.out.println("用户密码错误");
					}
				}else{
					System.out.println("用户名错误");
				}
			}else{
				System.out.println("用户不存在");
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
