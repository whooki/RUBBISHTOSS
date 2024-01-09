package main;

import entity.Can;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    //final int originalTileSize = 16;
    final int ScreenHeight =  800;
    final int ScreenWidth = 600;

    int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Can can = new Can(this, keyHandler);
    Background background = new Background(this);


    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        while (gameThread != null) {

            System.out.println("The game is running");

            double drawInterval = 1000000000 / FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;

            while (gameThread != null) {

                currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval ;
                lastTime = currentTime;

                if(delta >= 1){
                    update();
                    repaint();
                    delta -- ;
                }
            }
        }
    }
    public void update(){
        can.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        background.draw(g2);
        can.draw(g2);

        g2.dispose();
    }

}

