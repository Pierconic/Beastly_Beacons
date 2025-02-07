package net.mcreator.beastlybeacons.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModMobEffects;
import net.mcreator.beastlybeacons.init.BeastlyBeaconsModItems;

public class SigilTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack, double slot) {
		if (entity == null)
			return;
		boolean found = false;
		ItemStack NewSigil = ItemStack.EMPTY;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE))) {
			NewSigil = new ItemStack(BeastlyBeaconsModItems.DEACTIVATED_SIGIL.get());
			NewSigil.set(DataComponents.CUSTOM_NAME, Component.literal((((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", ""))));
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
				ItemStack _setstack = NewSigil.copy();
				_setstack.setCount(1);
				_modHandler.setStackInSlot((int) slot, _setstack);
			}
		}
	}
}
