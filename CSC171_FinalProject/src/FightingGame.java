import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FightingGame extends JPanel{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fighting Game");
		 frame.add(new FightingGame());
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.pack();
	     frame.setSize(1000, 800);
	     frame.setVisible(true);
	     
	     Player p1 = new Player(100, true, 100, 300);
	     Player p2 = new Player(100, true, 900, 300);
	     frame.add(p1, p2);
	   
	     //Timer timer = new Timer(10, new TimerCallback());
	     //timer.start();
	}
	
	 protected class TimerCallback implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			 repaint();
	     }
	 }
	 
	 /*
	 @Override
	  protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	        p1.detectCollision(p2);
	        p2.detectCollision(p1);
	        p1.updatePosition(time);
	        p2.updatePosition(time);
	        p1.draw(g);
	        p2.draw(g);
	    }
	   */

}
