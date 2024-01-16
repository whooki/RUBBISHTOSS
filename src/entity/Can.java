package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Can extends Entity{

    GamePanel gp;
    KeyHandler keyHandler;
    
    

    public Can(GamePanel gp, KeyHandler keyHandler){
        this.gp = gp;
        this.keyHandler = keyHandler;


        setDefaultValues();
        getCanImage();
    }

     public void getCanImage(){

        try{
            canYellow = ImageIO.read(getClass().getResourceAsStream("/files/yellow.png"));
            canBlack = ImageIO.read(getClass().getResourceAsStream("/files/black.png"));
            canGreen = ImageIO.read(getClass().getResourceAsStream("/files/green.png"));
            canBlue = ImageIO.read(getClass().getResourceAsStream("/files/blue.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

     }

    public void setDefaultValues(){
        x = 250;
        y = 550;
        speed = 9;
    }

    public void update(){

        if(keyHandler.leftPressed == true & (x -speed > -10)){
            x -= speed;
        }
        else if (keyHandler.rightPressed == true & (x + speed + 110 )< 600) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2, String lvl){


        BufferedImage image = null;

        switch (lvl){
            case"plastic":
                image = canYellow;
                break;
            case"mix":
                image = canBlack;
                break;
            case"paper":
                image = canBlue;
                break;
            case"glass":
                image = canGreen;
                break;
        }


        g2.drawImage(image, x,y,100,200,null);

    }

}
