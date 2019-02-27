package rutolo.kromod.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import rutolo.kromod.Referencia;

public class KromPacketHandler {
	
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Referencia.MODID);
	private static int id = 1;
	
	public static void init() {
		INSTANCE.registerMessage(ShunpoReqHandler.class, ShunpoReq.class, id++, Side.SERVER);
	}
}
