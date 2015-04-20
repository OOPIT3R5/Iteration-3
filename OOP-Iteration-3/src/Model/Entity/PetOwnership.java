package Model.Entity;

import Model.Entity.Ability.Move;
import Model.Map.Direction;

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
		pet.becomePet(this);
		this.pet = pet;
		
		
	}


	public Move followAvatar() {
		Direction d = ((NPC) pet).directionTowardAvatar();
		return new Move(((NPC)pet), d, ((NPC)pet).getMovementSpeed());
		//return null;
	}
}
