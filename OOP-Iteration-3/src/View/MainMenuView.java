package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class MainMenuView extends JPanel implements Observer {
	
	private HashMap<String,JLabel> options = new HashMap<String,JLabel>();
	
	public final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public final int SUB1_X = 2*SCREEN_WIDTH/7;
	public final int SUB1_Y = SCREEN_HEIGHT/12;
	public final int SUB1_WIDTH = 2*SCREEN_WIDTH/5;
	public final int SUB1_HEIGHT = 8*SCREEN_HEIGHT/10;

	public MainMenuView(String[] options){
		
		setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		setBackground(new Color(0, 0, 0));
		setLayout(null);	
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		panel.setBounds(SUB1_X, SUB1_Y, SUB1_WIDTH, SUB1_HEIGHT);
		add(panel);
		panel.setLayout(new GridLayout(5,1));
		
		JLabel lblNew = new JLabel("<html><u>Main Menu</u></html>",SwingConstants.CENTER);
		lblNew.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNew.setForeground(Color.WHITE);
		panel.add(lblNew);
		for(String s : options){
			JLabel l = new JLabel(s,SwingConstants.CENTER);
			this.options.put(s, l);
			l.setFont(new Font("Tahoma", Font.PLAIN, 25));
			l.setForeground(Color.WHITE);
			panel.add(l);
		}	
		this.options.get(options[0]).setForeground(Color.RED);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for(Entry<String, JLabel> entry: options.entrySet()){
   			JLabel a = entry.getValue();
   			a.setForeground(Color.WHITE);
   		 }
		options.get(arg1).setForeground(Color.RED);		
	}
	
}
