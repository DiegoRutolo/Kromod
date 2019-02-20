package rutolo.kromod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import rutolo.kromod.Krominit;

public class ItemMagico extends Item {
	
	public ItemMagico (String nombre) {
		setUnlocalizedName(nombre);
		setRegistryName(nombre);
		setCreativeTab(Krominit.tabKromod);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 24*1000;
	}
}
