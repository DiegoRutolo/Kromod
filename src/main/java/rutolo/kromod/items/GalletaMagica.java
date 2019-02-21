package rutolo.kromod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import rutolo.kromod.Krominit;
import rutolo.kromod.Referencia;

public class GalletaMagica extends ItemFood {
	
	public GalletaMagica() {
		super(3, 0.5f, false);
		setUnlocalizedName(Referencia.GALLETA_MAGICA);
		setRegistryName(Referencia.GALLETA_MAGICA);
		setCreativeTab(Krominit.tabKromod);
		setMaxStackSize(8);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 30*24));
		}
	}
}
