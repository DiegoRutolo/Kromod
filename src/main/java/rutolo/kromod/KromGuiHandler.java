package rutolo.kromod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rutolo.kromod.blocks.desiluminador.ContainerDesiluminador;
import rutolo.kromod.blocks.desiluminador.GuiDesiluminador;

public class KromGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Referencia.GUI_DESILUMINADOR) {
			return new ContainerDesiluminador(player.inventory, world, new BlockPos(x, y, z));
		} else {
			return null;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == Referencia.GUI_DESILUMINADOR) {
			return new GuiDesiluminador(player.inventory, world, new BlockPos(x, y, z));
		} else {
			return null;
		}
	}

}
