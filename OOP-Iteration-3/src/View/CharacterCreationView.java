package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class CharacterCreationView extends ModelView implements Observer {
	
	private HashMap<String,JLabel> options = new HashMap<String,JLabel>();

	public CharacterCreationView(String[] options){
		/*
		setBackground(new Color(0, 0, 0));
		setLayout(new BorderLayout());	
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		JLabel title = new JLabel("<html><u>Character Creation</u></html>",SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.PLAIN, 35));
		add(title,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2,2));
		*/
		for(String s : options){
			JLabel a = new JLabel(s,SwingConstants.CENTER);
   			//panel.add(a);
   			a.setForeground(Color.WHITE);
   			a.setFont(new Font("Tahoma", Font.PLAIN, 25));
			this.options.put(s, a);
		}
		
		this.options.get(options[0]).setForeground(Color.RED);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		for(Entry<String, JLabel> entry: options.entrySet()){
   			JLabel a = entry.getValue();
   			a.setForeground(Color.WHITE);
   		 }
		options.get(arg).setForeground(Color.RED);	
	}

	@Override
	public void accept(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
