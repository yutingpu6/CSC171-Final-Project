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
	
	public boolean detectCollision(Player2 other) {
		double xEdge = other.getXPos()-70;
		double x = xPos + width;
		if(xEdge-x<=0) {
			if(other.getYPos()-225<=yPos || yPos<=other.getYPos()+225) {
				return true;
			}
		}
		return false;
	}
	
	
	 public void draw(Graphics g) {
		 g.setColor(Color.BLUE);
	     g.fillRect((int) xPos, (int) (yPos-40), (int) (width), (int) height);
	     //g.setColor(Color.GREEN);
	     //g.drawLine((int)(xPos+width/2), (int)(yPos), (int)(xPos+ width), (int)(yPos));
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
