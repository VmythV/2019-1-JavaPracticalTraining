package com.ahstu;

import javax.swing.JFrame;

public class MyBall {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MyBallPanel panel = new MyBallPanel();
		frame.add(panel);
		Thread t = new Thread(panel);
		t.start();
		
		frame.setUndecorated(true);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
