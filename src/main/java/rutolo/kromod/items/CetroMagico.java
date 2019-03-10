package rutolo.kromod.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import rutolo.kromod.Referencia;
import rutolo.kromod.items.hechizos.Hechizo;

public class CetroMagico extends ItemMagico {
	
	private final static int TMAX = 20*10;
	
	public CetroMagico() {
		super(Referencia.CETRO, 1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase pj, int timeLeft) {
		if (pj instanceof EntityPlayer) {
			if (pj.getHeldItemOffhand().getItem() instanceof Hechizo) {
				((Hechizo) pj.getHeldItemOffhand().getItem()).lanzar(world, (EntityPlayer) pj, TMAX-timeLeft);
			}
		}
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return TMAX;
	}
}
