package rutolo.kromod.items.armor;

import javax.annotation.Nullable;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rutolo.kromod.Krominit;
import rutolo.kromod.Referencia;
import rutolo.kromod.model.ModelGorroMagico;

public class GorroMagico extends ItemArmor {
	
	public GorroMagico() {
		super(ArmorMaterial.DIAMOND, 0, EntityEquipmentSlot.HEAD);
		this.setUnlocalizedName(Referencia.GORRO_MAGICO);
		this.setRegistryName(Referencia.GORRO_MAGICO);
		this.setCreativeTab(Krominit.tabKromod);
	}

	@Override
	@SideOnly(Side.CLIENT)
	@Nullable
	public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, EntityEquipmentSlot slot, ModelBiped defaultModel) {
		if (!stack.isEmpty()) {
			if (stack.getItem() instanceof ItemArmor) {
				ModelGorroMagico modelGorro = new ModelGorroMagico();
				
				modelGorro.isSneak = defaultModel.isSneak;
				modelGorro.isRiding = defaultModel.isRiding;
				modelGorro.isChild = defaultModel.isChild;
				
				return modelGorro;
			}
		}
		
		return null;
	}
	
	@Override
	@Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
        return Referencia.MODID+":textures/models/armor/"+Referencia.GORRO_MAGICO+".png";
    }
}
