package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
//        GameFrame gf = new GameFrame();
//        JFrame window = new JFrame();
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setResizable(false);
//        window.setTitle("RUBBISHTOSS");
//
//        GamePanel gamePanel = new GamePanel(gf);
//        window.add(gamePanel);
//
//        window.pack();
//
//        window.setLocationRelativeTo(null);
//        window.setVisible(true);
//
//        gamePanel.startGameThread();



        MenuFrame frame = new MenuFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);

    }
}
