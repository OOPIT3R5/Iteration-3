package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import Main.Game;
import Main.RunGame;
import Model.Entity.Avatar;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Grid.HexagonalGrid;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Terrain.Grass;
import Model.Terrain.Mountain;
import Model.Terrain.Water;

public class GameView extends ModelView {
	private GameMap gameMap;
	private Avatar avatar;
	private static JTextArea log = new JTextArea();
	private static String s = "Welcome";
	
	public GameView(GameMap gameMap, Avatar avatar) {
		this.gameMap = gameMap;
		this.avatar = avatar;
		log.setText("WELCOME \n");
		log.setBackground(Color.BLACK);
		log.setForeground(Color.RED);
		log.setEditable(false);
		log.setFocusable(false);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}

	@Override
	public void accept(View view) {
		view.visit(this);
	}

	@Override
	public void render(Graphics g) {
		/*
		g.drawOval(50, 50,50, 50);
		gameMap = new GameMap(100, 100);
		gameMap.fill(new HexagonalTile(new Grass()));
		//System.out.println(gg.toString());

		gameMap.add(1, 1, new HexagonalTile(new Water()));
		gameMap.add(5, 5, new HexagonalTile(new Mountain()));
		
		gameMap.drawRectangleWithCoords(g, new Point(0, 0), new HexagonalLocation(0, 0), 100, 100, 20);
		
		*/
		gameMap.render(g, avatar);
		renderHealthBar(g);
		renderManaBar(g);
		renderExperienceBar(g);
		renderLives(g);
		renderInfo(g);
		
		log.setBounds(3*View.WIDTH/4, 2*View.HEIGHT/4, View.WIDTH/4, View.HEIGHT/4);
		g.translate(9*View.WIDTH/10, 2*View.HEIGHT/4);
		log.paint(g);
		g.translate(-(9*View.WIDTH/10), -(2*View.HEIGHT/4));
	}
	
	public void renderInfo(Graphics g){
		JLabel info = new JLabel("<html><p style=\"font-size:15; color:white;\">" + avatar.getOccupation().displayName() + " : Level " + avatar.getStatistics().getLevel() + "</p></html>");
		info.setBounds(10, 0, 200, 20);
		g.translate(10, 10);
		info.paint(g);
		g.translate(-10, -10);
	}
	
	public void renderHealthBar(Graphics g){
		JProgressBar health = new JProgressBar(0, avatar.getStatistics().getMaxLife());
		health.setStringPainted(true);
		health.setForeground(Color.RED);
		health.setString("Health: " + avatar.getStatistics().getLife()+"/"+avatar.getStatistics().getMaxLife());
		health.setValue(avatar.getStatistics().getLife());
		health.setBounds(0, 0, 200, 22);
		g.translate(250, 10);
		health.paint(g);
		g.translate(-250, -10);
		
	}
	
	public void renderManaBar(Graphics g){
		JProgressBar mana = new JProgressBar(0, avatar.getStatistics().getMaxMana());
		mana.setStringPainted(true);
		mana.setForeground(Color.BLUE);
		mana.setString("Mana: " + avatar.getStatistics().getMana()+"/"+avatar.getStatistics().getMaxMana());
		mana.setValue(avatar.getStatistics().getMana());
		mana.setBounds(10, 300, 200, 22);
		g.translate(500, 10);
		mana.paint(g);	
		g.translate(-500, -10);
	}
	
	public void renderExperienceBar(Graphics g){
		JProgressBar mana = new JProgressBar(0, 1000);
		mana.setStringPainted(true);
		mana.setForeground(Color.YELLOW);
		mana.setString("Experience: " + avatar.getStatistics().getExperience()+"/"+1000);
		mana.setValue(avatar.getStatistics().getExperience());
		mana.setBounds(10, 600, 200, 22);
		g.translate(750, 10);
		mana.paint(g);
		g.translate(-750, -10);
		if(avatar.getskillPoints() > 0){
			JLabel info = new JLabel("<html><p style=\"font-size:20; color:Yellow;\"> &dagger;</p></html>");
			info.setBounds(10, 0, 200, 20);
			g.translate(960, 10);
			info.paint(g);
			g.translate(-960, -10);
		}	
		
	}
	
	public void renderLives(Graphics g){
		for(int i = 0; i < avatar.getStatistics().getNumLivesLeft(); i++){
			JLabel heart = new JLabel("<html><h1 style=\"font-size:20; color:red;\">&hearts;</h1></html>");
			heart.setBounds(10 + i*20, 10, 20, 20);
			g.translate(10 + i*20, 40);
			heart.paint(g);
			g.translate(-(10 + i*20), -40);
		}
		
	}
	
	public static void writeToLog(String data){
		s = data + "\n";
		log.setText(s);
	}


}
