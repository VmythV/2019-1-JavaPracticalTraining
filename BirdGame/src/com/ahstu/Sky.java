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
	BufferedImage backImage; // 背景图片
	Ground ground = new Ground(); // 地面
	Column column = new Column(350); // 钢管
	Column column2 = new Column(600); // 钢管
	static Bird bird = new Bird(); // 小鸟
	int score = 0; // 游戏得分
	BufferedImage startImage; // 开始准备界面
	boolean isStrat; // 是否开始游戏
	BufferedImage overImage; // 游戏结束界面
	boolean isOver; // 游戏是否结束

	public Sky() {
		super();
		// 读取图片
		try {
			backImage = ImageIO.read(Sky.class.getResource("images/bg.png"));
			startImage = ImageIO.read(Sky.class.getResource("images/start.png"));
			overImage = ImageIO.read(Sky.class.getResource("images/gameover.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 绘制界面方法
	@Override
	public void paint(Graphics g) {
		// 画背景
		g.drawImage(backImage, 0, 0, null);
		// 获取新的画笔对象
		Graphics2D gg = (Graphics2D) g;
		gg.rotate(-bird.ratation, bird.birdX, bird.birdY);
		// 画小鸟
		g.drawImage(bird.BirdImage, bird.birdX - bird.width / 2, bird.birdY - bird.height / 2, null);
		gg.rotate(bird.ratation, bird.birdX, bird.birdY);
		// 画钢管
		g.drawImage(column.ColumnImage, column.column_x - column.width / 2, column.column_y - column.height / 2, null);
		g.drawImage(column2.ColumnImage, column2.column_x - column2.width / 2, column2.column_y - column2.height / 2,
				null);
		// 画地面
		g.drawImage(ground.GroundImage, ground.ground_x, ground.ground_y, null);
		// 画文字
		g.setColor(Color.BLACK);
		g.setFont(new Font("微软雅黑", Font.BOLD, 30));
		g.drawString("分数：" + score, 150, 600);
		// 画开始准备图片
		if (!isStrat && !isOver) {
			g.drawImage(startImage, 0, 0, null);
		}
		// 画结束界面
		if (isOver) {
			g.drawImage(overImage, 0, 0, null);
		}
	}

	@Override
	public void run() {
		while (true) {
			// 判断游戏是否开始
			if (isStrat && !isOver) {
				ground.move();
				column.move();
				column2.move();
				bird.change();
				bird.move_go();
			}
			// 判断撞击障碍
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
		// 若游戏结束重新开始游戏,游戏恢复初始状态
		// 若未结束:鸟飞起来
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
