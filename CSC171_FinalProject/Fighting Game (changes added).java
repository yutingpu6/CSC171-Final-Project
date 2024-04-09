import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class FightingGame extends JPanel {
    Player p1 = new Player(100, true, 300, 300, Color.BLUE, "Player 1");
    Player p2 = new Player(100, true, 800, 300, Color.GREEN, "Player 2");
    Timer attackTimer;
    Random rand = new Random();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fighting Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FightingGame game = new FightingGame();
        frame.add(game);
        frame.pack();
        frame.setSize(1440, 900);
        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                game.keyPressed(e);
            }
        });
    }

    public FightingGame() {
        setPreferredSize(new Dimension(1440, 900));
        Timer timer = new Timer(10, e -> repaint());
        timer.start();
        startComputerAttacks();
    }

    private void startComputerAttacks() {
        attackTimer = new Timer(1000, e -> {
        		// attack every 1 second
            if(rand.nextBoolean()) {
                p2.attack(p1);
                checkGameOver();
            }
        });
        attackTimer.start();
    }

    private void checkGameOver() {
        if (!p1.isAlive || !p2.isAlive) {
            attackTimer.stop();
            String winner = p1.isAlive ? "Player 1 wins!" : "Player 2 wins!";
            JOptionPane.showMessageDialog(this, winner, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        p1.draw(g);
        p2.draw(g);
    }

    public void keyPressed(KeyEvent e) {
    		//space bar attack
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            p1.attack(p2);
            checkGameOver();
        }
    }
}