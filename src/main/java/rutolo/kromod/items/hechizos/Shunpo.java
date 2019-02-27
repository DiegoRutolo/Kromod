package rutolo.kromod.items.hechizos;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import rutolo.kromod.Referencia;

public class Shunpo extends Hechizo {
	
	public Shunpo() {
		super(Referencia.H_SHUNPO, 2);
	}

	@Override
	public void paraLanzar(int carga) {
		if (!world.isRemote) {
			System.out.println("Flash");
			RayTraceResult r = pj.rayTrace((float) 20+10*(carga/24), 0);
			world.playSound(null, pj.getPosition(), SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
			pj.attemptTeleport(r.hitVec.x, r.hitVec.y, r.hitVec.z);
		}
	}
}
