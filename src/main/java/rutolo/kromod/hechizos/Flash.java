package rutolo.kromod.hechizos;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Flash extends Hechizo {
	
	public Flash(World world, EntityPlayer pj) {
		super(world, pj, 2);
	}

	@Override
	public void paraLanzar() {
		if (!world.isRemote) {
			RayTraceResult r = pj.rayTrace((float) 30, 0);
			double x = r.hitVec.x;
			double y = r.hitVec.y;
			double z = r.hitVec.z;
			
			pj.attemptTeleport(x, y, z);
		}
	}
}
