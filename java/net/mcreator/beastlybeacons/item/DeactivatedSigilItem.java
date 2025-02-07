
package net.mcreator.beastlybeacons.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DeactivatedSigilItem extends Item {
	public DeactivatedSigilItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}
