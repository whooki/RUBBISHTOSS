package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {

    public BufferedImage background,exit,pause;
    GamePanel gp;

    public Background(GamePanel gp){
        this.gp = gp;
        getBackgroundImage();
        getPauseImage();
        getExitImage();

    }

    public void getExitImage(){
        try {
            exit = ImageIO.read(getClass().getResourceAsStream("/files/exit.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getPauseImage(){
        try {
            pause = ImageIO.read(getClass().getResourceAsStream("/files/pause.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getBackgroundImage(){
        try{
            background = ImageIO.read(getClass().getResourceAsStream("/files/background.jpg"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){


        g2.drawImage(background,0,0,600,800,null);
        g2.drawImage(exit, -5, 0, 140, 140, null);
        g2.drawImage(pause, 455, 0 ,140, 140, null);

    }

}
