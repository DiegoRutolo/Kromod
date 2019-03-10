package rutolo.kromod.items;

import net.minecraft.item.Item;
import rutolo.kromod.Krominit;

public class ItemMagico extends Item {
	
	public final String nombre;
	
	public ItemMagico (String nombre) {
		this(nombre, 64);
	}
	
	public ItemMagico (String nombre, int maxStack) {
		this.nombre = nombre;
		setUnlocalizedName(nombre);
		setRegistryName(nombre);
		setCreativeTab(Krominit.tabKromod);
		setMaxStackSize(maxStack);
	}
}
