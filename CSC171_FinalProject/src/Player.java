import javax.swing.*;
import java.awt.*;

public class Player extends JComponent {
	int hp;
	boolean isAlive;
	double xPos, yPos, velocityX, velocityY; 
	int time = 10;
	Arm arm;
	boolean drawArm = false;
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
	
    public void attack1(Player opponent) {
    	arm = new Arm(xPos + 60, yPos);
        if (opponent.isAlive) {
        	arm.setxPos(xPos + width/2);
        	arm.setyPos(yPos);
        	drawArm = true;
        	if(arm.detectCollision(opponent)==true) {
        		setHp(-20);
        		if (hp <= 0) {
        			hp = 0;
        	        isAlive = false;
        	    }
        	}
        }
    }
    
    public void attack2(Player opponent) {
    	arm = new Arm(xPos - 60, yPos);
        if (opponent.isAlive) {
        	arm.setxPos(xPos - 30);
        	arm.setyPos(yPos);
        	drawArm = true;
        	if(arm.detectCollision(opponent)==true) {
        		setHp(-20);
        		if (hp <= 0) {
        			hp = 0;
        	        isAlive = false;
        	    }
        	}
        }
    }
    
    public void lowerArm() {
    	arm.setxPos(xPos);
    	arm.setyPos(yPos);
    }
    /*
    public void receiveDamage(int damage, Player other) {
    	if(arm.detectCollision(other)==true) {
    		setHp(damage);
    		if (hp <= 0) {
    			hp = 0;
    	        isAlive = false;
    	    }
    	}
    }
    */
    
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
	
	public void setAlive() {
		if (hp==0)
			isAlive = false;
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
}
