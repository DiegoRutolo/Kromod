package rutolo.kromod.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import rutolo.kromod.Referencia;

public class GemaCuracion extends ItemMagico {

	public GemaCuracion() {
		super(Referencia.GEMA_CURACION, 16);
	}
	
	@Override
	public boolean hasEffect(ItemStack items) {
		return true;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		 return 16;
    }
	

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.setActiveHand(handIn);
		if (playerIn.shouldHeal()) {
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
		} else {
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(handIn));
		}
    }
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase pj, int timeLeft) {
		if (pj instanceof EntityPlayer) {
			if (((EntityPlayer) pj).shouldHeal()) {
				pj.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 30));
				stack.shrink(1);
			}
		}
    }
}
