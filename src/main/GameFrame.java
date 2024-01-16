package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    GamePanel gp;

    JButton exit, pause;
    private ActionEvent e;

    public GameFrame() {

        setTitle("GAME");

        this.gp = new GamePanel(this);
        this.setSize(600, 800);
        this.add(gp, BorderLayout.CENTER);
        gp.startGameThread();


        exit = new JButton("", null);
        exit.setBounds(0, 0, 140, 140);
        exit.setBackground(Color.WHITE);
        exit.setOpaque(false);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.addActionListener(this);
        this.add(exit);

        pause = new JButton("", null);
        pause.setBounds(455, 0, 140, 140);
        pause.setBackground(Color.WHITE);
        pause.setOpaque(false);
        pause.setBorderPainted(false);
        pause.setContentAreaFilled(false);
        pause.addActionListener(this);
        this.add(pause);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int x = this.getLocationOnScreen().x;
        int y = this.getLocationOnScreen().y;

        if (e.getSource() == pause) {

            gp.pausebool = true;
            PauseFrame pauseFrame = new PauseFrame(this);
            pauseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pauseFrame.setSize(600, 800);
            pauseFrame.setAlwaysOnTop(true);
            pauseFrame.pack();
            pauseFrame.setVisible(true);
            pauseFrame.setBounds(x, y, 600, 800);
            this.setVisible(false);
        }
        else if (e.getSource() == exit) {
            //kiedy klikam gdziekolwiek na ekran exit(0)
            System.exit(0);
        }

        else {
            this.dispose();
        }
    }
}
