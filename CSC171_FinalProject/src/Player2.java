import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Player2 extends JComponent implements KeyListener{
	int hp = 100;
	boolean isAlive;
	double xPos, yPos, velocityX, velocityY; 
	int time = 10;
	Arm2 arm;
	boolean drawArm = false;
	Color color;
    String path;
    double width = 140;
    double height = 450;
    Image sprite;
	
    public Player2(boolean isAlive, double xPos, double yPos, Color color, String path) {
        this.isAlive = isAlive;
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.path = path;
    }
	
    
    public void attack(Player opponent) {
    	arm = new Arm2(xPos - 60, yPos);
        if (opponent.isAlive) {
        	arm.setxPos(xPos - width/2);
        	arm.setyPos(yPos-110);
        	setPath("src/RedSprite3.png");
        	//drawArm = true;
        	if(arm.detectCollision(opponent)==true) {
        		opponent.setHp(20);
        	}
        }
    }
   
    public void lowerArm() {
    	arm.setxPos(1440);
    	arm.setyPos(800);
    	setPath("src/RedSprite1.png");
    }
	
	 public void draw(Graphics g) {
		 //g.setColor(Color.RED);
		 //g.fillRect((int) (xPos - width / 2), (int) (yPos - height / 2), (int) width, (int) height);
	     sprite = new ImageIcon(path).getImage();	     
	     g.drawImage(sprite, (int)(xPos-width/2-85), (int)(yPos-height/2), null);
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

	
	public void updatePosition(double time) {
		xPos += velocityX * time;
		yPos += velocityY * time;
	}
	
	public void setVelocity(double vX, double vY) {
		this.velocityX = vX;
		this.velocityY = vY;
	}
	
	public double distance(double x, double y, double x2, double y2) {
		double xSum = (x-x2)*(x-x2);
		double ySum = (y-y2)*(y-y2);
		
		return Math.sqrt(xSum + ySum);
	}
	
	public boolean detectCollision(Player other) {
		if(distance(xPos, yPos, other.getXPos(), other.getYPos()) <= 0)
			return true;
		else
			return false;
	}
	
	public void resolveCollision(Player other) {
		if (detectCollision(other) == true)
			setVelocity(0,0);
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_L) {
    		setVelocity(1, 0);
    		updatePosition(10);
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
    		setVelocity(-1, 0);
    		updatePosition(10);
    	}
		
	}
	
	public int getHp() {
		return hp;
	}
	
	public boolean getAlive() {
		return isAlive;
	}
	
	public double getXPos() {
		return xPos; 
	}
	
	public double getYPos() {
		return yPos;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setHp(int dmg) {
		hp -= dmg;
	}
	
	public void checkAlive() {
		if (hp<=0)
			isAlive = false;
	}
	
	public void setPath(String newPath) {
		path = newPath;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
