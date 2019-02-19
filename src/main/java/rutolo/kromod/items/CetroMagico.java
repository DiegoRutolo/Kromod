package rutolo.kromod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import rutolo.kromod.Referencia;

public class CetroMagico extends ItemMagico {
	
	public CetroMagico(String nombre) {
		super(nombre);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		EntityFireball boladefuego = new EntitySmallFireball(worldIn, playerIn, 1, 1, 1);
		double vel = 0.1;
		boladefuego.posY = playerIn.posY+1;
		boladefuego.accelerationX = playerIn.getLookVec().x*vel;
		boladefuego.accelerationY = playerIn.getLookVec().y*vel;
		boladefuego.accelerationZ = playerIn.getLookVec().z*vel;
		Referencia.removeExperience(playerIn, 10);
		worldIn.spawnEntity(boladefuego);
		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
	
	
}
