import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class FightingGame extends JPanel {
    Player p1 = new Player(100, true, 300, 500, Color.BLUE, "src/BlueSprite1.png");
    Player p2 = new Player(100, true, 800, 500, Color.GREEN, "src/RedSprite1.png");
    Image background;
    Image sprite;
    Timer attackTimer;

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
        Timer timer = new Timer(10, e -> repaint());
        timer.start();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        g.drawImage(sprite, 0, 0,null);
        p1.draw(g);
        p2.draw(g);
        if(p1.drawArm == true)
        	p1.arm.draw1(g);
        if(p2.drawArm == true)
        	p2.arm.draw2(g);
        else
        	repaint();
    }
    
    private void checkGameOver() {
        if (!p1.isAlive || !p2.isAlive) {
            attackTimer.stop();
            String winner = p1.isAlive ? "Player 1 wins!" : "Player 2 wins!";
            JOptionPane.showMessageDialog(this, winner, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    public void keyPressed(KeyEvent e) {
    	switch(e.getKeyChar()) {
    	case 'e':
    		p1.attack1(p2);
            checkGameOver();
            break;
    	case 'u':
    		p2.attack2(p1);
            checkGameOver();
            break;
    	}
    }
    
    public void keyReleased(KeyEvent e) {
    	switch(e.getKeyChar()) {
    	case 'e':
    		p1.drawArm = false;
    		p1.lowerArm1();
    		break;
    	case 'u':
    		p2.drawArm = false;
    		p2.lowerArm2();
    	}
    }
    
}
