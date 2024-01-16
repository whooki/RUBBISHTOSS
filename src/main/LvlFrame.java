package main;

import entity.Can;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class LvlFrame extends JFrame implements ActionListener {

    JLabel title;
    JButton plastic, paper, mix, glass, exit, back;

    private ActionEvent e;
    Graphics2D g2;
    GamePanel gp;
    private String btnClicked = "";

    public LvlFrame(){

        setSize(600,800);
        setResizable(false);
        setTitle("LEVELS");
        this.setLayout(null);

        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/files/background.jpg")))));
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        UI ui = new UI();
        title = new JLabel("RUBBISHTOSS");
        title.setBounds(100,100 , 400, 100);
        title.setFont(ui.getFont());
        this.add(title);

        int width = 263;
        int height = 150;
        plastic = createButton("", 30, 200, width, height,"src/files/plasticButton.png");
        this.add(plastic);

        paper = createButton("", 300, 200, width, height,"src/files/paperButton.png");
        this.add(paper);

        mix = createButton("", 30, 400, width, height,"src/files/mixButton.png");
        this.add(mix);

        glass = createButton("", 300, 400, width, height,"src/files/glassButton.png");
        this.add(glass);


        ImageIcon buttonExit = new ImageIcon("src/files/exit.png");
        exit = new JButton("", buttonExit);
        exit.setBounds(350, 605, 140, 140);
        exit.setBackground(Color.WHITE);
        exit.setOpaque(false);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(this);
        this.add(exit);

        ImageIcon buttonBack = new ImageIcon("src/files/back.png");
        back = new JButton("", buttonBack);
        back.setBounds(150, 600, 140, 140);
        back.setBackground(Color.WHITE);
        back.setOpaque(false);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.addActionListener(this);
        this.add(back);

    }

    public JButton createButton(String text, int x, int y, int w, int h,String filename){
        ImageIcon buttonPaper =  new ImageIcon(filename);
        JButton btn = new JButton(text, buttonPaper);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.CENTER);
        btn.setBounds(x, y, w, h);
        btn.setBackground(Color.WHITE);
        btn.setOpaque(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.addActionListener(this);

        return btn;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        int x = this.getLocationOnScreen().x;
        int y = this.getLocationOnScreen().y;

        if(e.getSource() == plastic || e.getSource() == paper || e.getSource() == glass || e.getSource() == mix){

            if(e.getSource() == plastic) {
                gp.lvl = "plastic";
            }
            else if (e.getSource() == paper) {
                gp.lvl = "paper";
            }
            else if (e.getSource() == glass) {
                gp.lvl = "glass";
            }
            else if (e.getSource() == mix) {
                gp.lvl = "mix";
            }


            GameFrame game = new GameFrame();
            game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            game.setSize(600, 800);
            game.setAlwaysOnTop(true);
            game.pack();
            game.setVisible(true);
            game.setBounds(x, y, 600, 800);
            this.dispose();

        }


        else if(e.getSource() == back){

            MenuFrame menu = new MenuFrame();
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setSize(600, 800);
            menu.setAlwaysOnTop(true);
            menu.pack();
            menu.setVisible(true);
            menu.setBounds(x, y, 600, 800);
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
