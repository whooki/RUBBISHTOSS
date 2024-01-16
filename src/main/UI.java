package main;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class UI {
    FileInputStream font;
    public UI(){

        try {
            font = new FileInputStream("src/files/SAMURAI.ttf");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public Font getFont() {
        Font SAMURAI = null;
        try {
            SAMURAI = Font.createFont(Font.TRUETYPE_FONT, font).deriveFont(60f); // Set a specific size, e.g., 12f
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); // Improved error handling
        }
        return SAMURAI;
    }
    public Font getFont2() {
        Font SAMURAI = null;
        try {
            SAMURAI = Font.createFont(Font.TRUETYPE_FONT, font).deriveFont(10f); // Set a specific size, e.g., 12f
        } catch (FontFormatException | IOException e) {
            e.printStackTrace(); // Improved error handling
        }
        return SAMURAI;
    }
}
