package com.ahstu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Column {
	int column_x, column_y; // �ֹܵ���������
	int width, height; // ��ȸ߶�
	int gap = 140; // �ֹܵĿ�϶
	Random random = new Random();// �������
	BufferedImage ColumnImage; // �ֹ�ͼƬ

	public Column(int x) {
		super();
		try {
			ColumnImage = ImageIO.read(Sky.class.getResource("images/column.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		column_x = x;
		column_y = random.nextInt(180) + 150;
		width = ColumnImage.getWidth();
		height = ColumnImage.getHeight();
	}


	// �ֹܶ�������
	public void move() {
		column_x--;
		if (column_x < -width / 2) {
			column_y = random.nextInt(180) + 150;
			column_x = 432 + width / 2;
		}
	}
}
