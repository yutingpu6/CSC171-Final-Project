import javax.swing.*;
import java.awt.*;

public class Player extends JComponent{
	int hits = 0;
	boolean isAlive;
	double xPos, yPos, velocityX, velocityY; 
	int time = 10;
	Arm arm;
	boolean drawArm = false;
	boolean movingLeft = false;
	boolean movingRight = false; 
	boolean isJumping = false;
	Color color;
    String path;
    double width = 140;
    double height = 450;
    Image sprite, fullHeart, halfHeart, emptyHeart;
	
    public Player(boolean isAlive, double xPos, double yPos, Color color, String path) {
        this.isAlive = isAlive;
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.path = path;
        this.fullHeart = new ImageIcon("src/pixil-frame-0.png").getImage();
        this.halfHeart = new ImageIcon("src/pixil-frame-0 (1).png").getImage();
        this.emptyHeart = new ImageIcon("src/pixil-frame-0 (2).png").getImage();
    }
	
    public void attack(Player2 opponent) {
    	System.out.println("path for full heart: " + fullHeart);
    	arm = new Arm(xPos + 60, yPos);
        if (opponent.isAlive) {
        	arm.setxPos(xPos + width/2);
        	arm.setyPos(yPos-110);
        	setPath("src/BlueSprite3.png");
        	//drawArm = true;
        	if(arm.detectCollision(opponent)==true) {
        		opponent.setHits(1);
        	}
        }
    }
   
    
    public void lowerArm() {
    	arm.setxPos(0);
    	arm.setyPos(800);
    	setPath("src/BlueSprite1.png");
    }
    
    public void jump(double time) {
    	if(yPos >= 300) {
    		setYVelocity(-1.5);
    		yPos += velocityY * time;
    	}
    	if(yPos<=300) {
    		isJumping = false;
    	}
    }
    
    public void fall(double time) {
    	if(yPos <=450) {
    		setYVelocity(1.5);
            yPos += velocityY * time;
    	}
    }
    
	 public void draw(Graphics g) {
		 //g.setColor(Color.RED);
	     //g.fillRect((int) (xPos - width / 2), (int) (yPos - height / 2), (int) width, (int) height);
	     sprite = new ImageIcon(path).getImage();	     
	     g.drawImage(sprite, (int)(xPos-width/2-40), (int)(yPos-height/2), null);
	     drawHealthBar(g);
	    }
	 
	
	 private void drawHealthBar(Graphics g) {
	        int heartWidth = 80 ;
	        int heartHeight = 80;
	        int heartXOffset = (heartWidth + 10) * 3 / 2;
	        int heartX = (int) (xPos - heartXOffset / 2);
	        int heartY = (int) (yPos - height) + 100;
	        Image heartImage1, heartImage2, heartImage3;
	        heartImage1 = fullHeart;
	        heartImage2 = fullHeart;
	        heartImage3 = fullHeart;
	        if(hits==1) {
	        	heartImage1 = halfHeart;
	        	heartImage2 = fullHeart;
	        	heartImage3 = fullHeart;
	        }
	        else if(hits==2) {
	        	heartImage1 = emptyHeart;
	        	heartImage2 = fullHeart;
	        	heartImage3 = fullHeart;
	        }
	        else if(hits==3) {
	        	heartImage1 = emptyHeart;
	        	heartImage2 = halfHeart;
	        	heartImage3 = fullHeart;
	        }
	        else if(hits==4) {
	        	heartImage1 = emptyHeart;
	        	heartImage2 = emptyHeart;
	        	heartImage3 = fullHeart;
	        }
	        else if(hits==5) {
	        	heartImage1 = emptyHeart;
	        	heartImage2 = emptyHeart;
	        	heartImage3 = halfHeart;
	        }
	        else if(hits==6) {
	        	heartImage1 = emptyHeart;
	        	heartImage2 = emptyHeart;
	        	heartImage3 = emptyHeart;
	        }
	        g.drawImage(heartImage3, heartX + (0), heartY, heartWidth, heartHeight, null);
	        g.drawImage(heartImage2, heartX + (1 * (heartWidth + 10)), heartY, heartWidth, heartHeight, null);
	        g.drawImage(heartImage1, heartX + (2 * (heartWidth + 10)), heartY, heartWidth, heartHeight, null);
	    }
	 

	public void moveLeft(double time) {
		setXVelocity(-0.8);
		xPos += velocityX * time;
	}
	
	public void moveRight(double time) {
		setXVelocity(0.8);
		xPos += velocityX * time;
	}
	
	public void detectWallCollision() {
		if(xPos - width/2 <= 0) {
			setXVelocity(Math.abs(velocityX));
			xPos = 0 + width/2;
		}
		if(xPos + width/2 >= 1440) {
			setXVelocity(Math.abs(velocityX));
			System.out.println("true");
			xPos = 1440 - width/2;
		}
	}
	
	public void setXVelocity(double vX) {
		this.velocityX = vX;
	}
	
	public void setYVelocity(double vY) {
		this.velocityY = vY;
	}
	
	public void setHits(int hits) {
		this.hits += hits;
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
	
	public void checkAlive() {
		if(hits>=6)
			isAlive = false;
	}
	
	public void setPath(String newPath) {
		path = newPath;
	}

}
