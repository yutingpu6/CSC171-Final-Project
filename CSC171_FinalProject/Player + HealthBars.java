import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class Player extends JComponent {
    int hp;
    boolean isAlive;
    double xPos, yPos;
    Color color;
    String name;
    double width = 60;
    double height = 120;

    public Player(int hp, boolean isAlive, double xPos, double yPos, Color color, String name) {
        this.hp = hp;
        this.isAlive = isAlive;
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.name = name;
    }

    public void attack(Player opponent) {
        if (opponent.isAlive) {
            opponent.receiveDamage(20); 
        }
    }

    public void receiveDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            isAlive = false;
        }
    }

    public void draw(Graphics g) {
        
        g.setColor(Color.RED);
        g.fillRect((int) (xPos - width / 2), (int) (yPos - height / 2), (int) width, (int) height);
       
        drawHealthBar(g);
    }


    private void drawHealthBar(Graphics g) {
        int healthBarWidth = 100;
        int healthBarHeight = 10;
       
        int healthBarX = (int) xPos - (healthBarWidth / 2); 
        int healthBarY = (int) (yPos - height / 2) - healthBarHeight - 20; 

       
        g.setColor(Color.GRAY);
        g.fillRect(healthBarX, healthBarY, healthBarWidth, healthBarHeight);
        
        
        double healthPercentage = (double) hp / 100;
        int currentHealthWidth = (int) (healthBarWidth * healthPercentage);

        g.setColor(Color.GREEN);
        g.fillRect(healthBarX, healthBarY, currentHealthWidth, healthBarHeight);

        
        g.setColor(Color.BLACK);
        g.drawRect(healthBarX, healthBarY, healthBarWidth, healthBarHeight);
    }
}
