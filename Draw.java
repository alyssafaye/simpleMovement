import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

  public class Draw extends JComponent{
     private BufferedImage image;
     private BufferedImage backgroundPic;
     private URL resource = getClass().getResource("run0.png");
     private URL backgroundresource = getClass().getResource("background.jpg");


       public int x = 30;
       public int y = 250;
       public int state = 0;

     public Draw(){
         try{
             image = ImageIO.read(resource);
             backgroundPic = ImageIO.read(backgroundresource);
            }
             catch(IOException e){
             e.printStackTrace();
         }
     }
     public void reloadImage(){
         state++;
         if(state == 0) {
             resource = getClass().getResource("run0.png");
         }
         else if(state == 1) {
             resource = getClass().getResource("run1.png");
         }
         else if(state == 2) {
             resource = getClass().getResource("run2.png");
         }
         else if(state == 3) {
             resource = getClass().getResource("run3.png");
         }
         else if(state == 4) {
             resource = getClass().getResource("run4.png");
         }
         else if(state == 5) {
             resource = getClass().getResource("run5.png");
             state = 0;
         }
             try{
             image = ImageIO.read(resource);
            // backgroundPic = ImageIO.read(getClass().getResource("background.jpg"));
         }
             catch(IOException e){
             e.printStackTrace();
         }
     }

     public void jumpAnimation(){
    Thread thread1 = new Thread(new Runnable(){
      public void run(){
        for(int ctr = 0; ctr < 3; ctr++){
          try {
            if(ctr==4){
              resource = getClass().getResource("jump0.png");
            }
            else{
              resource = getClass().getResource("jump"+ctr+".png");
            }
            
            try{
              image = ImageIO.read(resource);
            }
            catch(IOException e){
              e.printStackTrace();
            }
                repaint();
                Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    thread1.start();
    }
        public void jump(){
        jumpAnimation();
       }
       public void moveUp(){
       y = y - 20;
       reloadImage();
       repaint();
       }

       public void moveDown(){
       y = y + 20;
       reloadImage();
       repaint();
       }

       public void moveLeft(){
       x = x - 20;
       reloadImage();
       repaint();
       }

       public void moveRight(){
       x = x + 20;
       reloadImage();
       repaint();
       }

       public void paintComponent(Graphics g){
       super.paintComponent(g);
       g.setColor(Color.GREEN);
       g.drawImage(backgroundPic, 0, 0, this);
       g.drawImage(image, x, y, this);

       }
  }
