package com.ahstu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * 线程的创建方式 
 * 1. implements Runnable
 * @author Administrator
 *
 */

public class MyStarPanel extends JPanel implements Runnable{
	
	int[] xx = new int[100];
	int[] yy = new int[100];
	// 构造函数
	public MyStarPanel() {
		for(int i = 0;i<100;i++) {
			xx[i] = (int)(Math.random()*800);
			yy[i] = (int)(Math.random()*600);
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.setBackground(Color.BLACK);
		// 月亮
		g.setColor(Color.WHITE);
		g.fillOval(100, 100, 100, 100);
		// 月黑
		g.setColor(Color.BLACK);
		g.fillOval(90, 90, 100, 100);
		
		
		g.setFont(new Font("微软雅黑",Font.BOLD,28));
		for(int i = 0;i < 100;i++) {
			int R = (int)(Math.random()*255);
			int G = (int)(Math.random()*255);
			int B = (int)(Math.random()*255);
			int x = (int)(Math.random()*800);
			int y = (int)(Math.random()*600);
			g.setColor(new Color(R,G,B));
			g.drawString("*", xx[i], yy[i]);			
		}
	}

	@Override
	public void run() {
		while(true) {
			// 从右往左移动
			for(int i = 0;i < 100;i++) {
				xx[i]++;
				yy[i]++;
				if(xx[i]>800) {
					xx[i] = 0;
				}
				if(yy[i]>600) {
					yy[i] = 0;
				}
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
