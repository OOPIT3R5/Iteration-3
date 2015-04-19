package View;

import Model.Entity.Ability.DoNothing;
import Model.Entity.Entity;
import Model.Items.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;


@SuppressWarnings("serial")
public class InventoryView extends ModelView {

	public final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

	public final int INV_X = 0;
	public final int INV_Y = 0;
	public final int INV_WIDTH = 2*SCREEN_WIDTH/3;
	public final int INV_HEIGHT = 2*SCREEN_HEIGHT/3;

	public final int INV_GRIDX = INV_WIDTH/8;
	public final int INV_GRIDY = INV_HEIGHT/6;
	public final int INV_GRIDWIDTH = 4*INV_GRIDX;
	public final int INV_GRIDHEIGHT = 4*INV_GRIDY;

	public final int EQUIP_X = INV_WIDTH;
	public final int EQUIP_Y = 0;
	public final int EQUIP_WIDTH = SCREEN_WIDTH/3;
	public final int EQUIP_HEIGHT = 2*SCREEN_HEIGHT/3;

	public final int STATS_X = 0;
	public final int STATS_Y = INV_HEIGHT;
	public final int STATS_WIDTH = SCREEN_WIDTH;
	public final int STATS_HEIGHT = SCREEN_HEIGHT/3;

    private Entity avatar;

	public InventoryView(Entity entity) {
        avatar = entity;
		/*
		setBounds(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		setLayout(null);
		JPanel inventory = new JPanel();
		inventory.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		inventory.setBounds(INV_X,INV_Y,INV_WIDTH,INV_HEIGHT);
		inventory.add(new JLabel("Insert Inventory Here"));
		add(inventory);

		JPanel equipment = new JPanel();
		equipment.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		equipment.setBounds(EQUIP_X,EQUIP_Y,EQUIP_WIDTH,EQUIP_HEIGHT);
		equipment.add(new JLabel("Insert Equipment Here"));
		add(equipment);

		JPanel stats = new JPanel();
		stats.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		stats.setBounds(STATS_X,STATS_Y,STATS_WIDTH,STATS_HEIGHT);
		stats.add(new JLabel("Insert Stats Here"));
		add(stats);
		*/
	}

    @Override
	public void accept(View view) {
		// TODO Auto-generated method stub
		view.visit(this);
	}
	@Override
	public void render(Graphics g) {
        renderInventory(g);
        renderEquipment(g);
    }

    private void renderInventory(Graphics g){
        g.drawString("INVENTORY", 500, 50);
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
    }

    private void renderEquipment(Graphics g){
        g.drawRect(INV_WIDTH + EQUIP_WIDTH/3, INV_GRIDY, INV_GRIDWIDTH/6, INV_GRIDHEIGHT/4);                                        //TOP BOX (helmet)
        g.drawRect(INV_WIDTH + EQUIP_WIDTH/3, INV_GRIDY + INV_GRIDHEIGHT/4, INV_GRIDWIDTH/6, INV_GRIDHEIGHT/4);                     //MIDDLE BOX (Armor)
        g.drawRect(INV_WIDTH + EQUIP_WIDTH/3 + INV_GRIDWIDTH/6, INV_GRIDY + INV_GRIDHEIGHT/4, INV_GRIDWIDTH/6, INV_GRIDHEIGHT/4);   //RIGHT BOX (Off-hand)
        g.drawRect(INV_WIDTH + EQUIP_WIDTH/3 - INV_GRIDWIDTH/6, INV_GRIDY + INV_GRIDHEIGHT/4, INV_GRIDWIDTH/6, INV_GRIDHEIGHT/4);   //LEFT BOX (Weapon)
        g.drawRect(INV_WIDTH + EQUIP_WIDTH/3, INV_GRIDY + INV_GRIDHEIGHT/2, INV_GRIDWIDTH/6, INV_GRIDHEIGHT/4);                     //BOTTOM BOX (Shoes)

    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
		/*
        // TODO Auto-generated method stub
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
