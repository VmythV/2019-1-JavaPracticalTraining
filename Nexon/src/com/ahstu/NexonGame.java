package com.ahstu;

import javax.swing.JFrame;

/**
 * ������
 * @author Administrator
 *
 */
public class NexonGame {
	public static void main(String[] args) {
		// 1.���ô���
		JFrame frame = new JFrame();
		/**��ӻ���*/
		NexonPanel panel = new NexonPanel();
		frame.add(panel);
		/**����߳�*/
		Thread t = new Thread(panel);
		t.start();
		/**���ڸ�ʽ��**/
		frame.setUndecorated(true);
		
		frame.addMouseListener(panel);
		frame.addKeyListener(panel);
		
		// 2.���ô�С
		frame.setSize(925, 700);
		// 3.���þ�����ʾ
		frame.setLocationRelativeTo(null);
		// 4.���ùر�ģʽ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 5.���ÿɼ�
		frame.setVisible(true);
		frame.setFocusable(true);
		
	}
}
