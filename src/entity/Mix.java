package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Mix extends Waste {

    BufferedImage image;

    public Mix(GamePanel gp) {
        setDefaultValues();
        addToWaste();
    }

    public void update(){
        y += speed;
    }
    public void addToWaste() {
        for (int i = 5; i < 10; i++) {
            try {
                image = ImageIO.read(new File("src/files/" + i + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            images[i] = image;
            setDefaultValues();
        }

        image = images[random.nextInt(4)];
    }
    public void draw(Graphics2D g2, String lvl){

        g2.drawImage(image, x,y,100,200,null);

    }
}
