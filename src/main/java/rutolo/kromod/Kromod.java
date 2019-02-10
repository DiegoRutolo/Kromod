package rutolo.kromod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Referencia.MODID, name=Referencia.MODNAME, version=Referencia.VERSION, acceptedMinecraftVersions=Referencia.ACCEPT_MINECRAFT)
public class Kromod {
	
	@Instance
	public static Kromod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Krominit.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Krominit.recetas();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
