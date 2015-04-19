package Model.Items;

import View.Model.MapObjectView;

public class Trap extends TakeDamageAreaEffect{
    private boolean detected;

    public Trap(int damage, MapObjectView mov) {
        super(damage, mov);
        detected = false;
    }

    public boolean isDetected(){
        return detected;
    }

    public void detect(){
        detected = true;
    }
}
