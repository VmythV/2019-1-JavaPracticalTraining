package com.ahstu;

import javax.swing.JFrame;

public class MyStar {
	public static void main(String[] args) {
		// 1.��������
		JFrame frame = new JFrame("������");
		/**��ӻ���*/
		MyStarPanel panel = new MyStarPanel();
		frame.add(panel);
		/**����߳�*/
		Thread t = new Thread(panel);
		t.start();
		
		// 2.���ô�С
		frame.setSize(800, 600);
		// 3.���ùر�ģʽ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 4.���þ�����ʾ
		frame.setLocationRelativeTo(null);
		// 5.���ÿɼ�
		frame.setVisible(true);
	}

}
