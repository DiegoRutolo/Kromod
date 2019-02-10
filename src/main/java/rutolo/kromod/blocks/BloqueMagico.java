package rutolo.kromod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import rutolo.kromod.Krominit;

public class BloqueMagico extends Block {

	public BloqueMagico(String nombre, Material material) {
		this(nombre, material, 1/15f);
	}
	
	public BloqueMagico(String nombre, Material material, float luz) {
		super(material);
		setUnlocalizedName(nombre);
		setRegistryName(nombre);
		setCreativeTab(Krominit.tabKromod);
		setLightLevel(luz);
	}
}
