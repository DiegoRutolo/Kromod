package rutolo.kromod.items.hechizos;

import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import rutolo.kromod.Referencia;

public class BolaDeFuego extends Hechizo {
	
	public BolaDeFuego() {
		super(Referencia.H_BOLA_DE_FUEGO, 1);
	}
	
	@Override
	public void paraLanzar() {
		EntitySmallFireball bola = new EntitySmallFireball(this.world, this.pj, 1, 1, 1);
		float vel = 0.1f;
		bola.posY = pj.posY+1;
		bola.accelerationX = pj.getLookVec().x*vel;
		bola.accelerationY = pj.getLookVec().y*vel;
		bola.accelerationZ = pj.getLookVec().z*vel;
		world.playSound(null, pj.getPosition(), SoundEvents.ENTITY_FIREWORK_LAUNCH, SoundCategory.PLAYERS, 1.0f, 1.0f);
		this.world.spawnEntity(bola);
	}
}
