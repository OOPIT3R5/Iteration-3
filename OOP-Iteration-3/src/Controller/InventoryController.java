package Controller;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import Main.KeySet;
import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Items.TakeableItem;
import View.InventoryView;
import View.Model.ModelView;

public class InventoryController extends Controller {
	KeyListener back = new BacktoGame();
	KeyListener render = new Render();
	MouseListener ml = new UseItem();
    Entity e;

	private static InventoryController instance;
	
	//private InventoryView inventoryView;

	private InventoryController(Entity e){
        this.e = e;
    }
	
	public static InventoryController getInstance(Entity e){
		if(instance == null){
			
			instance = new InventoryController(e);
			//inventoryView = new InventoryView(e);
		}
		return instance;
	}

	@Override
	public ModelView getView() {
		// TODO Auto-generated method stub
		return e.getInventoryView();
	}

	@Override
	public void register(JFrame f) {
		f.addKeyListener(back);
		f.addKeyListener(render);
        f.addMouseListener(ml);
	}

	@Override
	public void deRegister(JFrame f) {
		f.removeKeyListener(render);
		f.removeKeyListener(back);
        f.removeMouseListener(ml);
	}
	
	public class BacktoGame implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("BACK")){
				setNext(GameController.getInstance());
				
			}

			if(key == KeySet.getKey("BACK")) {
                setChanged();
                notifyObservers();
                deleteObservers();
            }
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}

    private class UseItem implements MouseListener {


        private final int Xspacing           = InventoryView.INV_GRIDWIDTH/6;//=  88;
        private final int Yspacing           = InventoryView.INV_GRIDHEIGHT/4;//= 100;

        private final int InventoryStartingX = InventoryView.INV_GRIDX;//= 141;
        private final int InventoryStartingY = InventoryView.INV_GRIDY;//= 131;
        private final int EquipmentStartingX = InventoryView.INV_WIDTH + InventoryView.EQUIP_WIDTH/3 - InventoryView.INV_GRIDWIDTH/6;//= 1163;
        private final int EquipmentStartingY = InventoryView.INV_GRIDY;//= 131;

        private final int EquipmentMidXLo    = InventoryView.INV_WIDTH + InventoryView.EQUIP_WIDTH/3; //1251
        private final int EquipmentMidYLo    = InventoryView.INV_GRIDY;//131
        private final int EquipmentMidXHi    =EquipmentMidXLo+(Xspacing);//1339
        private final int EquipmentMidYHi    =EquipmentMidYLo+(Yspacing*3);//431

        private final int EquipmentTopXLo    =EquipmentStartingX;//1163
        private final int EquipmentTopYLo    =EquipmentStartingY+Yspacing;//231
        private final int EquipmentTopXHi    =EquipmentTopXLo+(Xspacing*3);//1427
        private final int EquipmentTopYHi    =EquipmentTopYLo+Yspacing;//331

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)//IfLeftClick
            {
                setChanged();
                notifyObservers();
                placeClicked(e.getPoint());
            }
            else {
                setChanged();
                notifyObservers();
                getInfo(e.getPoint());
            }
        }

        private void placeClicked(Point pointclicked) {
            int X = pointclicked.x;
            int Y = pointclicked.y;
            System.out.println(pointclicked);

            if(X < InventoryStartingX || Y < InventoryStartingY || X > (InventoryStartingX+(Xspacing*6)) || Y > (InventoryStartingY+(Yspacing*4))){
                checkEquipment(X, Y);
                return;
            }

            X -= InventoryStartingX;
            X /= Xspacing;

            Y -= InventoryStartingY;
            Y /= Yspacing;
            System.out.println(e.getItem((X+(Y*6))).toString());
          //  System.out.println("You clicked on Tile Number "+((X+(Y*6))+1)+" of row "+(X+1)+" and of column "+(Y+1)+".");
            e.utilizeTakeableItem((X+(Y*6))); //Go all VISITOR PATTERN ON THIS thing.
           

        }
        
        private void getInfo(Point pointclicked) {
            int X = pointclicked.x;
            int Y = pointclicked.y;
            System.out.println(pointclicked);

            if(X < InventoryStartingX || Y < InventoryStartingY || X > (InventoryStartingX+(Xspacing*6)) || Y > (InventoryStartingY+(Yspacing*4)))
                checkEquipment(X, Y);

            X -= InventoryStartingX;
            X /= Xspacing;

            Y -= InventoryStartingY;
            Y /= Yspacing;

           //System.out.println("You clicked on Tile Number "+((X+(Y*6))+1)+" of row "+(X+1)+" and of column "+(Y+1)+".");
            e.examineItem(e.getItem((X+(Y*6))).getName());
        }

        private void checkEquipment(int X, int Y) {
            //If we're not in the right square...
            if (!((((X >= EquipmentTopXLo) && (X <= EquipmentTopXHi)) && ((Y >= EquipmentTopYLo) && (Y <= EquipmentTopYHi))) || (((X >= EquipmentMidXLo) && (X <= EquipmentMidXHi)) && ((Y >= EquipmentMidYLo) && (Y <= EquipmentMidYHi))))){
                checkSkills(X,Y);
                return;
            }

            //else...
            X -= EquipmentStartingX;
            if(X < 0)
                return;
            X /= Xspacing;

            Y -= EquipmentStartingY;
            if(Y < 0)
                return;
            Y /= Yspacing;
            System.out.println(X+" "+Y);
            if (X == 0 && Y == 1)
                e.unequipWeapon();
            else if (X == 2 && Y == 1)
                e.unequipOffHand();
            else switch (Y) {
                    case 0:
                        if(X == 1) e.unequipAccessory();
                        break;
                    case 1:
                        if(X == 1) e.unequipArmor();
                        break;
                    case 2:
                        if(X == 1) e.unequipShoes();
                        break;
                    default:
                        break;
                }
        }

        private void checkSkills(int X, int Y) {
            ArrayList<Skill> skills = e.getOccupation().getSkillAL();
            int skillamount = skills.size();

            if((X < (InventoryView.INV_GRIDX + (InventoryView.BUTTONWIDTH * 6))) || (Y < InventoryView.STATS_HEIGHT/5 + InventoryView.STATS_Y+31)){
                System.out.println("CLICKED OUTSIDE BOY");
                return;
            }

            X -=  (InventoryView.INV_GRIDX + (InventoryView.BUTTONWIDTH * 6));
            X /=  InventoryView.BUTTONWIDTH;

            Y -=  (InventoryView.STATS_HEIGHT/5 + InventoryView.STATS_Y+31);
            Y /=  InventoryView.BUTTONHEIGHT;

            if(((X*4)+Y) < skillamount && e.getskillPoints() > 0){
                skills.get(((X*4)+Y)).levelSkillUp();   //LEVEL THAT SHIZ UP
                System.out.println("Skill "+skills.get((X*4)+Y).getName()+" leveled up!");
                e.useSkillPoint();
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
