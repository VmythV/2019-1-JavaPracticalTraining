package com.ahstu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * 画布类
 * 增加思维逻辑
 * 少儿编程
 * @author Administrator
 *
 */
public class MyStarPanel extends JPanel implements Runnable{
	// 设置星星坐标值
	int[] xx = new int[100];
	int[] yy = new int[100];

	// 构造方法 /函数 方法名必须与类名相同
	public MyStarPanel() {
		for(int i = 0;i < 100;i++) {
			xx[i] = (int)(Math.random()*800);
			yy[i] = (int)(Math.random()*600);
		}
	}
	int moonx = 0;
	int moony = 0;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 1.设置背景颜色
		this.setBackground(Color.BLACK);
		// 2.设置格式大小
		Font font = new Font("微软雅黑",Font.BOLD,28);
		g.setFont(font);
		// 3.设置画笔颜色
		
		//月亮
		g.setColor(Color.WHITE);
		g.fillOval(100, 100, 100, 100);
		
		//月缺
		g.setColor(Color.BLACK);
		g.fillOval(moonx, moony, 100, 100);
		moonx++;
		moony++;
		// 4.绘制星星
		for(int i = 0;i < 100;i++) {
			// 随机产生坐标
			//int x = (int)(Math.random()*800);
			//int y = (int)(Math.random()*600);
			// RGB
			int R = (int)(Math.random()*255);
			int G = (int)(Math.random()*255);
			int B = (int)(Math.random()*255);
			Color color = new Color(R,G,B);
			g.setColor(color);
			g.drawString("*", xx[i], yy[i]);
			
		}
	}

	@Override
	public void run() {
		while(true) {
			for (int i = 0; i < 100; i++) {
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
