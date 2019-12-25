package com.ahstu;

import javax.swing.JFrame;

public class MyStar {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MyStarPanel panel = new MyStarPanel();
		frame.add(panel);
		
		Thread t = new Thread(panel);
		t.start();
		
		
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
