import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameMain extends JPanel implements KeyListener {


    private Sprite sprite;
    private Sprite backgroundSprite;
     

// hola
    public GameMain() {
        // Load the background image
        // backgroundImage = new ImageIcon("BackGround Small.png").getImage();

        

        backgroundSprite = new Sprite(0, 0, "background-new.jpg", 1000, 500);
        
       /*  //Platform is created 
        Platform platform = new Platform(10, 50, 100, 10);*/

        // Create the sprite
        sprite = new Sprite(50, 200, "RealChar.png",20,20);


        // Set the size of the game window
        setPreferredSize(new java.awt.Dimension(100, 100));


        // Add the key listener
        addKeyListener(this);
        setFocusable(true);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        // Draw the background image
        // g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);

        //platform is drawn
        


        // Draw the sprite
        sprite.draw(g);

        
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();


        if (keyCode == KeyEvent.VK_LEFT) {
            // Move the sprite to the left
            // sprite.move(-10, 0);
            //System.out.println("lol");
            
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            // Move the sprite to the right
            // sprite.move(10, 0);
        }


        // Repaint the panel to show the updated sprite position
        repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }


    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }


    public static void main(String[] args) {

        SplashScreen splashScreen = new SplashScreen();
        splashScreen.showSplash();
        
        // Create the game window
        JFrame frame = new JFrame("Side-Scrolling Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // Add the game panel to the window
        Window game = new Window();
        game.setVelocityY(0);
        frame.add(game);

        JPanel panel = new JPanel();
        boolean touchDoor;
        
        touchDoor = (game.getBackgroundX() <= -1400)? true : false;

        if (touchDoor) {
            JLabel congratsLabel = new JLabel("Congrats! Move to the next level.");
            System.out.print("SONEMTHIGN");
            panel.add(congratsLabel);
        }


        // Show the window
        //frame.setVisible(true);


        // Add the game panel to the window
        frame.getContentPane().add(game);


        // Pack the window
        frame.pack();


        // Center the window on the screen
        frame.setLocationRelativeTo(null);


        // Show the window
        frame.setVisible(true);

        // setSize(400,400);
        //frame.setSize(800, 600);
        // Sets window size
        frame.setSize(900, 900);

        
    }

}
