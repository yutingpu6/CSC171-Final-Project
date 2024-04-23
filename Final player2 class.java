import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Player2 extends JComponent{
	int hp = 100;
	int hits = 0;
	boolean isAlive;
	double xPos, yPos, velocityX, velocityY; 
	int time = 10;
	Arm2 arm;
	boolean drawArm = false;
	boolean movingLeft = false;
	boolean movingRight = false; 
	boolean isJumping = false;
	Color color;
    String path;
    double width = 140;
    double height = 450;
    Image sprite, fullHeart, halfHeart, emptyHeart;
	
    public Player2(boolean isAlive, double xPos, double yPos, Color color, String path) {
        this.isAlive = isAlive;
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.path = path;
        this.fullHeart = new ImageIcon("src/pixil-frame-0.png").getImage();
        this.halfHeart = new ImageIcon("src/pixil-frame-0 (1).png").getImage();
        this.emptyHeart = new ImageIcon("src/pixil-frame-0 (2).png").getImage();
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
        		opponent.setHits(1);
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
	        int heartWidth = 80;
	        int heartHeight = 80;
	        int heartX = 1340 - 3 * (heartWidth + 10);  
	        int heartY = 10;  

	        Image heartImage1 = fullHeart, heartImage2 = fullHeart, heartImage3 = fullHeart;
	        if (hits == 1) {
	            heartImage1 = halfHeart;
	        } else if (hits == 2) {
	            heartImage1 = emptyHeart;
	        } else if (hits == 3) {
	            heartImage1 = emptyHeart;
	            heartImage2 = halfHeart;
	        } else if (hits == 4) {
	            heartImage1 = emptyHeart;
	            heartImage2 = emptyHeart;
	        } else if (hits == 5) {
	            heartImage1 = emptyHeart;
	            heartImage2 = emptyHeart;
	            heartImage3 = halfHeart;
	        } else if (hits == 6) {
	            heartImage1 = emptyHeart;
	            heartImage2 = emptyHeart;
	            heartImage3 = emptyHeart;
	        }

	       
	        g.drawImage(heartImage3, heartX + 2 * (heartWidth + 10), heartY, heartWidth, heartHeight, null);
	        g.drawImage(heartImage2, heartX + 1 * (heartWidth + 10), heartY, heartWidth, heartHeight, null);
	        g.drawImage(heartImage1, heartX, heartY, heartWidth, heartHeight, null);
	    }

	 public void moveLeft(double time) {
			setXVelocity(0.8);
			xPos -= velocityX * time;
	}
		
	public void moveRight(double time) {
		setXVelocity(-0.8);
		xPos -= velocityX * time;
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
		if(hits>=6)
			isAlive = false;
	}
	
	public void setPath(String newPath) {
		path = newPath;
	}

}
