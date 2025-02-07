
package net.mcreator.beastlybeacons.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.beastlybeacons.world.inventory.ActiveBeaconGUIMenu;
import net.mcreator.beastlybeacons.procedures.EnergyInputProcedure;
import net.mcreator.beastlybeacons.procedures.BeaconLockedProcedure;
import net.mcreator.beastlybeacons.BeastlyBeaconsMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record ActiveBeaconGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<ActiveBeaconGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(BeastlyBeaconsMod.MODID, "active_beacon_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ActiveBeaconGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ActiveBeaconGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ActiveBeaconGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<ActiveBeaconGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ActiveBeaconGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = ActiveBeaconGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			EnergyInputProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BeaconLockedProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BeastlyBeaconsMod.addNetworkMessage(ActiveBeaconGUIButtonMessage.TYPE, ActiveBeaconGUIButtonMessage.STREAM_CODEC, ActiveBeaconGUIButtonMessage::handleData);
	}
}
