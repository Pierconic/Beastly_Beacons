
package net.mcreator.beastlybeacons.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.beastlybeacons.procedures.PurityCleansingProcedure;

public class PurityMobEffect extends MobEffect {
	public PurityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		PurityCleansingProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
