import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {
    private static final int SPLASH_WIDTH = 400;
    private static final int SPLASH_HEIGHT = 300;
    private static final int DISPLAY_TIME_MS = 5000;

    public SplashScreen() {
        JLabel splashLabel = new JLabel(new ImageIcon("new-splash-resize.png")); // Replace "splash.png" with the path to your splash image
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

}
