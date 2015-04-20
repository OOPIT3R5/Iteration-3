package Model.Entity;

public class Shopkeeper extends NonAdversarial {

	public Shopkeeper() {		// TODO Shopkeeper class
		
		
		
	}
	 public void receiveDamage(int damage) {
			stats.changeHealth(-damage);
			becomeHostile();
		}

}
