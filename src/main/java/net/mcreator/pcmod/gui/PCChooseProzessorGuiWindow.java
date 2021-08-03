
package net.mcreator.pcmod.gui;

import net.mcreator.pcmod.PcmodMod;

@OnlyIn(Dist.CLIENT)
public class PCChooseProzessorGuiWindow extends ContainerScreen<PCChooseProzessorGui.GuiContainerMod> {

	private World world;
	private int x, y, z;
	private PlayerEntity entity;

	public PCChooseProzessorGuiWindow(PCChooseProzessorGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("pcmod:textures/pc_choose_prozessor.png");

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.blit(ms, k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}

		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "PC Configurator", 6, 7, -12829636);
		this.font.drawString(ms, "Choose your prozessor type", 6, 25, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);

		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 52, 55, 20, new StringTextComponent("Mintel"), e -> {
			if (true) {
				PcmodMod.PACKET_HANDLER.sendToServer(new PCChooseProzessorGui.ButtonPressedMessage(0, x, y, z));
				PCChooseProzessorGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 123, this.guiTop + 52, 40, 20, new StringTextComponent("MMD"), e -> {
			if (true) {
				PcmodMod.PACKET_HANDLER.sendToServer(new PCChooseProzessorGui.ButtonPressedMessage(1, x, y, z));
				PCChooseProzessorGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
	}

}
