package com.ahstu;

import javax.swing.JFrame;

public class BirdGame {
    public static void main(String[] args) {

        JFrame frame = new JFrame("BirdGame");
        
        Sky sky = new Sky();
        frame.add(sky);
        
        Thread t = new Thread(sky);
        t.start();
        
        frame.addMouseListener(sky);
        
        frame.setSize(432, 674);
        frame.setAlwaysOnTop(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
