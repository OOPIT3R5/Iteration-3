package Main;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import View.View;
import Controller.Controller;
import Controller.MainMenuController;


public class RunGame implements Observer {

    private JFrame frame = new JFrame();
    Controller c = null;
    private View view;

    public static void main(String argv[]){
       RunGame r = new RunGame();
    }

    public RunGame(){
        view = new View();
        c =  MainMenuController.getInstance();
        KeySet keys = new KeySet();
        frame.add(view);
        view.render(c.getView());
        c.addObserver(this);
        c.register(frame);
        frame.setFocusable(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.repaint();
    }
    public void quit(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    @Override
    public void update(Observable o, Object arg) {
        c.deRegister(frame);
        c.deleteObservers();
        if((c = c.update()) == null){ //Use a QuitController instead
            quit();
            return;
        }
        c.setNext(c);
        view.render(c.getView());
        c.register(frame);
        c.addObserver(this);
        frame.revalidate();
        frame.repaint();
    }
}
