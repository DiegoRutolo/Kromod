package rutolo.kromod.items.hechizos;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import rutolo.kromod.Referencia;
import rutolo.kromod.items.ItemMagico;

public abstract class Hechizo extends ItemMagico {

	int coste;
	int nivel;
	protected World world;
	protected EntityPlayer pj;
	
	public Hechizo(String nombre, int nivel) {
		this(nombre, nivel, 2*nivel);
	}
	
	public Hechizo(String nombre, int nivel, int coste) {
		super(nombre);
		this.nivel = nivel;
		this.coste = coste;
		this.setMaxStackSize(1);
	}
	
	public void lanzar(World world, EntityPlayer pj) {
		this.world = world;
		this.pj = pj;
		if (pj.isCreative() || pj.experienceTotal-coste >= 0) {
			Referencia.removeExperience(pj, coste);
			this.paraLanzar();
		} else {
			pj.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 24*10*nivel, nivel));
		}
	}
	
	public abstract void paraLanzar();
}
