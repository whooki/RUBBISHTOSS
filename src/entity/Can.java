package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
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
        x = 200;
        y = 600;
        speed = 9;
    }

    public void update(){

        if(keyHandler.leftPressed == true){
            x -= speed;
        } else if (keyHandler.rightPressed == true) {
            x += speed;
        }
    }

    public void draw(Graphics2D g2){
//dopisac dla roznych poziomow rozny kolor smietnika

//        BufferedImage image = null;
//
//        switch (lvl){
//            case"plastic":
//                BufferedImage image = canYellow;
//                break;
//            case"mix":
//                BufferedImage image = canBlack;
//                break;
//            case"paper":
//                BufferedImage image = canBlue;
//                break;
//            case"glass":
//                BufferedImage image = canGreen;
//                break;
//        }

        BufferedImage image = canYellow;
        g2.drawImage(image, x,y,100,200,null);

    }

}
