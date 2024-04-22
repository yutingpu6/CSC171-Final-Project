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
	        int heartWidth = 80 ;
	        int heartHeight = 80;
	        int heartXOffset = (heartWidth + 10) * 3 / 2;
	        int heartX = (int) (xPos - heartXOffset / 2);
	        int heartY = (int) (yPos - height) + 100;

	        for (int i = 0; i < 3; i++) {
	            Image heartImage = emptyHeart;
	            if (hp > (i * 2) + 1) {
	                heartImage = fullHeart;
	            } else if (hp > i * 2) {
	                heartImage = halfHeart;
	            }
	          
	            g.drawImage(heartImage, heartX + (i * (heartWidth + 10)), heartY, heartWidth, heartHeight, null);
	        }
	    }

	
	public void updatePosition(double time) {
		xPos += velocityX * time;
		yPos += velocityY * time;
	}
	
	public void setVelocity(double vX, double vY) {
		this.velocityX = vX;
		this.velocityY = vY;
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
