package rutolo.kromod.blocks.desiluminador;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import rutolo.kromod.Krominit;
import rutolo.kromod.Referencia;

public class ContainerDesiluminador extends Container {
	
	private final World world;
	private final BlockPos pos;
	private final int ID_IN = 100;
	private final int ID_O1 = 101;
	private final int ID_O2 = 102;

	public ContainerDesiluminador(InventoryPlayer playerInventory, World world, BlockPos pos) {
		this.world = world;
		this.pos = pos;
		
		// TODO: cambiar la entrada y salida por matrices de 2x2
		//Entrada
		this.addSlotToContainer(new DesiluminadorSlotEntrada(playerInventory, ID_IN, 44, 35));
		this.addSlotToContainer(new DesiluminadorSlotSalida(playerInventory, ID_O1, 110, 18));
		this.addSlotToContainer(new DesiluminadorSlotSalida(playerInventory, ID_O2, 110, 52));
		
		addPlayerSlots(playerInventory);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        return ItemStack.EMPTY;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		if (!this.world.getBlockState(this.pos).getBlock().equals(Krominit.bloques.get(Referencia.DESILUMINADOR))) {
            return false;
        } else {
            return playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
	}
	
	private void addPlayerSlots(IInventory playerInventory) {
		int dh = 84;
        // Slots for the main inventory
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                int x = 8 + col * 18;
                int y = row * 18 + dh;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 10, x, y));
            }
        }

        // Slots for the hotbar
        for (int row = 0; row < 9; ++row) {
            int x = 8 + row * 18;
            int y = 58 + dh;
            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
        }
    }

}
