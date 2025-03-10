package net.mcreator.beastlybeacons.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.init.BeastlyBeaconsModMobEffects;

public class BeaconEffectAlertProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE) ? _livEnt.getEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE).getDuration() : 0) == 1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.deactivate")), SoundSource.NEUTRAL, 1, (float) 1.5, false);
					}
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE) ? _livEnt.getEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE).getDuration() : 0) == 280) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.beacon.activate")), SoundSource.NEUTRAL, 1, (float) 1.5, false);
					}
				}
			}
			if (entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(BeastlyBeaconsModMobEffects.MALEVOLENCE)) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(BeastlyBeaconsModMobEffects.BENEVOLENCE);
			}
		}
	}
}
