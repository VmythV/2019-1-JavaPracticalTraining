package com.ahstu;

import javax.swing.JFrame;

public class MyWord {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		MyWordPanel panel = new MyWordPanel();
		frame.add(panel);
		
		Thread t = new Thread(panel);
		t.start();
		
		panel.addKeyListener(panel);
		
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		panel.setFocusable(true);
	}
}
