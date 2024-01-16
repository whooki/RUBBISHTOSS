package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Waste extends Entity{
    Random random = new Random();

    GamePanel gp;

    static public BufferedImage[] images= new BufferedImage[19];

    BufferedImage image;

    public Waste(){


    }


    public void setDefaultValues(){
        x = random.nextInt(500)+50;
        y = 0;
        speed = 4;
    }

    public void update(){
        y += speed;
    }

    public void draw(Graphics2D g2, String lvl){


        BufferedImage image = null;

        Random random = new Random();
        switch (lvl){
            case"plastic":
                image = images[random.nextInt(4)+15];
                break;
            case"mix":
                image = images[random.nextInt(4)+5];
                break;
            case"paper":
                image = images[random.nextInt(4)+10];
                break;
            case"glass":
                image = images[random.nextInt(4)];
                break;
        }
        g2.drawImage(image, x,y,100,200,null);

    }

}
