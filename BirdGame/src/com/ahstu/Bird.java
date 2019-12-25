package com.ahstu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bird {
    int birdX = 60, birdY = 300; // 鸟的中心点坐标
    int width, height; // 鸟的宽度,高度
    double speed = 20; // 速度
    double g = 4; // 加速度
    double s; // 运动距离
    double t = 0.3; // 运动时间
    BufferedImage BirdImage; // 鸟图片
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

    // 小鸟展翅动画方法
    int index = 0;

    public void change() {
        index++;
        BirdImage = images[index / 3 % 8];
    }

    // 小鸟移动的方法
    double ratation; // 倾斜角度

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

    // 重新飞翔
    public void refly() {
        speed = 20;
    }

    // 撞击地面
    public boolean hit(Ground ground) {
        return birdY + height / 2 >= ground.ground_y;
    }

    // 撞击钢管
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
