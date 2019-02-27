package rutolo.kromod.items.hechizos;

import net.minecraft.util.math.RayTraceResult;
import rutolo.kromod.Referencia;
import rutolo.kromod.network.KromPacketHandler;
import rutolo.kromod.network.ShunpoReq;

public class Shunpo extends Hechizo {
	
	public Shunpo() {
		super(Referencia.H_SHUNPO, 2);
	}

	@Override
	public void paraLanzar(int carga) {
		if (world.isRemote) {
			RayTraceResult r = pj.rayTrace((float) 20+10*(carga/24), 0);
			int x = (int) r.hitVec.x;
			int y = (int) r.hitVec.y;
			int z = (int) r.hitVec.z;
//			pj.attemptTeleport(x, y, z);
//			System.out.println("intento de tp a ("+x+", "+y+", "+z+") en cliente");
			KromPacketHandler.INSTANCE.sendToServer(new ShunpoReq(x, y, z));
		}
	}
}
