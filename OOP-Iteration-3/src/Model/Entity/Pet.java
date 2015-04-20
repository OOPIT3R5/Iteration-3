package Model.Entity;

import Model.Entity.Ability.Ability;

public interface Pet {
	
	public Ability attackInVicinity();
	public void becomePet(PetOwnership po);
	public  Ability stealInVicinity();

}
