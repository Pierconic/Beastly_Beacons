package net.mcreator.beastlybeacons.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.beastlybeacons.world.inventory.ActiveBeaconGUIMenu;
import net.mcreator.beastlybeacons.procedures.SigilIndicatorDisplayProcedure;
import net.mcreator.beastlybeacons.procedures.ReverseTypeCheckProcedure;
import net.mcreator.beastlybeacons.procedures.ReverseMidLayerCheckProcedure;
import net.mcreator.beastlybeacons.procedures.ReverseBottomLayerCheckProcedure;
import net.mcreator.beastlybeacons.procedures.MissingPowerProcedure;
import net.mcreator.beastlybeacons.procedures.MissingLayer3Procedure;
import net.mcreator.beastlybeacons.procedures.MissingLayer2Procedure;
import net.mcreator.beastlybeacons.procedures.MissingExperienceProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect9CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect8CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect7CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect6CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect5CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect4CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect3CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect2CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect1CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect15CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect14CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect13CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect12CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect11CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EvilEffect10CheckProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode9DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode8DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode7DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode6DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode5DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode4DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode3DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode2DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode20DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode1DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode19DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode18DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode17DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode16DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode15DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode14DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode13DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode12DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode11DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.EnergyNode10DisplayProcedure;
import net.mcreator.beastlybeacons.procedures.Effect9CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect8CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect7CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect6CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect5CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect4CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect3CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect2CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect1CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect15CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect14CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect13CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect12CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect11CheckProcedure;
import net.mcreator.beastlybeacons.procedures.Effect10CheckProcedure;
import net.mcreator.beastlybeacons.procedures.BeaconTypeCheckProcedure;
import net.mcreator.beastlybeacons.procedures.BeaconCapacityProcedure;
import net.mcreator.beastlybeacons.network.ActiveBeaconGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ActiveBeaconGUIScreen extends AbstractContainerScreen<ActiveBeaconGUIMenu> {
	private final static HashMap<String, Object> guistate = ActiveBeaconGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_expbuttonunpressed;
	ImageButton imagebutton_lockbuttonunpressed;

	public ActiveBeaconGUIScreen(ActiveBeaconGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 220;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("beastly_beacons:textures/screens/active_beacon_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + -2 && mouseX < leftPos + 22 && mouseY > topPos + 143 && mouseY < topPos + 167)
			guiGraphics.renderTooltip(font, Component.translatable("gui.beastly_beacons.active_beacon_gui.tooltip_power_the_beacon_using_experienc"), mouseX, mouseY);
		if (mouseX > leftPos + 192 && mouseX < leftPos + 216 && mouseY > topPos + 135 && mouseY < topPos + 159)
			guiGraphics.renderTooltip(font, Component.translatable("gui.beastly_beacons.active_beacon_gui.tooltip_lock_the_beacon_using_a_sigil"), mouseX, mouseY);
		if (mouseX > leftPos + 221 && mouseX < leftPos + 245 && mouseY > topPos + -5 && mouseY < topPos + 19)
			guiGraphics.renderTooltip(font, Component.translatable("gui.beastly_beacons.active_beacon_gui.tooltip_tier_1_abilities"), mouseX, mouseY);
		if (mouseX > leftPos + 222 && mouseX < leftPos + 246 && mouseY > topPos + 39 && mouseY < topPos + 63)
			guiGraphics.renderTooltip(font, Component.translatable("gui.beastly_beacons.active_beacon_gui.tooltip_tier_2_abilities"), mouseX, mouseY);
		if (mouseX > leftPos + 221 && mouseX < leftPos + 245 && mouseY > topPos + 84 && mouseY < topPos + 108)
			guiGraphics.renderTooltip(font, Component.translatable("gui.beastly_beacons.active_beacon_gui.tooltip_tier_3_abilities"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (SigilIndicatorDisplayProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/sigilindicator.png"), this.leftPos + 197, this.topPos + 177, 0, 0, 16, 16, 16, 16);
		}

		guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/activatedbeaconinterface.png"), this.leftPos + -8, this.topPos + -18, 0, 0, 230, 219, 230, 219);

		if (EnergyNode1DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expbase.png"), this.leftPos + 81, this.topPos + 104, 0, 0, 7, 11, 7, 11);
		}
		if (EnergyNode2DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 97, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode3DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 92, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode4DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 86, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode5DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 80, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode6DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 74, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode7DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 68, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode8DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 62, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode9DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 56, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode10DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 50, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode11DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 44, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode12DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode13DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 32, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode14DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 26, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode15DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 20, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode16DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 14, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode17DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 8, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode18DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + 2, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode19DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/expmiddle.png"), this.leftPos + 81, this.topPos + -4, 0, 0, 7, 7, 7, 7);
		}
		if (EnergyNode20DisplayProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/exptop.png"), this.leftPos + 81, this.topPos + -14, 0, 0, 7, 11, 7, 11);
		}

		guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/costoverlays.png"), this.leftPos + 217, this.topPos + -12, 0, 0, 31, 128, 31, 128);

		if (ReverseMidLayerCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/costlockii.png"), this.leftPos + 222, this.topPos + 37, 0, 0, 20, 30, 20, 30);
		}
		if (ReverseBottomLayerCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/costlockiii.png"), this.leftPos + 222, this.topPos + 81, 0, 0, 20, 30, 20, 30);
		}
		if (Effect1CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator.png"), this.leftPos + 92, this.topPos + -14, 0, 0, 26, 22, 26, 22);
		}
		if (Effect2CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator.png"), this.leftPos + 117, this.topPos + -14, 0, 0, 26, 22, 26, 22);
		}
		if (Effect3CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator.png"), this.leftPos + 141, this.topPos + -14, 0, 0, 26, 22, 26, 22);
		}
		if (Effect4CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator.png"), this.leftPos + 166, this.topPos + -14, 0, 0, 26, 22, 26, 22);
		}
		if (Effect5CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator.png"), this.leftPos + 191, this.topPos + -14, 0, 0, 26, 22, 26, 22);
		}
		if (Effect10CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator2.png"), this.leftPos + 191, this.topPos + 29, 0, 0, 26, 23, 26, 23);
		}
		if (Effect7CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator2.png"), this.leftPos + 117, this.topPos + 29, 0, 0, 26, 23, 26, 23);
		}
		if (Effect8CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator2.png"), this.leftPos + 141, this.topPos + 29, 0, 0, 26, 23, 26, 23);
		}
		if (Effect9CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator2.png"), this.leftPos + 166, this.topPos + 29, 0, 0, 26, 23, 26, 23);
		}
		if (Effect6CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator2.png"), this.leftPos + 92, this.topPos + 29, 0, 0, 26, 23, 26, 23);
		}
		if (MissingPowerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/errorcapacity.png"), this.leftPos + 2, this.topPos + 91, 0, 0, 72, 21, 72, 21);
		}
		if (MissingExperienceProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/errorexperience.png"), this.leftPos + 81, this.topPos + -14, 0, 0, 7, 129, 7, 129);
		}
		if (MissingLayer2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/errorsecondlayer.png"), this.leftPos + 13, this.topPos + 34, 0, 0, 50, 10, 50, 10);
		}
		if (MissingLayer3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/errorthirdlayer.png"), this.leftPos + 3, this.topPos + 78, 0, 0, 70, 10, 70, 10);
		}
		if (Effect11CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator2.png"), this.leftPos + 92, this.topPos + 72, 0, 0, 26, 23, 26, 23);
		}
		if (Effect12CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator2.png"), this.leftPos + 117, this.topPos + 72, 0, 0, 26, 23, 26, 23);
		}
		if (Effect13CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator2.png"), this.leftPos + 141, this.topPos + 72, 0, 0, 26, 23, 26, 23);
		}
		if (Effect14CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator2.png"), this.leftPos + 166, this.topPos + 72, 0, 0, 26, 23, 26, 23);
		}
		if (BeaconTypeCheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconoverlay.png"), this.leftPos + -8, this.topPos + -18, 0, 0, 230, 219, 230, 219);
		}
		if (Effect15CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/friendlybeaconindicator2.png"), this.leftPos + 191, this.topPos + 72, 0, 0, 26, 23, 26, 23);
		}
		if (EvilEffect1CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator.png"), this.leftPos + 92, this.topPos + -14, 0, 0, 26, 22, 26, 22);
		}
		if (EvilEffect2CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator.png"), this.leftPos + 117, this.topPos + -14, 0, 0, 26, 22, 26, 22);
		}
		if (EvilEffect3CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator.png"), this.leftPos + 141, this.topPos + -14, 0, 0, 26, 22, 26, 22);
		}
		if (EvilEffect4CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator.png"), this.leftPos + 166, this.topPos + -14, 0, 0, 26, 22, 26, 22);
		}
		if (EvilEffect5CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator.png"), this.leftPos + 191, this.topPos + -14, 0, 0, 26, 22, 26, 22);
		}
		if (EvilEffect6CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator2.png"), this.leftPos + 92, this.topPos + 29, 0, 0, 26, 23, 26, 23);
		}
		if (EvilEffect7CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator2.png"), this.leftPos + 117, this.topPos + 29, 0, 0, 26, 23, 26, 23);
		}
		if (EvilEffect8CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator2.png"), this.leftPos + 141, this.topPos + 29, 0, 0, 26, 23, 26, 23);
		}
		if (EvilEffect9CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator2.png"), this.leftPos + 166, this.topPos + 29, 0, 0, 26, 23, 26, 23);
		}
		if (EvilEffect10CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator2.png"), this.leftPos + 191, this.topPos + 29, 0, 0, 26, 23, 26, 23);
		}
		if (EvilEffect11CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator2.png"), this.leftPos + 92, this.topPos + 72, 0, 0, 26, 23, 26, 23);
		}
		if (EvilEffect12CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator2.png"), this.leftPos + 117, this.topPos + 72, 0, 0, 26, 23, 26, 23);
		}
		if (EvilEffect13CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator2.png"), this.leftPos + 141, this.topPos + 72, 0, 0, 26, 23, 26, 23);
		}
		if (EvilEffect14CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator2.png"), this.leftPos + 166, this.topPos + 72, 0, 0, 26, 23, 26, 23);
		}
		if (EvilEffect15CheckProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("beastly_beacons:textures/screens/evilbeaconindicator2.png"), this.leftPos + 191, this.topPos + 72, 0, 0, 26, 23, 26, 23);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				BeaconCapacityProcedure.execute(world, x, y, z), 18, 68, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_expbuttonunpressed = new ImageButton(this.leftPos + -1, this.topPos + 119, 24, 75,
				new WidgetSprites(ResourceLocation.parse("beastly_beacons:textures/screens/expbuttonunpressed.png"), ResourceLocation.parse("beastly_beacons:textures/screens/expbuttonpressed.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ActiveBeaconGUIButtonMessage(0, x, y, z));
						ActiveBeaconGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_expbuttonunpressed", imagebutton_expbuttonunpressed);
		this.addRenderableWidget(imagebutton_expbuttonunpressed);
		imagebutton_lockbuttonunpressed = new ImageButton(this.leftPos + 193, this.topPos + 120, 23, 51,
				new WidgetSprites(ResourceLocation.parse("beastly_beacons:textures/screens/lockbuttonunpressed.png"), ResourceLocation.parse("beastly_beacons:textures/screens/lockbuttonpressed.png")), e -> {
					if (ReverseTypeCheckProcedure.execute(world, x, y, z)) {
						PacketDistributor.sendToServer(new ActiveBeaconGUIButtonMessage(1, x, y, z));
						ActiveBeaconGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ReverseTypeCheckProcedure.execute(world, x, y, z))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_lockbuttonunpressed", imagebutton_lockbuttonunpressed);
		this.addRenderableWidget(imagebutton_lockbuttonunpressed);
	}
}
