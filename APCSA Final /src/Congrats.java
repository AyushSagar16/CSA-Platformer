import javax.swing.*;
import java.awt.*;

public class Congrats extends JWindow {
    private static final int DISPLAY_TIME_MS = 3000;

    public Congrats() {
        JLabel splashLabel = new JLabel(new ImageIcon("pbg.png")); // Replace "splash.png" with the path to your splash image
        // JLabel splashLabel2 = new JLabel(new ImageIcon("splash copy.png"));
        getContentPane().add(splashLabel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    public void showSplash() {
        setVisible(true);
        try {
            Thread.sleep(DISPLAY_TIME_MS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dispose();
    }

    //  Show splash screen for a longer time
    public void showSplash(int time) {
        setVisible(true);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dispose();
    }



}


