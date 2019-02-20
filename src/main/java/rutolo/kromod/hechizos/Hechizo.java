package rutolo.kromod.hechizos;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import rutolo.kromod.Referencia;

public abstract class Hechizo {

	int coste;
	int nivel;
	protected World world;
	protected EntityPlayer pj;
	
	public Hechizo(World world, EntityPlayer pj, int nivel) {
		this(world, pj, nivel, 2*nivel);
	}
	
	public Hechizo(World world, EntityPlayer pj, int nivel, int coste) {
		this.world = world;
		this.pj = pj;
		this.nivel = nivel;
		this.coste = coste;
	}
	
	public void lanzar() {
		if (pj.isCreative() || pj.experienceTotal-coste >= 0) {
			Referencia.removeExperience(pj, coste);
			this.paraLanzar();
		} else {
			pj.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 24*10*nivel, nivel));
		}
	}
	
	public abstract void paraLanzar();
}
