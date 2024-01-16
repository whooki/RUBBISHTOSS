package main;

import entity.Can;
import entity.Glass;
import entity.Waste;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {

    //SCREEN SETTINGS
    //final int originalTileSize = 16;
    final int ScreenHeight =  800;
    final int ScreenWidth = 600;

    public boolean menubool = false;
    public boolean pausebool = false;

    static String lvl;
    int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Can can = new Can(this, keyHandler);
    Waste waste = new Waste();

    static public Waste[] wastes = new Waste[4];
    Glass glass = new Glass(this);
    Background background = new Background(this);
    Random random = new Random();

    int life = 2, points = 0;

    static public BufferedImage[] wasteImages = new BufferedImage[21];




    public GamePanel(GameFrame gf) {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.setSize(ScreenWidth,ScreenHeight);

    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {
        if(!pausebool) {
        while (gameThread != null) {

            double drawInterval = 1000000000 / FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
                if(!pausebool) {
                    while (gameThread != null) {


                        currentTime = System.nanoTime();
                        delta += (currentTime - lastTime) / drawInterval;
                        lastTime = currentTime;

                        if (delta >= 1) {
                            if (!pausebool) {
                                update();
                                repaint();
                                delta--;
                            }
                        }
                    }
                }
            }
        }
    }
    public void update(){
        can.update();
        glass.update();
        waste.update();
        if(life == 0) {
        gameThread = null;
        }

    }

    public void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            background.draw(g2);
            glass.draw(g2,lvl);
            waste.draw(g2,lvl);
            can.draw(g2, lvl);
            System.out.println("The game is running");

            g2.dispose();
    }

    private void collison(int x, int y){

        if(true){

        }

    }

}

