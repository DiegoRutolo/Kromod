package rutolo.kromod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import rutolo.kromod.hechizos.BolaDeFuego;

public class CetroMagico extends ItemMagico {
	
	public CetroMagico(String nombre) {
		super(nombre);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		BolaDeFuego bolaDeFuego = new BolaDeFuego(worldIn, playerIn);
		bolaDeFuego.lanza();
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
