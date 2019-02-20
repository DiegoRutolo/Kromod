package rutolo.kromod.items;

import rutolo.kromod.Referencia;
import rutolo.kromod.hechizos.Hechizo;

public class Pergamino extends ItemMagico {
	
	public final Hechizo h;

	public Pergamino(Hechizo h) {
		super(Referencia.PERGAMINO);
		this.setMaxStackSize(1);
		this.h = h;
	}
}
