package rutolo.kromod.hechizos;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import rutolo.kromod.Referencia;

public class BolaDeFuego extends EntitySmallFireball {
	private int coste = 3;
	private int nivel = 1;
	private float vel = 0.2f;
	private World world;
	private EntityPlayer pj;
	
	public BolaDeFuego(World world, EntityPlayer pj) {
		super(world, pj, 1, 1, 1);
		this.world = world;
		this.pj = pj;
		this.posY = pj.posY+1;
		this.accelerationX = pj.getLookVec().x*vel;
		this.accelerationY = pj.getLookVec().y*vel;
		this.accelerationZ = pj.getLookVec().z*vel;
	}
	
	public void lanza() {
		if (pj.isCreative() || pj.experienceTotal-coste >= 0) {
			Referencia.removeExperience(pj, coste);
			world.spawnEntity(this);
		} else {
			pj.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 24*30, nivel));
		}
	}
}
