package Controller;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

import Main.KeySet;
import Model.Entity.Entity;
import View.InventoryView;
import View.ModelView;

public class InventoryController extends Controller {
	KeyListener back = new BacktoGame();
	KeyListener render = new Render();
	MouseListener ml = new UseItem();
    Entity e;
	private static InventoryController instance;
	
	private static InventoryView inventoryView;

	private InventoryController(Entity e){
        this.e = e;
    }
	
	public static InventoryController getInstance(Entity e){
		if(instance == null){
			
			instance = new InventoryController(e);
			inventoryView = new InventoryView(e);
		}
		return instance;
	}
	@Override
	public ModelView getView() {
		// TODO Auto-generated method stub
		return inventoryView;
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
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}

    private class UseItem implements MouseListener {

        private static final int InventoryStartingX = 141;
        private static final int InventoryStartingY = 131;
        private static final int EquipmentStartingX = 1163;
        private static final int EquipmentStartingY = 131;

        private static final int EquipmentMidXLo    =1251;
        private static final int EquipmentMidYLo    = 131;
        private static final int EquipmentMidXHi    =1339;
        private static final int EquipmentMidYHi    = 431;

        private static final int EquipmentTopXLo    =1163;
        private static final int EquipmentTopYLo    = 231;
        private static final int EquipmentTopXHi    =1427;
        private static final int EquipmentTopYHi    = 331;

        private static final int Xspacing           =  88;
        private static final int Yspacing           = 100;

        @Override
        public void mouseClicked(MouseEvent e) {
            setChanged();
            notifyObservers();
            placeClicked(e.getPoint());
        }

        private void placeClicked(Point pointclicked) {
            int X = pointclicked.x;
            int Y = pointclicked.y;
            System.out.println(pointclicked);

            if(X < InventoryStartingX || Y < InventoryStartingY || X > (InventoryStartingX+(Xspacing*6)) || Y > (InventoryStartingY+(Yspacing*4)))
                checkEquipment(X, Y);

            X -= InventoryStartingX;
            X /= Xspacing;

            Y -= InventoryStartingY;
            Y /= Yspacing;

            System.out.println("You clicked on Tile Number "+((X+(Y*6))+1)+" of row "+(X+1)+" and of column "+(Y+1)+".");
            e.utilizeTakeableItem((X+(Y*6))); //Go all VISITOR PATTERN ON THIS thing.

        }

        private void checkEquipment(int X, int Y) {
            //If we're not in the right square...
            if (!((((X >= EquipmentTopXLo) && (X <= EquipmentTopXHi)) && ((Y >= EquipmentTopYLo) && (Y <= EquipmentTopYHi))) || (((X >= EquipmentMidXLo) && (X <= EquipmentMidXHi)) && ((Y >= EquipmentMidYLo) && (Y <= EquipmentMidYHi)))))
                return;
            //else...
            X -= EquipmentStartingX;
            X /= Xspacing;

            Y -= EquipmentStartingY;
            Y /= Yspacing;
            System.out.println(X+" "+Y);
            if (X == 0)
                e.unequipWeapon();
            else if (X == 2)
                e.unequipOffHand();
            else switch (Y) {
                    case 0:
                        e.unequipAccessory();
                        break;
                    case 1:
                        e.unequipArmor();
                        break;
                    case 2:
                        e.unequipShoes();
                        break;
                    default:
                        break;
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
