package rutolo.kromod.blocks.desiluminador;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class DesiluminadorSlotSalida extends Slot {

	public DesiluminadorSlotSalida(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
		
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
	
	
}
