import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;


public class GameBackground extends JPanel {
    private Image backgroundImage;
    private int xCoordinate;


    public GameBackground(String imagePath) {
        try {
            backgroundImage = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.xCoordinate = 0;
    }


    public void update() {
        // Update the background position
        xCoordinate -= 1;


        // Wrap the background image if it reaches the end
        if (xCoordinate <= -backgroundImage.getWidth(this)) {
            xCoordinate = 0;
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        // Draw the background image
        g.drawImage(backgroundImage, xCoordinate, 0, null);


        // Draw the background image again to fill the gap
        if (xCoordinate < 0) {
            g.drawImage(backgroundImage, xCoordinate + backgroundImage.getWidth(this), 0, null);
        }
    }
}



