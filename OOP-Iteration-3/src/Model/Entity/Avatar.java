package Model.Entity;

import java.util.Observer;

import Model.Map.HexagonalLocation;

public class Avatar extends Entity{

	public Avatar(){
		super.setLocation(new HexagonalLocation(0 , 0));
	}

	public Avatar(String name, Occupation o){
		super(name, o);
	}

	public Avatar(String name) {
		super(name);
		super.setLocation(new HexagonalLocation(0 , 0));
	}

    @Override
    public void removeFromMap(){
    	setChanged();
		notifyObservers();
    }

	@Override
	public void performAction() {
		// TODO Auto-generated method stub
		System.out.println("Entities should be moving");
		
	}
}
