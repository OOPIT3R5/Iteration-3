package Model.Menu;

import java.util.Observable;

import javax.swing.JComponent;

import View.CharacterCreationView;
import View.ModelView;


public class CharacterCreation extends Observable {
	int selected = 0;
	String[] options = {"Smasher","Summoner","Sneak","Back"};
	CharacterCreationView cv = new CharacterCreationView(options);
	
	public CharacterCreation(){
		addObserver(cv);
	}
	
	public ModelView getView(){
		return cv;
	}
	
	public void MoveUp(){
		selected = Math.abs((selected+1)% options.length);
		setChanged();
		notifyObservers(options[selected]);
	}
	public void MoveDown(){
		if((--selected) < 0){
			selected = options.length - 1;
		}
		setChanged();
		notifyObservers(options[Math.abs(selected)]);
	}
	
	public String getState(){
		return options[Math.abs(selected)];
	}
	
}
