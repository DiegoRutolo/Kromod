package rutolo.kromod.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import rutolo.kromod.hechizos.BolaDeFuego;
import rutolo.kromod.hechizos.Hechizo;

public class CetroMagico extends ItemMagico {
	
	public CetroMagico(String nombre) {
		super(nombre);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
	//	Hechizo bolaDeFuego = new BolaDeFuego(worldIn, playerIn);
	//	bolaDeFuego.lanzar();
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		System.out.println("asdf");
		if (entityLiving instanceof EntityPlayer) {
			Hechizo bolaDeFuego = new BolaDeFuego(worldIn, (EntityPlayer) entityLiving);
			bolaDeFuego.lanzar();
		}
    }
}
