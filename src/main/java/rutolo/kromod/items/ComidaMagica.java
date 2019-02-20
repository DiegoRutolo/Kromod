package rutolo.kromod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import rutolo.kromod.Krominit;

public class ComidaMagica extends ItemFood {
	
	public ComidaMagica(String nom, int cant, float satur, boolean paraLobos) {
		super(cant, satur, paraLobos);
		setUnlocalizedName(nom);
		setRegistryName(nom);
		setCreativeTab(Krominit.tabKromod);
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 30*24));
		}
	}
}
