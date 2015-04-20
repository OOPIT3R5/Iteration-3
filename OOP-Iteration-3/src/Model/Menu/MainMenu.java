package Model.Menu;

import java.util.Observable;

import javax.swing.JComponent;

import View.MainMenuView;
import View.ModelView;

public class MainMenu extends Observable {
	int selected = 0;
	String[] options = {"new","load","options","quit"};
	MainMenuView mv = new MainMenuView(options);
	
	public MainMenu(){
		addObserver(mv);
	}
	
	public ModelView getView(){
		return mv;
	}
	
	public void MoveUp(){
		selected = Math.abs((selected+1)%options.length);
		setChanged();
		notifyObservers(options[selected]);
	}
	public void MoveDown(){
		if((--selected) < 0){
			selected = 3;
		}
		setChanged();
		notifyObservers(options[Math.abs(selected)]);
	}
	
	public String getState(){
		return options[Math.abs(selected)];
	}
	
}
