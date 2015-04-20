package View;

import Model.Entity.Entity;
import Model.Entity.Skill;
import View.Model.MapObjectView;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Map.Entry;


@SuppressWarnings("serial")
public class InventoryView extends ModelView {

	public final static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public final static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

	public static final int INV_X = 0;
	public static final int INV_Y = 0;
	public static final int INV_WIDTH = 2*SCREEN_WIDTH/3;
	public static final int INV_HEIGHT = 2*SCREEN_HEIGHT/3;

	public final static int INV_GRIDX = INV_WIDTH/8;
	public final static int INV_GRIDY = INV_HEIGHT/6;
	public final static int INV_GRIDWIDTH = 4*INV_GRIDX;
	public final static int INV_GRIDHEIGHT = 4*INV_GRIDY;

	public final static int EQUIP_X = INV_WIDTH;
	public final static int EQUIP_Y = 0;
	public final static int EQUIP_WIDTH = SCREEN_WIDTH/3;
	public final static int EQUIP_HEIGHT = 2*SCREEN_HEIGHT/3;

	public final int STATS_X = 0;
	public final int STATS_Y = INV_HEIGHT;
	public final int STATS_WIDTH = SCREEN_WIDTH;
	public final int STATS_HEIGHT = SCREEN_HEIGHT/3;

    private Entity avatar;
    
    String info = "asd";
    
    private HashMap<String,Color> options = new HashMap<String,Color>();

	public InventoryView(Entity entity) {
        avatar = entity;
	}
	
	public void setInfo(String s){
		info = s;
	}

    @Override
	public void accept(View view) {
		view.visit(this);
	}
	@Override
	public void render(Graphics g) {
        renderInventory(g);
        try{
            renderEquipment(g);
        }catch(IOException e){
            e.printStackTrace();
        }
        renderStats(g);
        renderSkills(g);
    }

    private void renderInventory(Graphics g){
    	
    	float old = g.getFont().getSize();
		g.setFont(g.getFont().deriveFont(40.0f));
		String title = "Inventory";
		FontMetrics fm = g.getFontMetrics();
	    int w = fm.stringWidth(title);
		g.drawString(title, INV_WIDTH/2 - (w), 50);
		g.setFont(g.getFont().deriveFont(old));
		
        g.drawRect(INV_X, INV_Y, INV_WIDTH, INV_HEIGHT);
        g.drawRect(INV_GRIDX, INV_GRIDY, INV_GRIDWIDTH, INV_GRIDHEIGHT);

        g.drawRect(EQUIP_X, EQUIP_Y, EQUIP_WIDTH, EQUIP_HEIGHT);
        g.drawRect(STATS_X, STATS_Y, STATS_WIDTH, STATS_HEIGHT);



        ArrayList<MapObjectView> mov = avatar.getInventory();
        int counter = mov.size();

        for(int i = 0; i < 4; ++i){
            for(int j = 0; j < 6; ++j){
                g.drawRect(INV_GRIDX+j*INV_GRIDWIDTH/6, INV_GRIDY+i*INV_GRIDHEIGHT/4, INV_GRIDWIDTH/6, INV_GRIDHEIGHT/4);
                if(counter > 0){
                    g.drawImage(mov.get((6*i)+j).getBufferedImage().getScaledInstance(65,65, Image.SCALE_DEFAULT),(INV_GRIDX+j*INV_GRIDWIDTH/6)+12,(INV_GRIDY+i*INV_GRIDHEIGHT/4)+12,null);
                    counter--;
                }
            }
        }
        
        g.drawString("Gold: " + avatar.getGold(), INV_WIDTH/2 - (w), INV_HEIGHT-50);
        
        g.drawString(info, INV_GRIDWIDTH + INV_GRIDX + 10, INV_HEIGHT/2);
        
    }

