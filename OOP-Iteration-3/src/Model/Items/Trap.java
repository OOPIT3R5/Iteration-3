package Model.Items;

public class Trap extends TakeDamageAreaEffect{
    private boolean detected;

    public Trap(int damage) {
        super(damage);
        detected = false;
    }

    public boolean isDetected(){
        return detected;
    }

    public void detect(){
        detected = true;
    }
}
