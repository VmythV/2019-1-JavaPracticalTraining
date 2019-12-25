package com.ahstu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Sky extends JPanel implements Runnable, MouseListener {
	private static final long serialVersionUID = 1L;
	BufferedImage backImage; // ����ͼƬ
	Ground ground = new Ground(); // ����
	Column column = new Column(350); // �ֹ�
	Column column2 = new Column(600); // �ֹ�
	static Bird bird = new Bird(); // С��
	int score = 0; // ��Ϸ�÷�
	BufferedImage startImage; // ��ʼ׼������
	boolean isStrat; // �Ƿ�ʼ��Ϸ
	BufferedImage overImage; // ��Ϸ��������
	boolean isOver; // ��Ϸ�Ƿ����

	public Sky() {
		super();
		// ��ȡͼƬ
		try {
			backImage = ImageIO.read(Sky.class.getResource("images/bg.png"));
			startImage = ImageIO.read(Sky.class.getResource("images/start.png"));
			overImage = ImageIO.read(Sky.class.getResource("images/gameover.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ���ƽ��淽��
	@Override
	public void paint(Graphics g) {
		// ������
		g.drawImage(backImage, 0, 0, null);
		// ��ȡ�µĻ��ʶ���
		Graphics2D gg = (Graphics2D) g;
		gg.rotate(-bird.ratation, bird.birdX, bird.birdY);
		// ��С��
		g.drawImage(bird.BirdImage, bird.birdX - bird.width / 2, bird.birdY - bird.height / 2, null);
		gg.rotate(bird.ratation, bird.birdX, bird.birdY);
		// ���ֹ�
		g.drawImage(column.ColumnImage, column.column_x - column.width / 2, column.column_y - column.height / 2, null);
		g.drawImage(column2.ColumnImage, column2.column_x - column2.width / 2, column2.column_y - column2.height / 2,
				null);
		// ������
		g.drawImage(ground.GroundImage, ground.ground_x, ground.ground_y, null);
		// ������
		g.setColor(Color.BLACK);
		g.setFont(new Font("΢���ź�", Font.BOLD, 30));
		g.drawString("������" + score, 150, 600);
		// ����ʼ׼��ͼƬ
		if (!isStrat && !isOver) {
			g.drawImage(startImage, 0, 0, null);
		}
		// ����������
		if (isOver) {
			g.drawImage(overImage, 0, 0, null);
		}
	}

	@Override
	public void run() {
		while (true) {
			// �ж���Ϸ�Ƿ�ʼ
			if (isStrat && !isOver) {
				ground.move();
				column.move();
				column2.move();
				bird.change();
				bird.move_go();
			}
			// �ж�ײ���ϰ�
			if (bird.birdX - bird.width / 2 == column.column_x + column.width / 2
					|| bird.birdX - bird.width / 2 == column2.column_x + column2.width / 2) {
				score++;
			}
			if (bird.hit(ground) || bird.hit(column) || bird.hit(column2)) {
				isStrat = false;
				isOver = true;
			}
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// ����Ϸ�������¿�ʼ��Ϸ,��Ϸ�ָ���ʼ״̬
		// ��δ����:�������
		if (isOver) {
			bird = new Bird();
			ground = new Ground();
			column = new Column(350);
			column2 = new Column(600);
			score = 0;
			isOver = false;
			isStrat = false;
		} else {
			bird.refly();
			isStrat = true;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
