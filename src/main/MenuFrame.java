package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MenuFrame extends JFrame implements ActionListener {

    JLabel title;
    JButton play, exit;

    private ActionEvent e;


public MenuFrame(){
    setSize(600,800);
    setResizable(false);
    setTitle("RUBBISHTOSS");
    this.setLayout(null);

    try {
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/files/background.jpg")))));
    }
    catch(Exception e) {
        e.printStackTrace();
    }

    UI ui = new UI();
    Font font = ui.getFont();
    title = new JLabel("RUBBISHTOSS");
    title.setBounds(100,100 , 400, 100);
    title.setFont(font);
    this.add(title);

    ImageIcon buttonPlay = new ImageIcon("src/files/play.png");
    play = new JButton("", buttonPlay);
    play.setBounds(120, 400 , 150, 150);
    play.setBackground(Color.WHITE);
    play.setOpaque(false);                              /** Ustawia przezroczystość */
    play.setBorderPainted(false);                       /** Usuwa Obramowanie */
    play.setContentAreaFilled(false);
    play.addActionListener(this);
    this.add(play);

    ImageIcon buttonExit = new ImageIcon("src/files/exit.png");
    exit = new JButton("", buttonExit);
    exit.setBounds(350, 400, 150, 150);
    exit.setBackground(Color.WHITE);
    exit.setOpaque(false);
    exit.setBorderPainted(false);
    exit.setContentAreaFilled(false);
    exit.addActionListener(this);
    this.add(exit);


}


    @Override
    public void actionPerformed(ActionEvent e) {

        int x = this.getLocationOnScreen().x;
        int y = this.getLocationOnScreen().y;

        if(e.getSource() == play){

            LvlFrame lvl = new LvlFrame();
            lvl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            lvl.setSize(600, 800);
            lvl.setAlwaysOnTop(true);
            lvl.pack();
            lvl.setVisible(true);
            lvl.setBounds(x, y, 600, 800);
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
