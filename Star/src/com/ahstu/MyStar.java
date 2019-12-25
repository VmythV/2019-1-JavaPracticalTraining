package com.ahstu;

import javax.swing.JFrame;

public class MyStar {
	public static void main(String[] args) {
		// 1.创建窗口
		JFrame frame = new JFrame("满天星");
		/**添加画布*/
		MyStarPanel panel = new MyStarPanel();
		frame.add(panel);
		/**添加线程*/
		Thread t = new Thread(panel);
		t.start();
		
		// 2.设置大小
		frame.setSize(800, 600);
		// 3.设置关闭模式
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 4.设置居中显示
		frame.setLocationRelativeTo(null);
		// 5.设置可见
		frame.setVisible(true);
	}

}
