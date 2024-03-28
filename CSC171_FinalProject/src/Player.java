// Last modified 3/28/24

import javax.swing.JComponent;


public class Player extends JComponent {
	private int hp;
	private boolean isAlive;
	private double x;
	private double y;
	
	public Player(int hp, boolean isAlive, double x, double y) {
		this.hp = hp;
		this.isAlive = isAlive;
		this.x = x;
		this.y = y;
	}
	
	public int getHp() {
		return hp;
	}
	
	public boolean getAlive() {
		return isAlive;
	}
	
	public void setHp(int dmg) {
		hp -= dmg;
	}
	
	public void setAlive() {
		if (hp==0)
			isAlive = false;
	}
}
