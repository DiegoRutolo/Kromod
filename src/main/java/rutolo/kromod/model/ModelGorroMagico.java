package rutolo.kromod.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGorroMagico extends ModelBiped {
	//fields
	ModelRenderer ala;
	ModelRenderer cinturon;
	ModelRenderer sec1;
	ModelRenderer sec2;
	ModelRenderer sec3;
	ModelRenderer sec4;

	public ModelGorroMagico() {
		textureWidth = 64;
		textureHeight = 64;
		ala = new ModelRenderer(this, 0, 0);
		ala.addBox(-6F, -8F, -6F, 12, 1, 12);
		ala.setRotationPoint(0F, 0F, 0F);
		ala.setTextureSize(64, 64);
		ala.mirror = true;
		setRotation(ala, 0F, 0F, 0F);
		cinturon = new ModelRenderer(this, 0, 14);
		cinturon.addBox(-4F, -10F, -4F, 8, 2, 8);
		cinturon.setRotationPoint(0F, 0F, 0F);
		cinturon.setTextureSize(64, 64);
		cinturon.mirror = true;
		setRotation(cinturon, 0F, 0F, 0F);
		sec1 = new ModelRenderer(this, 0, 25);
		sec1.addBox(-4F, -11F, -4F, 8, 1, 8);
		sec1.setRotationPoint(0F, 0F, 0F);
		sec1.setTextureSize(64, 64);
		sec1.mirror = true;
		setRotation(sec1, 0F, 0F, 0F);
		sec2 = new ModelRenderer(this, 0, 35);
		sec2.addBox(-3F, -13F, -3F, 6, 2, 6);
		sec2.setRotationPoint(0F, 0F, 0F);
		sec2.setTextureSize(64, 64);
		sec2.mirror = true;
		setRotation(sec2, 0F, 0F, 0F);
		sec3 = new ModelRenderer(this, 33, 14);
		sec3.addBox(-2F, -15F, -2F, 4, 2, 4);
		sec3.setRotationPoint(0F, 0F, 0F);
		sec3.setTextureSize(64, 64);
		sec3.mirror = true;
		setRotation(sec3, 0F, 0F, 0F);
		sec4 = new ModelRenderer(this, 33, 21);
		sec4.addBox(-1F, -17F, -1F, 2, 2, 2);
		sec4.setRotationPoint(0F, 0F, 0F);
		sec4.setTextureSize(64, 64);
		sec4.mirror = true;
		setRotation(sec4, 0F, 0F, 0F);
		
		this.bipedHead.addChild(ala);
		this.bipedHead.addChild(cinturon);
		this.bipedHead.addChild(sec1);
		this.bipedHead.addChild(sec2);
		this.bipedHead.addChild(sec3);
		this.bipedHead.addChild(sec4);
  }

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
//		ala.render(f5);
//		cinturon.render(f5);
//		sec1.render(f5);
//		sec2.render(f5);
//		sec3.render(f5);
//		sec4.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
