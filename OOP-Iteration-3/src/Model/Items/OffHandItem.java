package Model.Items;

import Model.Entity.Ability.Ability;
import View.Model.MapObjectView;

public abstract class OffHandItem extends EquippableItem{
    public OffHandItem(int statchange, Ability ability, String name, MapObjectView mov) {
        super(statchange, ability, name, mov);
    }
}
