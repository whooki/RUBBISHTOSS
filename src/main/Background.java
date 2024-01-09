package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {

    public BufferedImage background;
    GamePanel gp;

    public Background(GamePanel gp){
        this.gp = gp;
        getBackgroundImage();
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
    }

}
