package Model.Entity;

import Model.Entity.Ability.Move;

public class PetOwnership {

	Pet pet;
	Avatar owner;
	
	public PetOwnership(){
		
	}

	public PetOwnership(Avatar avatar, Pet pet) {
		setPet(pet);
		setAvatar(avatar);
	}

	private void setAvatar(Avatar avatar) {
		this.owner = avatar;
		
	}

	public void setPet(Pet pet) {
		this.pet = pet;
		
	}


	public Move followAvatar() {
		return null;
	}
}
