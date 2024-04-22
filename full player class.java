import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends JComponent implements KeyListener {
    int hp = 6; // 
    boolean isAlive;
    double xPos, yPos, velocityX, velocityY;
    Color color;
    String spritePath;
    double width = 140;
    double height = 450;
    Image sprite;
    Image fullHeart;
    Image halfHeart;
    Image emptyHeart;

    public Player(double xPos, double yPos, Color color, String spritePath) {
        this.hp = 6; 
        this.isAlive = true;
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.spritePath = spritePath;
        this.sprite = new ImageIcon(spritePath).getImage();
        this.fullHeart = new ImageIcon("src/pixil-frame-0.png").getImage();
        this.halfHeart = new ImageIcon("src/pixil-frame-0 (1).png").getImage();
        this.emptyHeart = new ImageIcon("src/pixil-frame-0 (2).png").getImage();
        addKeyListener(this);
        setFocusable(true);
    }

  

    private void drawHealthBar(Graphics g) {
        int heartWidth = 80;
        int heartHeight = 80;
        int heartXOffset = (heartWidth + 10) * 3 / 2;
        int heartX = (int) (xPos - heartXOffset / 2);
        int heartY = (int) (yPos - height) + 100;

        for (int i = 0; i < 3; i++) {
            Image heartImage = emptyHeart;
            if (hp > (i * 2) + 1) {
                heartImage = fullHeart;
            } else if (hp > i * 2) {
                heartImage = halfHeart;
            }
          
            g.drawImage(heartImage, heartX + (i * (heartWidth + 10)), heartY, heartWidth, heartHeight, null);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(sprite, (int) (xPos - width / 2), (int) (yPos - height / 2), null);
        drawHealthBar(g);
    }

}
