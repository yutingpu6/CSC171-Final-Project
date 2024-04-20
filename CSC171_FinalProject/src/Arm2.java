import java.awt.Color;
import java.awt.Graphics;

public class Arm2{
	double xPos, yPos;
	double width = 70;
	double height = 35;
	
	
	public Arm2(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public boolean detectCollision(Player other) {
		double xEdge = other.getXPos()+60;
		double x = xPos - width;
		if(x-xEdge<=0) {
			if(other.getYPos()-195<=yPos || yPos<=other.getYPos()+195) {
				return true;
			}
		}
		return false;
	}
	
	public double distance(double x, double y, double x2, double y2) {
		double xSum = (x-x2)*(x-x2);
		double ySum = (y-y2)*(y-y2);
		
		return Math.sqrt(xSum + ySum);
	}
	

	 public void draw(Graphics g) {
		 g.setColor(Color.BLUE);
		 g.fillRect((int) (xPos-width), (int) (yPos-20), (int) (width), (int) height);
		 g.setColor(Color.GREEN);
	     g.drawLine((int)(xPos-width/2), (int)(yPos), (int)(xPos- width), (int)(yPos));
	    }

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
