import java.awt.Color;
import java.awt.Graphics;

public class Arm{
	double xPos, yPos;
	double width = 70;
	double height = 35;
	
	
	public Arm(double xPos, double yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public boolean detectCollision(Player other) {
		double xEdge = other.getXPos();
		double yEdge = other.getYPos();
		double x = xPos + (xPos/2);
		double y = yPos + (yPos/2);
		if(distance(x, y, (xEdge-(xEdge/2)), (yEdge-(yEdge/2))) <= 0)
			return true;
		else
			return false;
	}
	
	public double distance(double x, double y, double x2, double y2) {
		double xSum = (x-x2)*(x-x2);
		double ySum = (y-y2)*(y-y2);
		
		return Math.sqrt(xSum + ySum);
	}
	
	 public void draw1(Graphics g) {
		 g.setColor(Color.BLUE);
	     g.fillRect((int) xPos, (int) (yPos-50), (int) (width), (int) height);
	    }
	 
	 public void draw2(Graphics g) {
		 g.setColor(Color.BLUE);
		 g.fillRect((int) (xPos-150), (int) (yPos-50), (int) (width), (int) height);
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
