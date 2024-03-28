// Last modified 3/28/24

import javax.swing.JComponent;


public class Player extends JComponent {
	private int hp;
	private boolean isAlive;
	
	public Player(int hp, boolean isAlive) {
		this.hp = hp;
		this.isAlive = isAlive;
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
