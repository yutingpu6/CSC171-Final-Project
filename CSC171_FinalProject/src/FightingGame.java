import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class FightingGame extends JPanel implements KeyListener{
	Player p1 = new Player(100, true, 300, 300);
    Player p2 = new Player(100, true, 800, 300);
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fighting Game");
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.add(new FightingGame());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setSize(1440, 900);
	    frame.setVisible(true);
	    frame.addKeyListener(null);
	    
	    //Image imageP1 = new ImageIcon("path name").getImage();
	    //Image imageP2 = new ImageIcon("path name").getImage();
	}
	
	public FightingGame(){
		setPreferredSize(new Dimension(1440, 900));
		
	    p1.setVelocity(0, 0);
	    p2.setVelocity(0, 0);
	    add(p1, p2);
	   
	    Timer timer = new Timer(10, new TimerCallback());
	    timer.start();
	}
	
	 protected class TimerCallback implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 repaint();
	     }
	 }
	 
	 
	 @Override
	  protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	        p1.detectCollision(p2);
	        p2.detectCollision(p1);
	        p1.updatePosition(p1.getTime());
	        p1.updatePosition(p2.getTime());
	        p1.draw(g);
	        p2.draw(g);
	    }

	 @Override
	 public void keyTyped(KeyEvent e) {
		 
	 }
	 
	 @Override
	 public void keyPressed(KeyEvent e) {
		 
	 }
	 
	 @Override
	 public void keyReleased(KeyEvent e) {
		 
	 }
	 
}
