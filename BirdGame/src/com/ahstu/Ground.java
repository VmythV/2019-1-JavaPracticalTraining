package com.ahstu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground {
    int ground_x, ground_y; // ���������
    BufferedImage GroundImage; // ����ͼƬ

    public Ground() {
        super();
        try {
            GroundImage = ImageIO.read(Sky.class.getResource("images/ground.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ground_y = 500;
    }

    // ���涯������
    public void move() {
        ground_x--;
        if (ground_x < -110) {
            ground_x = 0;
        }
    }
}