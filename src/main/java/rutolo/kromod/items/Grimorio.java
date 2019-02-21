package rutolo.kromod.items;

import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import rutolo.kromod.Referencia;
import rutolo.kromod.mechanics.InventarioGrimorio;

public class Grimorio extends ItemMagico {
	public Grimorio() {
		super(Referencia.GRIMORIO);
	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
		return (ICapabilityProvider) new InventarioGrimorio();
	}
}
