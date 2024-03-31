import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;


public class Player extends JComponent {
	int hp;
	boolean isAlive;
	double xPos, yPos, velocityX, velocityY; 
	int time = 10;
	double length = 100;
	double height = 300;
	
	public Player(int hp, boolean isAlive, double xPos, double yPos) {
		this.hp = hp;
		this.isAlive = isAlive;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public int getHp() {
		return hp;
	}
	
	public boolean getAlive() {
		return isAlive;
	}
	
	public double getXPos() {
		return xPos; // Don't wanna interfere with JComponent existing
					// method getX(), so I named the variables xPos and yPos
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
	
	// Most of this is taken from Workshop 7 code
	
	 public void draw(Graphics g) {
		 	g.setColor(Color.RED);
		 	// Too big rn
	        g.drawRect((int) (xPos-(length/2)), (int) (yPos - (height/2)), (int) (xPos + (length/2)), (int) (yPos + (height/2)));
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
	
	// Do what on collision? Probably not bounce, maybe just stop in place?
	// Is that like setting velocity to 0?
	
	public void resolveCollision(Player other) {
		if (detectCollision(other) == true)
			setVelocity(0,0);
	}
}
