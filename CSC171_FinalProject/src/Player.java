// Last modified 3/28/24

import javax.swing.JComponent;


public class Player extends JComponent {
	private int hp;
	private boolean isAlive;
	private double xPos, yPos, velocityX, velocityY;
	
	public Player(int hp, boolean isAlive, double xPos, double yPos, double velocityX, double velocityY) {
		this.hp = hp;
		this.isAlive = isAlive;
		this.xPos = xPos;
		this.yPos = yPos;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
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
	
	public void setHp(int dmg) {
		hp -= dmg;
	}
	
	public void setAlive() {
		if (hp==0)
			isAlive = false;
	}
	
	// Most of this is taken from Workshop 7 code
	
	public void updatePosition(double time) {
		xPos += velocityX * time;
		yPos += velocityY * time;
	}
	
	public void setVelocity(double vX, double vY) {
		velocityX = vX;
		velocityY = vY;
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
