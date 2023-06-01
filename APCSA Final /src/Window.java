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
    private int playerSpriteVelocityY;
    private int backgroundSpriteVelocityX;
    private int gravity;
    private boolean isJumping;
    private boolean isGrounded;
    private int groundY;
    private boolean touchDoor;

    private JPanel panel;

    public Window() {
        x = 50;
        y = 200;
        backgroundX = 0;
        backgroundImage = new ImageIcon("background-pixel.png").getImage();
        spriteImage = new ImageIcon("spongebob.png").getImage(); // Replace "SpriteImage.png" with your sprite image file
        spriteX = 100; // Initial X coordinate of the sprite
        spriteY = 50; // Initial Y coordinate of the sprite
        playerSpriteVelocityY = 0; // Initial vertical velocity of the sprite
        backgroundSpriteVelocityX = 0; // Initial horizontal velocity of the background
        gravity = 3;
        isJumping = false;
        isGrounded = false;
        groundY = 600;
        panel = new JPanel();
        touchDoor = false;


        // Check the value of the boolean variable


        

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
                    playerSpriteVelocityY = 5; // Move sprite down
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    backgroundSpriteVelocityX = 15; // Move background to the left
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    backgroundSpriteVelocityX = -15; // Move background to the right
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
                    // key();
                    playerSpriteVelocityY = 0;
                    isJumping = false;
                } else if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
                    backgroundSpriteVelocityX = 0;
                }
            }
        });
    }

    public void key() {

        for (int i = 0; i < 10000; i++){
            if (i >= 10000){
                playerSpriteVelocityY = 0;
                isJumping = false;
            }
        }


    }
    // Arrays here
    // Search Algo ;(
    public int runBinarySearchIteratively(
    int[] sortedArray, int key, int low, int high) {
    int index = Integer.MAX_VALUE;
    
    while (low <= high) {
        int mid = low  + ((high - low) / 2);
        if (sortedArray[mid] < key) {
            low = mid + 1;
        } else if (sortedArray[mid] > key) {
            high = mid - 1;
        } else if (sortedArray[mid] == key) {
            index = mid;
            break;
        }
    }
    return index;
    }
    
    int[] randomArray = {1, 3, 4, 5, 6, 7, 8, 9};

    int randomNum = runBinarySearchIteratively(randomArray, 8, 0, randomArray.length - 1);
    // Arrays end here
    // RECURSION HERE
    ArrayList<Integer> scoreList = new ArrayList<Integer>();
    scoreList.add(randomNum);


    public int score = 0;
    public int scoreMultiplier = randomNum;

    public void score() {
        if (score >= 100){
            System.out.println("You win! GO TO THE DOOR!");
            System.out.println("Your final score array is " + scoreList);
        }
        else {
            score *= randomNum;
            scoreList.add(score);
            System.out.println("Your Score is" + score);
            score();
        }
    }
// Recursion ends here

    public void jump() {
        for (int i = 0; i < 1000; i++){
            playerSpriteVelocityY = -5;
            // System.out.println("Sprite Velocity inside for loop: " + spriteVelocityY);
        }
    }
        


    public void paint(Graphics g) {
        g.drawImage(getScaledImage(backgroundImage, getWidth() + 1000, getHeight()), backgroundX, 0, null);

        // Draw the sprite
        g.drawImage(getScaledImage(spriteImage, 100, 95), spriteX, spriteY, null);
    }


    
    // Setter method for Velocity
    public void setVelocityY(int newVelocity){
        playerSpriteVelocityY = newVelocity;
    }
       
        

        
    // We set all the movement here
    public void actionPerformed(ActionEvent e) {
        x += 5;
        // backgroundX += 1;
        if (backgroundX >= backgroundImage.getWidth(null)) {
            backgroundX = 0;
        }

        // Update sprite position

        // Is grounded
        if (spriteY >= groundY){
            isGrounded = true;
        }
        else if (spriteY < groundY){
            isGrounded = false;
        }
        
        // System.out.println("Sprite Velocity: " + spriteVelocityY);
        // System.out.println("(X, Y): (" + spriteX + ", " + spriteY + ")");
        if (spriteY < groundY && !isJumping){
            System.out.println("Sprite Y: " + spriteY);
            playerSpriteVelocityY = gravity;
        }
        else if(!isJumping){
            playerSpriteVelocityY = 0;
        }
        spriteY += playerSpriteVelocityY;

        // Print out the background x position
        System.out.println("Background X: " + backgroundX);

        touchDoor = (backgroundX <= -1400) ? true : false;

        Congrats screen = new Congrats();

        int randoahsdfhalsdjflasdf = 0;
        if (touchDoor && randoahsdfhalsdjflasdf <= 0) {
            randoahsdfhalsdjflasdf++;
            System.out.println("CONGRATS YOU WON! You may now close the window. ");
            // screen.showSplash(10000);
            
        }

        // Update background position
        backgroundX += backgroundSpriteVelocityX;
        
        // Add recursive method
        score();

        repaint();
    }

    public boolean won() {
        return touchDoor;
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

    public int getBackgroundX() {
        return backgroundX;
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
