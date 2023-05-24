import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;



public class Sprite {
   private int x;
   private int y;
   private int width;
   private int height;
   private Image image;
   private Image newImage;
   private Rectangle bounds; 



   public Sprite(int x, int y, String imagePath, int width, int height) {
       this.x = x;
       this.y = y;
       ImageIcon icon = new ImageIcon(imagePath);
       this.image = icon.getImage();
       newImage = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
       this.width = newImage.getWidth(null);
       this.height = newImage.getHeight(null);
       bounds = new Rectangle(x, y, width, height);
   }


// upadating the x and y cords as the sprite moves
   public void move(int dx, int dy) {
       x += dx;
       y += dy;
   }




   public void draw(Graphics g) {
       g.drawImage(newImage, x, y, null);
   }




   // Getters and setters for the sprite properties
   public int getX() {
       return bounds.x;
   }




   public int getY() {
       return bounds.y;
   }




   public int getWidth() {
       return bounds.width;
   }




   public int getHeight() {
       return bounds.height;
   }




   public Image getImage() {
       return newImage;
   }




   public void setX(int x) {
       this.x = x;
   }




   public void setY(int y) {
       this.y = y;
   }




   public void setWidth(int width) {
       bounds.width = width;
   }




   public void setHeight(int height) {
       bounds.height = height;
   }




   public void setImage(Image image) {
       this.newImage = newImage;
   }

   // Collision detection method
   public boolean collidesWith(Rectangle other) {
    return bounds.intersects(other);
}
}