    private void renderEquipment(Graphics g) throws IOException {

        float old = g.getFont().getSize();
        g.setFont(g.getFont().deriveFont(40.0f));
        String title = "Equipment";
        FontMetrics fm = g.getFontMetrics();
        int w = fm.stringWidth(title);
        g.drawString(title, INV_WIDTH + EQUIP_WIDTH/2 - (2*w / 3), 50);
        g.setFont(g.getFont().deriveFont(old));

        MapObjectView[] views = avatar.getEquipmentViews();

        g.drawRect(INV_WIDTH + EQUIP_WIDTH/3, INV_GRIDY, INV_GRIDWIDTH/6, INV_GRIDHEIGHT/4);                                        //TOP BOX (helmet)
        g.drawImage(views[3].getBufferedImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT), (INV_WIDTH + EQUIP_WIDTH / 3) + 12, INV_GRIDY + 12, null);

        g.drawRect(INV_WIDTH + EQUIP_WIDTH / 3, INV_GRIDY + INV_GRIDHEIGHT / 4, INV_GRIDWIDTH / 6, INV_GRIDHEIGHT / 4);                     //MIDDLE BOX (Armor)
        g.drawImage(views[2].getBufferedImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT), (INV_WIDTH + EQUIP_WIDTH / 3) + 12, (INV_GRIDY + INV_GRIDHEIGHT / 4) + 12, null);

        g.drawRect(INV_WIDTH + EQUIP_WIDTH / 3 + INV_GRIDWIDTH / 6, INV_GRIDY + INV_GRIDHEIGHT / 4, INV_GRIDWIDTH / 6, INV_GRIDHEIGHT / 4);   //RIGHT BOX (Off-hand)
        g.drawImage(views[1].getBufferedImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT), (INV_WIDTH + EQUIP_WIDTH / 3 + INV_GRIDWIDTH / 6) + 12, (INV_GRIDY + INV_GRIDHEIGHT / 4) + 12, null);

        g.drawRect(INV_WIDTH + EQUIP_WIDTH/3 - INV_GRIDWIDTH/6, INV_GRIDY + INV_GRIDHEIGHT/4, INV_GRIDWIDTH/6, INV_GRIDHEIGHT/4);   //LEFT BOX (Weapon)
        g.drawImage(views[0].getBufferedImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT), (INV_WIDTH + EQUIP_WIDTH / 3 - INV_GRIDWIDTH/6) + 12, (INV_GRIDY + INV_GRIDHEIGHT / 4) + 12, null);

        g.drawRect(INV_WIDTH + EQUIP_WIDTH/3, INV_GRIDY + INV_GRIDHEIGHT/2, INV_GRIDWIDTH/6, INV_GRIDHEIGHT/4);                     //BOTTOM BOX (Shoes)
        g.drawImage(views[4].getBufferedImage().getScaledInstance(65, 65, Image.SCALE_DEFAULT), (INV_WIDTH + EQUIP_WIDTH / 3) + 12, (INV_GRIDY + INV_GRIDHEIGHT/2) + 12, null);
    }
    
    private void renderStats(Graphics g){
    	int buttonWidth = 150;
    	int buttonHeight = 22;
    	
    	float old = g.getFont().getSize();
		g.setFont(g.getFont().deriveFont(25.0f));
		String title = "Primary Stats";
		FontMetrics fm = g.getFontMetrics();
	    int w = fm.stringWidth(title);
		g.drawString(title, INV_GRIDX + buttonWidth - (w / 2), STATS_Y+ 35);
		g.setFont(g.getFont().deriveFont(old));
		
    	MenuButton m = new MenuButton(buttonWidth, buttonHeight);
    	m.render(g, INV_GRIDX, STATS_Y + STATS_HEIGHT/5, Color.black, "Lives left : " + avatar.getStatistics().getNumLivesLeft() );
    	m.render(g, INV_GRIDX, STATS_Y + STATS_HEIGHT/5 + buttonHeight, Color.black, "Strength : " + avatar.getStatistics().getStrength() );
    	m.render(g, INV_GRIDX, STATS_Y + STATS_HEIGHT/5 + buttonHeight*2, Color.black, "Agility  : " + avatar.getStatistics().getAgility() );
    	m.render(g, INV_GRIDX, STATS_Y + STATS_HEIGHT/5 + buttonHeight*3, Color.black, "Intellect : " + avatar.getStatistics().getIntellect() );
    	m.render(g, INV_GRIDX + buttonWidth, STATS_Y + STATS_HEIGHT/5, Color.black, "Hardiness : " + avatar.getStatistics().getHardiness() );
    	m.render(g, INV_GRIDX + buttonWidth, STATS_Y + STATS_HEIGHT/5 + buttonHeight, Color.black, "Experience : " + avatar.getStatistics().getExperience() );
    	m.render(g, INV_GRIDX + buttonWidth, STATS_Y + STATS_HEIGHT/5 + buttonHeight*2, Color.black, "Movement : " + avatar.getStatistics().getMovement() );
    	
    	old = g.getFont().getSize();
		g.setFont(g.getFont().deriveFont(25.0f));
		title = "Derived Stats";
		fm = g.getFontMetrics();
	    w = fm.stringWidth(title);
		g.drawString(title, INV_GRIDX + buttonWidth*4 - (w / 2), STATS_Y+ 35);
		g.setFont(g.getFont().deriveFont(old));
		
    	m.render(g, INV_GRIDX + buttonWidth*3, STATS_Y + STATS_HEIGHT/5, Color.black, "Level  : " + avatar.getStatistics().getLevel() );
    	m.render(g, INV_GRIDX + buttonWidth*3, STATS_Y + STATS_HEIGHT/5 + buttonHeight, Color.black, "Life : " + avatar.getStatistics().getLife() );
    	m.render(g, INV_GRIDX + buttonWidth*3, STATS_Y + STATS_HEIGHT/5 + buttonHeight*2, Color.black, "Mana  : " + avatar.getStatistics().getMana() );
    	m.render(g, INV_GRIDX + buttonWidth*3, STATS_Y + STATS_HEIGHT/5 + buttonHeight*3, Color.black, "Offensive rating : " + avatar.getStatistics().getOffensiveRating() );
    	m.render(g, INV_GRIDX + buttonWidth*4, STATS_Y + STATS_HEIGHT/5, Color.black, "Defensive rating : " + avatar.getStatistics().getDefensiveRating() );
    	m.render(g, INV_GRIDX + buttonWidth*4, STATS_Y + STATS_HEIGHT/5 + buttonHeight, Color.black, "Armor rating : " + avatar.getStatistics().getArmorRating() );
    }
    
    private void renderSkills(Graphics g){
    	int buttonWidth = 150;
    	int buttonHeight = 22;
    	
    	int startX = 0;
    	int startY = 0;
    	
    	float old = g.getFont().getSize();
		g.setFont(g.getFont().deriveFont(25.0f));
		String title = "Skills : You Have " + avatar.getskillPoints() +  " Point(s)";
		FontMetrics fm = g.getFontMetrics();
	    int w = fm.stringWidth(title);
		g.drawString(title, INV_GRIDX + buttonWidth * 7 - (w / 2), STATS_Y + 35);
		g.setFont(g.getFont().deriveFont(old));

        ArrayList<Skill> skillz = avatar.getOccupation().getSkillAL();
    	MenuButton m = new MenuButton(buttonWidth, buttonHeight);

    	for(Skill entry : skillz){
    		m.render(g, INV_GRIDX + buttonWidth*6 + startX, STATS_Y + STATS_HEIGHT/5 + startY, Color.black, entry.getName() + " : " + entry.getCurrentLevel() );
    		startY += buttonHeight;
    		if(startY > 3*buttonHeight){
    			startX += buttonWidth;
    			startY = 0;
    		}
   		 }
    }

	@Override
	public void update(Observable o, Object arg) {	// TODO

	}
		/*
        try {
            //g.drawImage(ImageIO.read(new File(System.getProperty("user.dir") + "/OOP-Iteration-3/Assets/item_sprites.png")).getSubimage(0,0,24,24), 0, 0, null);
           // g.drawImage(ImageIO.read(new File(System.getProperty("user.dir") + "/OOP-Iteration-3/Assets/item_sprites.png")).getSubimage(0,25,24,24).getScaledInstance(50,50,Image.SCALE_DEFAULT), 0, 0, null);
       //     g.drawString(Integer.toString()
            g.drawImage(MapObjectView.getSpriteFromFE(1,1),0,0,null);
            g.drawImage(MapObjectView.getSpriteFromPokemon(0,0),25,25,null);
        } catch (IOException e) {
            System.out.println("You do not have the item sprites.");
            System.out.println(System.getProperty("user.dir"));
        }*/
}
