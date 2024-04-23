import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class FightingGame extends JPanel {
    Player p1 = new Player(true, 360, 450, Color.BLUE, "src/BlueSprite1.png");
    Player2 p2 = new Player2(true, 1080, 450, Color.GREEN, "src/RedSprite1.png");
    Image background;
    Image sprite;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fighting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FightingGame game = new FightingGame();
        frame.add(game);
        frame.pack();
        game.setSize(1440, 900);
        frame.setVisible(true);
      
        frame.addKeyListener(new KeyAdapter() {
            @Override
        public void keyPressed(KeyEvent e) {
          game.keyPressed(e);
          
        }
            public void keyReleased(KeyEvent e) {
                game.keyReleased(e);
            }
       });
        
    }

    public FightingGame() {
        setPreferredSize(new Dimension(1440, 900));
        background = new ImageIcon("src/background.jpg").getImage();
        Timer timer = new Timer(10, new TimerCallback());
        timer.start();
    }
    
    protected class TimerCallback implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	if(p1.movingLeft) {
        		p1.moveLeft(10);
        	}
        	if(p1.movingRight) {
        		p1.moveRight(10);
        	}
        	if(p2.movingLeft) {
        		p2.moveLeft(10);
        	}
        	if(p2.movingRight) {
        		p2.moveRight(10);
        	}
        	if(p1.isJumping) {
        		p1.jump(10);
        	}
        	p1.detectWallCollision();
            repaint();
        }
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        g.drawImage(sprite, 0, 0,null);
        p1.draw(g);
        p2.draw(g);
        if(p1.drawArm == true)
        	p1.arm.draw(g);
        if(p2.drawArm == true)
        	p2.arm.draw(g);
        else
        	repaint();
    }
    
    private void checkGameOver() {
    	p1.checkAlive();
    	p2.checkAlive();
        if (!p1.isAlive || !p2.isAlive) {
            String winner = p1.isAlive ? "Player 1 wins!" : "Player 2 wins!";
            JOptionPane.showMessageDialog(this, winner, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
  
    public void keyPressed(KeyEvent e) {
    	switch(e.getKeyCode()) {
    	case KeyEvent.VK_W:
    		p1.isJumping = true;
    		break;
    	case KeyEvent.VK_E:
    		p1.attack(p2);
    		checkGameOver();
            break;
    	case KeyEvent.VK_U:
    		checkGameOver();
    		p2.attack(p1);
            break;
    	case KeyEvent.VK_D:
    		p1.movingRight = true;
    		break;
    	case KeyEvent.VK_A:
    		p1.movingLeft = true;
    		break;
    	case KeyEvent.VK_J:
    		p2.movingLeft = true;
    		break;
    	case KeyEvent.VK_L:
    		p2.movingRight = true;
    		break;
    	default:
    		break;
    	}
    }
    
    public void keyReleased(KeyEvent e) {
    	switch(e.getKeyCode()) {
    	case KeyEvent.VK_E:
    		p1.drawArm = false;
    		p1.lowerArm();
    		break;
    	case KeyEvent.VK_U:
    		p2.drawArm = false;
    		p2.lowerArm();
    		break;
    	case KeyEvent.VK_D:
    		p1.movingRight = false;
    		break;
    	case KeyEvent.VK_A:
    		p1.movingLeft = false;
    		break;
    	case KeyEvent.VK_J:
    		p2.movingLeft = false;
    		break;
    	case KeyEvent.VK_L:
    		p2.movingRight = false;
    		break;
    	case KeyEvent.VK_W:
    		p1.isJumping = false;
    		break;
    	default: 
    		break;
    	}
    }
    
}
