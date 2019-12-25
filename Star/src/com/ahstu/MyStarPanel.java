package com.ahstu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * ������
 * ����˼ά�߼�
 * �ٶ����
 * @author Administrator
 *
 */
public class MyStarPanel extends JPanel implements Runnable{
	// ������������ֵ
	int[] xx = new int[100];
	int[] yy = new int[100];

	// ���췽�� /���� ������������������ͬ
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
		// 1.���ñ�����ɫ
		this.setBackground(Color.BLACK);
		// 2.���ø�ʽ��С
		Font font = new Font("΢���ź�",Font.BOLD,28);
		g.setFont(font);
		// 3.���û�����ɫ
		
		//����
		g.setColor(Color.WHITE);
		g.fillOval(100, 100, 100, 100);
		
		//��ȱ
		g.setColor(Color.BLACK);
		g.fillOval(moonx, moony, 100, 100);
		moonx++;
		moony++;
		// 4.��������
		for(int i = 0;i < 100;i++) {
			// �����������
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
