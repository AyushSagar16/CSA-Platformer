import javax.swing.*;
import java.awt.*;

public class RectangleBox extends JPanel {
    private int width;
    private int height;
    private Color color;

    public RectangleBox(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, width, height);
    }

    
}

