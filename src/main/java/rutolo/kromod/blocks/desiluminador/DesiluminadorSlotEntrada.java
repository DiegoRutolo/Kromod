package rutolo.kromod.blocks.desiluminador;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DesiluminadorSlotEntrada extends Slot {
	
	public DesiluminadorSlotEntrada(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if (stack.getItem().equals(Item.getItemFromBlock(Blocks.TORCH))) {
			return true;
		} else {
			return false;
		}
	}
}
