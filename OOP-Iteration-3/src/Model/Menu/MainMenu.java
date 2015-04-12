package Model.Menu;

import java.util.Observable;

import javax.swing.JComponent;

import View.MainMenuView;

public class MainMenu extends Observable {
	int selected = 0;
	String[] options = {"new","load","quit"};
	MainMenuView mv = new MainMenuView(options);
	
	public MainMenu(){
		addObserver(mv);
	}
	
	public JComponent getView(){
		return mv;
	}
	
	public void MoveUp(){
		selected = Math.abs((selected+1)%3);
		setChanged();
		notifyObservers(options[selected]);
	}
	public void MoveDown(){
		selected = (selected-1)%3;
		setChanged();
		notifyObservers(options[Math.abs(selected)]);
	}
	
	public String getState(){
		return options[Math.abs(selected)];
	}
	
}
