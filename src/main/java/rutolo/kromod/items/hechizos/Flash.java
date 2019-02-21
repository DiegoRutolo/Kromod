package rutolo.kromod.items.hechizos;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import rutolo.kromod.Referencia;

public class Flash extends Hechizo {
	
	public Flash() {
		super(Referencia.H_FLASH, 2);
	}

	@Override
	public void paraLanzar() {
		if (!world.isRemote) {
			RayTraceResult r = pj.rayTrace((float) 30, 0);
			double x = r.hitVec.x;
			double y = r.hitVec.y;
			double z = r.hitVec.z;
			world.playSound(null, pj.getPosition(), SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
			pj.attemptTeleport(x, y, z);
		}
	}
}
