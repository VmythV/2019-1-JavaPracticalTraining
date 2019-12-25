package com.ahstu;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 1.绘制背景图
 * 
 * @author
 *
 */

public class NexonPanel extends JPanel implements Runnable, MouseListener, KeyListener {
	/** 第一区域:变量声明初始化区域 */
	// 1.1 背景图 静态的 永存的
	static BufferedImage back;
	int[][] floorMap = { { 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0 }, };

	int[][] buildMap = { { 7, 2, 1, 2, 1, 0, 7, 7, 6, 0, 4, 1, 4, 7, 4 },
			{ 7, 3, 6, 3, 6, 0, 6, 7, 7, 0, 1, 2, 7, 7, 7 }, { 7, 7, 2, 1, 2, 0, 7, 6, 6, 0, 4, 6, 4, 6, 4 },
			{ 6, 4, 6, 4, 6, 0, 6, 7, 7, 0, 2, 1, 2, 1, 2 }, { 1, 2, 1, 2, 1, 0, 7, 7, 6, 0, 4, 6, 4, 6, 4 },
			{ 2, 3, 2, 3, 2, 3, 6, 6, 7, 7, 1, 2, 1, 2, 1 }, { 0, 0, 0, 0, 0, 0, 7, 7, 6, 0, 0, 0, 0, 0, 0 },
			{ 1, 2, 1, 2, 1, 7, 6, 7, 7, 0, 1, 3, 1, 3, 7 }, { 5, 6, 5, 6, 5, 0, 7, 6, 6, 0, 2, 1, 2, 7, 7 },
			{ 2, 1, 2, 1, 2, 0, 6, 7, 7, 0, 6, 3, 6, 3, 7 }, { 5, 7, 5, 6, 5, 0, 7, 7, 6, 0, 1, 2, 1, 2, 7 },
			{ 7, 7, 1, 2, 1, 0, 6, 6, 7, 0, 6, 3, 7, 3, 7 }, { 5, 7, 5, 1, 5, 0, 7, 7, 6, 0, 2, 7, 7, 7, 7 } };

	static BufferedImage diban1;
	static BufferedImage diban3;
	static BufferedImage diban4;
	static BufferedImage shu;
	static BufferedImage red;
	static BufferedImage orange;
	static BufferedImage redHouse;
	static BufferedImage yellowHouse;
	static BufferedImage blueHouse;
	static BufferedImage box;

	static BufferedImage up;
	static BufferedImage down;
	static BufferedImage left;
	static BufferedImage right;

	Bao bao = new Bao();

	/** 第二区域:静态变量初始化区域 */
	static {
		try {
			// /
			back = ImageIO.read(NexonPanel.class.getResource("img/zhan2.jpg"));
			diban1 = ImageIO.read(NexonPanel.class.getResource("img/diban1.png"));
			diban3 = ImageIO.read(NexonPanel.class.getResource("img/diban3.png"));
			diban4 = ImageIO.read(NexonPanel.class.getResource("img/diban4.png"));
			shu = ImageIO.read(NexonPanel.class.getResource("img/shu.png"));
			red = ImageIO.read(NexonPanel.class.getResource("img/red.png"));
			orange = ImageIO.read(NexonPanel.class.getResource("img/orange.png"));
			redHouse = ImageIO.read(NexonPanel.class.getResource("img/redHouse.png"));
			yellowHouse = ImageIO.read(NexonPanel.class.getResource("img/yellowHouse.png"));
			blueHouse = ImageIO.read(NexonPanel.class.getResource("img/blueHouse.png"));
			box = ImageIO.read(NexonPanel.class.getResource("img/box.png"));

			up = ImageIO.read(NexonPanel.class.getResource("img/up.png"));
			down = ImageIO.read(NexonPanel.class.getResource("img/down.png"));
			left = ImageIO.read(NexonPanel.class.getResource("img/left.png"));
			right = ImageIO.read(NexonPanel.class.getResource("img/right.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	/** 第三区域:绘制函数区域 */
	public void paint(Graphics g) {
		super.paint(g);
		// 3.1 绘制背景图
		paintBack(g);
		paintFloor(g);
		paintBuild(g);
		paintBao(g);
	}

	private void paintBuild(Graphics g) {
		for (int i = 0; i < buildMap.length; i++) {
			for (int j = 0; j < buildMap[0].length; j++) {
				int type = buildMap[i][j];
				int fX = 25 + 50 * j;
				int fY = 25 + 50 * i;

				if (type == 0) {
					g.drawImage(shu, fX, fY, 50, 50, null);
				} else if (type == 1) {
					g.drawImage(red, fX, fY, 50, 50, null);
				} else if (type == 2) {
					g.drawImage(orange, fX, fY, 50, 50, null);
				} else if (type == 3) {
					g.drawImage(redHouse, fX, fY, 50, 50, null);
				} else if (type == 4) {
					g.drawImage(yellowHouse, fX, fY, 50, 50, null);
				} else if (type == 5) {
					g.drawImage(blueHouse, fX, fY, 50, 50, null);
				} else if (type == 6) {
					g.drawImage(box, fX, fY, 50, 50, null);
				}
			}
		}
	}

	private void paintFloor(Graphics g) {
		for (int i = 0; i < floorMap.length; i++) {
			for (int j = 0; j < floorMap[0].length; j++) {
				int type = floorMap[i][j];
				int fX = 25 + 50 * j;
				int fY = 25 + 50 * i;

				if (type == 0) {
					g.drawImage(diban1, fX, fY, 50, 50, null);
				} else if (type == 1) {
					g.drawImage(diban3, fX, fY, 50, 50, null);
				} else if (type == 2) {
					g.drawImage(diban4, fX, fY, 50, 50, null);
				}
			}
		}
	}

	// 3.1 绘制背景图
	public void paintBack(Graphics g) {
		// null默认绘制当前画布对象上
		g.drawImage(back, 0, 0, 925, 700, null);
	}

	private void paintBao(Graphics g) {
		g.drawImage(bao.image, bao.col * 50 + 25, bao.row * 50 + 25, bao.width, bao.height, null);
	}

	/** 第四区域:业务处理函数区域 */
	@Override
	public void run() {
		while (true) {
			// 1.修改坐标值

			// 2.调用睡眠方法
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 3.调用重绘方法
			repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		if (mouseX > 875 && mouseX < 910 && mouseY > 15 && mouseY < 15 + 24) {
			System.exit(0);
		}
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

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			bao.image = NexonPanel.up;
			bao.row--;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			bao.image = NexonPanel.down;
			bao.row++;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			bao.image = NexonPanel.left;
			bao.col--;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			bao.image = NexonPanel.right;
			bao.col++;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
