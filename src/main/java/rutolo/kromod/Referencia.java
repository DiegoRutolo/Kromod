package rutolo.kromod;

import net.minecraft.entity.player.EntityPlayer;

public class Referencia {
	public static final String MODID = "kromod";
	public static final String MODNAME = "Kromod";
	public static final String VERSION = "0.1";
	public static final String ACCEPT_MINECRAFT = "[1.12]";
	
	// nombres de los objetos, porque no me apetece equivocarme cada vez que tengo que escribir la String
	public static final String CETRO = "cetro";
	public static final String ORICALCO_ORE = "oricalco_ore";
	public static final String ORICALCO_INGOT = "oricalco_ingot";
	public static final String ORICALCO_BLOCK = "oricalco_block";
	public static final String ESCOTRACO_INGOT = "escotraco_ingot";
	public static final String ESCOTRACO_DUST = "escotraco_dust";
	public static final String ESCOTRACO_ORE = "escotraco_ore";
	public static final String GALLETA_MAGICA = "galleta_magica";
	public static final String GRIMORIO = "grimorio";
	
	public static void removeExperience(EntityPlayer entity, int amount){
		// https://github.com/TheHacker000/MineMoneyMod/blob/c77731f6563eb2869fce937b4d4fd98803dd215f/src/main/java/com/thehacker/minemoney/ShopSystem.java#L53-L69
		if (entity.experienceTotal-amount <= 0) {
			return;
		}
		entity.addScore((-1) * amount);
        int j = Integer.MIN_VALUE + entity.experienceTotal;

        if (amount < j)
        {
            amount = j;
        }

        entity.experience -= (float)amount / (float)entity.xpBarCap();

        for (entity.experienceTotal -= amount; entity.experience <= 0.0F; entity.experience /= (float)entity.xpBarCap())
        {
            entity.experience = (entity.experience + 1.0F) * (float)entity.xpBarCap();
            entity.addExperienceLevel(-1);
        }
	}
}
