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
import java.util.TimerTask;

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
    private boolean isJumping;
    private boolean isGrounded;

    public Window() {
        x = 50;
        y = 200;
        backgroundX = 0;
        backgroundImage = new ImageIcon("BackGround Small.png").getImage();
        spriteImage = new ImageIcon("RealChar.png").getImage(); // Replace "SpriteImage.png" with your sprite image file
        spriteX = 100; // Initial X coordinate of the sprite
        spriteY = 50; // Initial Y coordinate of the sprite
        spriteVelocityY = 0; // Initial vertical velocity of the sprite
        gravity = 3;
        isJumping = false;
        isGrounded = false;

        timer = new Timer(10, this);
        timer.start();



        setFocusable(true); // Enable keyboard input
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP && isGrounded) {
                    isJumping = true;
                    jump();
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    spriteVelocityY = 5; // Move sprite down
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
                    // key();
                    spriteVelocityY = 0;
                    isJumping = false;
                }
            }
        });
    }

    public void key() {

        for (int i = 0; i < 10000; i++){
            if (i >= 10000){
                System.out.println("insideIF");
                spriteVelocityY = 0;
                isJumping = false;
            }
        }


    }

    public void jump() {
        for (int i = 0; i < 1000; i++){
            spriteVelocityY = -5;
            // System.out.println("Sprite Velocity inside for loop: " + spriteVelocityY);
        }
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

        // Is grounded
        if (spriteY >= 310){
            isGrounded = true;
        }
        else if (spriteY < 310){
            isGrounded = false;
        }
        
        // System.out.println("Sprite Velocity: " + spriteVelocityY);
        // System.out.println("(X, Y): (" + spriteX + ", " + spriteY + ")");
        if (spriteY < 310 && !isJumping){
            System.out.println("Sprite Y: " + spriteY);
            spriteVelocityY = gravity;
        }
        else if(!isJumping){
            spriteVelocityY = 0;
        }
        spriteY += spriteVelocityY;
        

        repaint();
    }
    public int applyGravity() {
        // timer.start();

        for (int i = 0; i < 10; i++){
            return gravity * i;
            // System.out.println("Sprite Velocity inside for loop: " + spriteVelocityY);
        }

        // Reset gravity after falling
        return 0;
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
