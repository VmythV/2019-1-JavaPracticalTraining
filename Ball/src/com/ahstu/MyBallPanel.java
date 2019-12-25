package com.ahstu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyBallPanel extends JPanel implements Runnable {
	int[] xx = new int[5];
	int[] yy = new int[5];
	int[] ff = new int[5];
//	int x = 30;
//	int y = 30;
//	int f = 0;
	int score = 0;
	Color[] colors = new Color[5];
	
	public MyBallPanel(){
		for (int i = 0; i < 5; i++) {
			xx[i] = (int) (Math.random() * 800);
			yy[i] = (int) (Math.random() * 600);
			ff[i] = (int)(Math.random()*4);
			colors[i] = getColor();
		}
	}
	
	private Color getColor() {
		int R = (int)(Math.random()*255);
		int G = (int)(Math.random()*255);
		int B = (int)(Math.random()*255);
		return new Color(R,G,B);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("微软雅黑", Font.BOLD, 28));
		g.drawString("得分："+score, 100, 100);
		for (int i = 0; i < 5; i++) {
			g.setColor(colors[i]);
			g.fillOval(xx[i], yy[i], 30, 30);
		}
		
	}
	
	@Override
	public void run() {
		while(true) {
			// 1.根据飞行方向修改坐标值x,y
			for (int i = 0; i < 5; i++) {
				if(ff[i]==0) {
					xx[i]++;
					yy[i]++;
				}else if(ff[i]==1) {
					xx[i]++;
					yy[i]--;
				}else if(ff[i]==2) {
					xx[i]--;
					yy[i]--;
				}else if(ff[i]==3) {
					xx[i]--;
					yy[i]++;
				}
				// 2.根据坐标值修改飞行方向
				if(yy[i]>600-30) {
					score+=5;
					colors[i] = getColor();
					if(ff[i]==0) {
						ff[i]=1;
					}else {
						ff[i]=2;
					}
				}
				if(xx[i]>800-30) {
					score+=5;
					colors[i] = getColor();
					if(ff[i]==1) {
						ff[i]=2;
					}else {
						ff[i]=3;
					}
				}
				if(yy[i]<0) {
					score+=5;
					colors[i] = getColor();
					if(ff[i]==2) {
						ff[i]=3;
					}else {
						ff[i]=0;
					}
				}if(xx[i]<0) {
					score+=5;
					colors[i] = getColor();
					if(ff[i]==3) {
						ff[i]=0;
					}else {
						ff[i]=1;
					}
				}
			}
			
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
		
	}

}
