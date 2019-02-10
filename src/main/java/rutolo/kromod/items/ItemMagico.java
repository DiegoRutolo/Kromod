package rutolo.kromod.items;

import net.minecraft.item.Item;
import rutolo.kromod.Krominit;

public class ItemMagico extends Item {
	
	public ItemMagico (String nombre) {
		setUnlocalizedName(nombre);
		setRegistryName(nombre);
		setCreativeTab(Krominit.tabKromod);
	}
}
