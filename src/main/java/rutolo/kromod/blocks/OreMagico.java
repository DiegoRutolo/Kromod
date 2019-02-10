package rutolo.kromod.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class OreMagico extends BloqueMagico {
	
	Item drops;
	int minDrop;
	int maxDrop;
	
	public OreMagico(String nombre) {
		this(nombre, null);
	}
	
	public OreMagico(String nombre, Item drops) {
		this(nombre, drops, 1);
	}
	
	public OreMagico(String nombre, int minDrop, int maxDrop) {
		this(nombre, null, minDrop, maxDrop);
	}
	
	public OreMagico(String nombre, Item drops, int minDrop) {
		this(nombre, drops, minDrop, 1);
	}
	
	public OreMagico(String nombre, Item drops, int minDrop, int maxDrop) {
		this(nombre, drops, minDrop, maxDrop, Material.ROCK);
	}
	
	public OreMagico(String nombre, Item drops, int minDrop, int maxDrop, Material material) {
		super(nombre, material, 0f);
		this.drops = drops;
		this.minDrop = minDrop;
		// controlar que maxDrop >= minDrop
		this.maxDrop = minDrop > maxDrop ? minDrop : maxDrop;
		setHarvestLevel("pickaxe", 2);
		setHardness(3f);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rnd, int fortuna) {
		return drops == null ? Item.getItemFromBlock(this) : this.drops;
	}
	
	@Override
	public int quantityDropped(Random rnd) {
		return drops == null ? 1 : this.minDrop + rnd.nextInt(this.maxDrop - this.minDrop+ 1);
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortuna, Random rnd) {
		if (fortuna <= 0) {
			return quantityDropped(rnd);
		} else {
			return (minDrop+fortuna) + rnd.nextInt(maxDrop*fortuna);
		}
	}
}
