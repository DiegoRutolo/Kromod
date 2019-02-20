package rutolo.kromod.items;

/*
 * https://github.com/coolAlias/Forge_Tutorials/blob/master/InventoryItemTutorial.java
 */

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.ITextComponent;
import rutolo.kromod.Referencia;

public class Grimorio extends ItemMagico implements IInventory {
	
	private final ItemStack stack;
	public static final int TAMANHO = 12;
	private ItemStack[] inventario = new ItemStack[TAMANHO];
	

	public Grimorio(ItemStack stack) {
		super(Referencia.GRIMORIO);
		this.stack = stack;
		if (!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
		}
		readFromNBT(stack.getTagCompound());
	}
	
	@Override
	public int getSizeInventory() {
		return TAMANHO;
	}
	
	@Override
	public ItemStack getStackInSlot(int index) {
		return inventario[index];
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	public void readFromNBT(NBTTagCompound tagCompound) {
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	

	

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
