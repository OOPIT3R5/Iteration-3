package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.TakeableItemVisitor;
import View.Model.MapObjectView;

public class UsableItem extends TakeableItem{

    private Ability ability;

    public UsableItem(Ability ability, String name, MapObjectView mov) {
        super(name, mov);
        this.ability = ability;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void accept(TakeableItemVisitor eiv) {
        eiv.visit(this);
    }

    public void execute() {
        ability.execute();
    }
}
