package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class FriendlyWardBeamDamageProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Creeper) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 20);
		} else if (entity instanceof Monster) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 6);
		}
	}
}
