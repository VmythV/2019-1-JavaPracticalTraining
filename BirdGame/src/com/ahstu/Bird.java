package com.ahstu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird {
    int birdX = 60, birdY = 300; // ������ĵ�����
    int width, height; // ��Ŀ��,�߶�
    double speed = 20; // �ٶ�
    double g = 4; // ���ٶ�
    double s; // �˶�����
    double t = 0.3; // �˶�ʱ��
    BufferedImage BirdImage; // ��ͼƬ
    BufferedImage[] images = new BufferedImage[8];
    int bird_icon = 0;

    public Bird() {
        super();
        for (int i = 0; i < images.length; i++) {
            try {
                images[i] =ImageIO.read(Sky.class.getResource("images/" + i + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BirdImage = images[0];
        width = BirdImage.getWidth();
        height = BirdImage.getHeight();
    }

    // С��չ�ᶯ������
    int index = 0;

    public void change() {
        index++;
        BirdImage = images[index / 3 % 8];
    }

    // С���ƶ��ķ���
    double ratation; // ��б�Ƕ�

    public void move_go() {
        double v0 = speed;
        s = v0 * t - 0.5 * g * t * t;
        double vt = v0 - g * t;
        speed = vt;
        birdY = birdY - (int) s;
        ratation = s / 16;
        if (birdY <= height / 2) {
            birdY = height / 2;
        }
    }

    // ���·���
    public void refly() {
        speed = 20;
    }

    // ײ������
    public boolean hit(Ground ground) {
        return birdY + height / 2 >= ground.ground_y;
    }

    // ײ���ֹ�
    public boolean hit(Column column) {
        int left_x = column.column_x - column.width / 2 - width / 2;
        int right_x = column.column_x + column.width / 2 + width / 2;
        int top_y = column.column_y - column.gap / 2 + height / 2 - 5;
        int down_y = column.column_y + column.gap / 2 - height / 2 + 5;
        if (birdX > left_x && birdX < right_x) {
            if (birdY > top_y && birdY < down_y) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
