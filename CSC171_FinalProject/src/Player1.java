// Last modified 3/25/24


public class Player1 {
	private int hp;
	private boolean isAlive;
	
	public Player1(int hp, boolean isAlive) {
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
