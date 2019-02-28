package rutolo.kromod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rutolo.kromod.mechanics.OreGen;
import rutolo.kromod.network.KromPacketHandler;

@Mod(modid=Referencia.MODID, name=Referencia.MODNAME, version=Referencia.VERSION, acceptedMinecraftVersions=Referencia.ACCEPT_MINECRAFT)
public class Kromod {
	
	@Instance
	public static Kromod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Krominit.itemsYbloques();
		Krominit.lootTables();
		MinecraftForge.EVENT_BUS.register(new KromEventHandler());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Krominit.recetas();
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		KromPacketHandler.init();
	}
}
