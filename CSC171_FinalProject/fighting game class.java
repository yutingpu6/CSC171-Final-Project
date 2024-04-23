import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class FightingGame extends JPanel {
    Player p1 = new Player(true, 360, 450, Color.BLUE, "src/BlueSprite1.png");
    Player2 p2 = new Player2(true, 1080, 450, Color.GREEN, "src/RedSprite1.png");
    Image background;
    Set<Integer> keysPressed = new HashSet<>();

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
                game.keysPressed.add(e.getKeyCode());
                game.handleKeyPress(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                game.keysPressed.remove(e.getKeyCode());
                game.handleKeyRelease(e);
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
            updateMovements();
            repaint();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        p1.draw(g);
        p2.draw(g);
    }

    private void updateMovements() {
        if (keysPressed.contains(KeyEvent.VK_D)) {
            p1.setVelocity(1, 0);
        } else if (keysPressed.contains(KeyEvent.VK_A)) {
            p1.setVelocity(-1, 0);
        } else {
            p1.setVelocity(0, 0);
        }

        if (keysPressed.contains(KeyEvent.VK_J)) {
            p2.setVelocity(-1, 0);
        } else if (keysPressed.contains(KeyEvent.VK_L)) {
            p2.setVelocity(1, 0);
        } else {
            p2.setVelocity(0, 0);
        }

        p1.updatePosition (8); 
        p2.updatePosition(8); 
    }

    private void handleKeyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_E:
                p1.attack(p2);
                checkGameOver();
                break;
            case KeyEvent.VK_U:
                p2.attack(p1);
                checkGameOver();
                break;
        }
    }

    private void handleKeyRelease(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_E:
                p1.drawArm = false;
                p1.lowerArm();
                break;
            case KeyEvent.VK_U:
                p2.drawArm = false;
                p2.lowerArm();
                break;
        }
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
}


