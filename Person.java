
public class Person {
	private int coins;
	
	public Person(int coins) {
		this.coins = coins;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	public void subtractCoins() {
		coins--;
	}
}
