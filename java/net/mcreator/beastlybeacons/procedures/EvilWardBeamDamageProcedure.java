package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModMobEffects;

public class EvilWardBeamDamageProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player && entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(BeastlyBeaconsModMobEffects.MALEVOLENCE)) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC)), 3);
		}
	}
}
