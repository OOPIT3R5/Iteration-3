package Model.Menu;

import java.util.Observable;

import javax.swing.JComponent;

import View.CharacterCreationView;


public class CharacterCreation extends Observable {
	int selected = 0;
	String[] options = {"back","sneak","smasher","summoner"};
	CharacterCreationView cv = new CharacterCreationView(options);
	
	public CharacterCreation(){
		addObserver(cv);
	}
	
	public JComponent getView(){
		return cv;
	}
	
	public void MoveUp(){
		selected = Math.abs((selected+1)%4);
		setChanged();
		notifyObservers(options[selected]);
	}
	public void MoveDown(){
		selected = (selected-1)%4;
		setChanged();
		notifyObservers(options[Math.abs(selected)]);
	}
	
	public String getState(){
		return options[Math.abs(selected)];
	}
	
}
