import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JPanel; 

public class RectangleBox extends JPanel {

	public void screen()  {
		repaint();
	}

	public void paint(Graphics g) {
		g.setColor(new Color(100, 50, 150));
		g.drawRect(100, 100, 50, 50);
		g.setColor(Color.GREEN);
		g.fillRect(200, 200, 50, 50);

	}

}
