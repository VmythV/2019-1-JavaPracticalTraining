package com.ahstu;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyTomPanel extends Panel implements Runnable{
	
	BufferedImage back = null;
	String[] eatList = new String[40];
	int index = 0;
	int count = 40;
	
	public MyTomPanel() {
		try {
			back=ImageIO.read(MyTomPanel.class.getResource("Animations/Eat/eat_00.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 40; i++) {
			if(i<10) {
				eatList[i] = "Animations/Eat/eat_0"+i+".jpg";
			}else {
				eatList[i] = "Animations/Eat/eat_"+i+".jpg";
			}
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(back, 0, 0, 320, 512, null);
		
	}

	@Override
	public void run() {
		while(true) {
			
			index++;
			if(index<count) {
				try {
					back=ImageIO.read(
							MyTomPanel.class.getResource(
									eatList[index]));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else {
				index = 0;
			}
			
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
		
	}

}
