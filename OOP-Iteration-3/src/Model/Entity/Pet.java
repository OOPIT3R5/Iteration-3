package Model.Entity;

import Model.Entity.Ability.Ability;

public interface Pet {
	
	public Ability attackInVicinity();
	public  Ability stealInVicinity();
	public void becomePet(PetOwnership po);

}
