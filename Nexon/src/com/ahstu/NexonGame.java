package com.ahstu;

import javax.swing.JFrame;

/**
 * 窗口类
 * @author Administrator
 *
 */
public class NexonGame {
	public static void main(String[] args) {
		// 1.设置窗口
		JFrame frame = new JFrame();
		/**添加画布*/
		NexonPanel panel = new NexonPanel();
		frame.add(panel);
		/**添加线程*/
		Thread t = new Thread(panel);
		t.start();
		/**窗口格式化**/
		frame.setUndecorated(true);
		
		frame.addMouseListener(panel);
		frame.addKeyListener(panel);
		
		// 2.设置大小
		frame.setSize(925, 700);
		// 3.设置居中显示
		frame.setLocationRelativeTo(null);
		// 4.设置关闭模式
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 5.设置可见
		frame.setVisible(true);
		frame.setFocusable(true);
		
	}
}
