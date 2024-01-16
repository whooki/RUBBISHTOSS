package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class PauseFrame extends JFrame implements ActionListener {

    JLabel title;

    JButton play, exit, menu, restart;
    GameFrame gameFrame;

    public PauseFrame(GameFrame gf){
        gameFrame = gf;
        setSize(600,800);
        setResizable(false);
        setTitle("PAUSE");
        this.setLayout(null);

        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/files/background.jpg")))));
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        UI ui = new UI();
        Font font = ui.getFont();
        title = new JLabel("PAUSE");
        title.setBounds(200,100 , 400, 100);
        title.setFont(font);
        this.add(title);

        ImageIcon buttonPlay = new ImageIcon("src/files/play.png");
        play = new JButton("", buttonPlay);
        play.setBounds(300, 400 , 150, 150);
        play.setBackground(Color.WHITE);
        play.setOpaque(false);                              /** Ustawia przezroczystość */
        play.setBorderPainted(false);                       /** Usuwa Obramowanie */
        play.setContentAreaFilled(false);
        play.addActionListener(this);
        this.add(play);

        ImageIcon buttonExit = new ImageIcon("src/files/exit.png");
        exit = new JButton("", buttonExit);
        exit.setBounds(450, 400, 150, 150);
        exit.setBackground(Color.WHITE);
        exit.setOpaque(false);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(this);
        this.add(exit);

        ImageIcon buttonMenu = new ImageIcon("src/files/menu.png");
        menu = new JButton("", buttonMenu);
        menu.setBounds(0, 400, 150, 150);
        menu.setBackground(Color.WHITE);
        menu.setOpaque(false);
        menu.setBorderPainted(false);
        menu.setContentAreaFilled(false);
        menu.addActionListener(this);
        this.add(menu);

        ImageIcon buttonRestart = new ImageIcon("src/files/restart.png");
        restart = new JButton("", buttonRestart);
        restart.setBounds(150, 400, 150, 150);
        restart.setBackground(Color.WHITE);
        restart.setOpaque(false);
        restart.setBorderPainted(false);
        restart.setContentAreaFilled(false);
        restart.addActionListener(this);
        this.add(restart);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x = this.getLocationOnScreen().x;
        int y = this.getLocationOnScreen().y;

        if(e.getSource() == play){

            this.dispose();
            gameFrame.gp.pausebool = false;
//            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            gameFrame.setSize(600, 800);
            gameFrame.setVisible(true);
//            gameFrame.setAlwaysOnTop(true);


        }

        else if(e.getSource() == menu){

            gameFrame.gp.pausebool = false;
            gameFrame.dispose();
            MenuFrame frame = new MenuFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 800);
            frame.setVisible(true);
            frame.pack();
            frame.setAlwaysOnTop(true);
            frame.setLocationRelativeTo(null);
            this.dispose();
        }

        else if(e.getSource() == restart){

            gameFrame.gp.pausebool = false;
            gameFrame.dispose();
            GameFrame game = new GameFrame();
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(600, 800);
            game.setAlwaysOnTop(true);
            game.pack();
            game.setVisible(true);
            game.setBounds(x, y, 600, 800);
            this.dispose();
        }

        else if(e.getSource() == exit){
            System.exit(0);
        }
        else {
            this.dispose();
        }
    }
}
