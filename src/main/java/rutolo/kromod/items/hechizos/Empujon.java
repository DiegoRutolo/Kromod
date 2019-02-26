package rutolo.kromod.items.hechizos;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.util.math.Vec3d;
import rutolo.kromod.Referencia;

public class Empujon extends Hechizo {

	public Empujon() {
		super(Referencia.H_EMPUJON, 1);
	}

	@Override
	public void paraLanzar(int carga) {
		Entity obj = Referencia.getEntityLookingAt();
		if (obj != null) {
			Vec3d v = pj.getLookVec().scale(5);
			double x = v.x+obj.posX;
			double y = v.y+obj.posY;
			double z = v.z+obj.posZ;
			if (true) {
				System.out.println("\n"+x+"\n"+y+"\n"+z);
				obj.move(MoverType.PISTON, x, y, z);
				
			}
		}
	}
}
