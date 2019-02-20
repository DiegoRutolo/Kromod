package rutolo.kromod.hechizos;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.world.World;

public class BolaDeFuego extends Hechizo {
	
	public BolaDeFuego(World world, EntityPlayer pj) {
		super(world, pj, 1);
	}
	
	@Override
	public void paraLanzar() {
		EntitySmallFireball bola = new EntitySmallFireball(this.world, this.pj, 1, 1, 1);
		float vel = 0.1f;
		bola.posY = pj.posY+1;
		bola.accelerationX = pj.getLookVec().x*vel;
		bola.accelerationY = pj.getLookVec().y*vel;
		bola.accelerationZ = pj.getLookVec().z*vel;
		this.world.spawnEntity(bola);
	}
}
