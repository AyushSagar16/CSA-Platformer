//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Window extends JPanel implements ActionListener {
    private Timer timer;
    private int x;
    private int y;
    private int backgroundX;
    private Image backgroundImage;
    private Image spriteImage;
    private int spriteX;
    private int spriteY;
    private int spriteVelocityY;
    private int gravity;

    public Window() {
        x = 50;
        y = 200;
        backgroundX = 0;
        backgroundImage = new ImageIcon("BackGround Small.png").getImage();
        spriteImage = new ImageIcon("RealChar.png").getImage(); // Replace "SpriteImage.png" with your sprite image file
        spriteX = 100; // Initial X coordinate of the sprite
        spriteY = 150; // Initial Y coordinate of the sprite
        spriteVelocityY = 0; // Initial vertical velocity of the sprite
        gravity = 1;

        timer = new Timer(10, this);
        timer.start();

        setFocusable(true); // Enable keyboard input
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    spriteVelocityY = -5; // Move sprite up
                    applyGravity();
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    spriteVelocityY = 5; // Move sprite down
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("OOGA BOOGA");
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
                    spriteVelocityY = 0; // Stop sprite movement when the up or down arrow key is released
                }
            }
        });
    }
        


    public void paint(Graphics g) {
        g.drawImage(getScaledImage(backgroundImage, getWidth(), getHeight()), -backgroundX, 0, null);

        // Draw the sprite
        g.drawImage(spriteImage, spriteX, spriteY, null);
    }


    
    // Setter method for Velocity
    public void setVelocityY(int newVelocity){
        spriteVelocityY = newVelocity;
    }
       
        

        

    public void actionPerformed(ActionEvent e) {
        x += 5;
        // backgroundX += 1;
        if (backgroundX >= backgroundImage.getWidth(null)) {
            backgroundX = 0;
        }

        // Update sprite position
        
        System.out.println("Sprite Velocity: " + spriteVelocityY);
        spriteY += spriteVelocityY;
        

        repaint();
    }
    public void applyGravity() {
        for (int i = 0; i < 10; i++){
            spriteVelocityY++;
        }
        // spriteVelocityY++;
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }
}
