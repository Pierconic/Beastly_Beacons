
package net.mcreator.beastlybeacons.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.beastlybeacons.procedures.SigilTickProcedure;

public class ActiveSigilItem extends Item {
	public ActiveSigilItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		SigilTickProcedure.execute(entity, itemstack, slot);
	}
}
