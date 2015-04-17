package Model.Items;

import Model.Entity.Ability.Ability;
import Model.Entity.Entity;

public class AccessoryItem extends EquippableItem {
    public AccessoryItem(Ability ability, String name) {
        super(ability, name);
    }

    @Override
    public void execute(Entity entity) {

    }
}
