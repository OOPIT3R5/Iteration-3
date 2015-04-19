package Model.Entity;

import Model.Entity.Ability.Move;

public class PetOwnership {

	Pet pet;
	Avatar owner;
	
	public PetOwnership(){
		
	}

	public PetOwnership(Avatar avatar, Pet pet) {
		// TODO Auto-generated constructor stub
		setPet(pet);
		setAvatar(avatar);
		
	}

	private void setAvatar(Avatar avatar) {
		this.owner = avatar;
		
	}

	public void setPet(Pet pet) {
		// TODO Auto-generated method stub
		this.pet = pet;
		
	}


	public Move followAvatar() {
		// TODO Auto-generated method stub
		return null;
	}
}
