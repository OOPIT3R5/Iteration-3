package Model.Menu;

import java.util.Observable;

import View.CharacterCreationView;
import View.ModelView;


public class CharacterCreation extends Observable {
	int selected = 0;
	String[] options = {"Smasher","Summoner","Sneak","Back"};
	CharacterCreationView cv = new CharacterCreationView(options);
	
	public CharacterCreation(){
		addObserver(cv);
	}
	
	public String getState(){
		return options[Math.abs(selected)];
	}
	
	public ModelView getView(){
		return cv;
	}
	public void MoveDown(){
		if((--selected) < 0){
			selected = options.length - 1;
		}
		setChanged();
		notifyObservers(options[Math.abs(selected)]);
	}
	
	public void MoveUp(){
		selected = Math.abs((selected+1)% options.length);
		setChanged();
		notifyObservers(options[selected]);
	}
	
}
