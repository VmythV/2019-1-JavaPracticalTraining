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
		System.out.println("������ע����Ϣ");
		System.out.println("�û���:");
		String name=can.next();
		System.out.println("����");
		String pwd=can.next();
		try {
			Connection conn2 = DBUtil.getConn();
			String insert="insert into t_user values(null,'"+name+"','"+pwd+"',1)";
			Statement createStatement = conn2.createStatement();
			int count2 = createStatement.executeUpdate(insert);
			if(count2>0){
				System.out.println("�û�ע��ɹ�");
			}else{
				System.out.println("�û�ע��ʧ��");
			}
			conn2.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
