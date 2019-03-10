package rutolo.kromod.blocks.desiluminador;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import rutolo.kromod.Referencia;

public class GuiDesiluminador extends GuiContainer {
	
	public GuiDesiluminador(InventoryPlayer invent, World world, BlockPos pos) {
		super(new ContainerDesiluminador(invent, world, pos));
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	        super.drawScreen(mouseX, mouseY, partialTicks);
	        this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(Referencia.MODID+":textures/gui/"+Referencia.DESILUMINADOR+".png"));
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}
	
	 @Override
	 protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
	        this.fontRenderer.drawString(I18n.format("Desiluminador"), 28, 6, 4210752);
	        this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	 }
}
