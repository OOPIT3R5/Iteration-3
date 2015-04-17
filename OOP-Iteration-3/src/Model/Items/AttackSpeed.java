package Model.Items;

public enum AttackSpeed {
        FAST(1),
        MEDIUM(2),
        SLOW(3);

        private final int speedconst; //This is a speed constant.

        AttackSpeed(int speedconst){
            this.speedconst = speedconst;
        }
}
