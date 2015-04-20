package Model.Entity;

import Model.Entity.Ability.Move;
import Model.Map.Direction;
import Model.Map.HexagonalLocation;

public class PetOwnership {

	Pet pet;
	Avatar owner;
	
	public PetOwnership(){
		
	}

	public PetOwnership(Avatar avatar, Pet pet) {
		setPet(pet);
		setAvatar(avatar);
	}

	public Move followAvatar() {
		Direction d = ((NPC) pet).directionTowardAvatar();
		if (HexagonalLocation.rectilinearDistance(((NPC)pet).getLocation(), owner.getLocation()) >= 2) {
			return new Move(((NPC)pet), d, ((NPC)pet).getMovementSpeed());
		}
		return null;
		//return null;
	}

	private void setAvatar(Avatar avatar) {
		this.owner = avatar;
		
	}


	public void setPet(Pet pet) {
		pet.becomePet(this);
		this.pet = pet;
		
		
	}
}
