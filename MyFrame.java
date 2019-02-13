import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener{

    Draw drawing;

    public MyFrame(){
        this.drawing = new Draw();
    }

    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_UP){
            drawing.moveUp();
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            drawing.moveRight();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            drawing.moveDown();
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            drawing.moveLeft();
        }
        else if(e.getKeyCode() == KeyEvent.VK_S){
            drawing.attack();
        }
        else if(e.getKeyCode() == KeyEvent.VK_A){
            drawing.jump();
        }
         else if(e.getKeyCode() == KeyEvent.VK_D){
            drawing.crouch();
        }
        else if(e.getKeyCode() == KeyEvent.VK_W){
            drawing.smrslt();
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            drawing.spawnEnemy();
        }
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){
        
    }

    public static void main(String args[]){
        MyFrame gameFrame = new MyFrame();
        gameFrame.setSize(670,380);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.getContentPane().add(gameFrame.drawing);
        gameFrame.addKeyListener(gameFrame);
    }
}