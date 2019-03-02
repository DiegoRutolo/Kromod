package rutolo.kromod;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class Referencia {
	public static final String MODID = "kromod";
	public static final String MODNAME = "Kromod";
	public static final String VERSION = "0.1";
	public static final String ACCEPT_MINECRAFT = "[1.12]";
	
	// nombres de los objetos, porque no me apetece equivocarme cada vez que tengo que escribir la String
	// minerales
	public static final String ORICALCO_ORE = "oricalco_ore";
	public static final String ORICALCO_INGOT = "oricalco_ingot";
	public static final String ORICALCO_BLOCK = "oricalco_block";
	public static final String ESCOTRACO_ORE = "escotraco_ore";
	public static final String ESCOTRACO_DUST = "escotraco_dust";
	// items magicos
	public static final String CETRO = "cetro";
	public static final String GRIMORIO = "grimorio";
	// armadura magica
	public static final String GORRO_MAGICO = "gorro_magico";
	// hechizos
	public static final String H_SHUNPO = "h_shunpo";
	public static final String H_BOLA_DE_FUEGO = "h_bola_de_fuego";
	public static final String H_EMPUJON = "h_empujon";
	public static final String H_TIRON = "h_tiron";
	public static final String H_DARDO = "h_dardo";
	public static final String H_POZO_LAVA = "h_pozo_de_lava";
	public static final String H_REVELAR = "h_revelar";
	// consumibles
	public static final String GALLETA_MAGICA = "galleta_magica";
	public static final String GEMA_CURACION = "gema_curacion";
	
	
	public static void removeExperience(EntityPlayer entity, int amount){
		if (entity.experienceTotal-amount <= 0) {
			return;
		}
		// https://github.com/TheHacker000/MineMoneyMod/blob/c77731f6563eb2869fce937b4d4fd98803dd215f/src/main/java/com/thehacker/minemoney/ShopSystem.java#L53-L69
		entity.addScore((-1) * amount);
        int j = Integer.MIN_VALUE + entity.experienceTotal;

        if (amount < j)
        {
            amount = j;
        }

        entity.experience -= (float)amount / (float)entity.xpBarCap();

        for (entity.experienceTotal -= amount; entity.experience <= 0.0F; entity.experience /= (float)entity.xpBarCap())
        {
            entity.experience = (entity.experience + 1.0F) * (float)entity.xpBarCap();
            entity.addExperienceLevel(-1);
        }
	}
	
	// http://www.minecraftforge.net/forum/topic/60098-112-give-potion-effect-to-looking-entity/
	public static Entity getEntityLookingAt() {
		Entity entity = Minecraft.getMinecraft().getRenderViewEntity();
        Entity pointedEntity = null;
        if (entity != null)
        {
            if (Minecraft.getMinecraft().world != null)
            {
                Minecraft.getMinecraft().mcProfiler.startSection("pick");
                Minecraft.getMinecraft().pointedEntity = null;
                double d0 = (double)Minecraft.getMinecraft().playerController.getBlockReachDistance() * 2;
                Minecraft.getMinecraft().objectMouseOver = entity.rayTrace(d0, 20);
                Vec3d vec3d = entity.getPositionEyes(20);
                boolean flag = false;
                //int i = 3;
                double d1 = d0;
	                if (Minecraft.getMinecraft().playerController.extendedReach())
                {
                    //d1 = 6.0D;
                    d1 = 14.0D;
                    d0 = d1;
                }
                else
                {
                    if (d0 > 3.0D)
                    {
                        flag = true;
                    }
                }
	                if (Minecraft.getMinecraft().objectMouseOver != null)
                {
                    d1 = Minecraft.getMinecraft().objectMouseOver.hitVec.distanceTo(vec3d);
                }
	                Vec3d vec3d1 = entity.getLook(1.0F);
                Vec3d vec3d2 = vec3d.addVector(vec3d1.x * d0, vec3d1.y * d0, vec3d1.z * d0);
                pointedEntity = null;
                Vec3d vec3d3 = null;
                //float f = 1.0F;
                List<Entity> list = Minecraft.getMinecraft().world.getEntitiesInAABBexcluding(entity, entity.getEntityBoundingBox().expand(vec3d1.x * d0, vec3d1.y * d0, vec3d1.z * d0).grow(1.0D, 1.0D, 1.0D), Predicates.and(EntitySelectors.NOT_SPECTATING, new Predicate<Entity>()
                {
                    public boolean apply(@Nullable Entity p_apply_1_)
                    {
                        return p_apply_1_ != null && p_apply_1_.canBeCollidedWith();
                    }
                }));
                double d2 = d1;
	                for (int j = 0; j < list.size(); ++j)
                {
                    Entity entity1 = list.get(j);
                    AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow((double)entity1.getCollisionBorderSize());
                    RayTraceResult raytraceresult = axisalignedbb.calculateIntercept(vec3d, vec3d2);
	                    if (axisalignedbb.contains(vec3d))
                    {
                        if (d2 >= 0.0D)
                        {
                            pointedEntity = entity1;
                            vec3d3 = raytraceresult == null ? vec3d : raytraceresult.hitVec;
                            d2 = 0.0D;
                        }
                    }
                    else if (raytraceresult != null)
                    {
                        double d3 = vec3d.distanceTo(raytraceresult.hitVec);
	                        if (d3 < d2 || d2 == 0.0D)
                        {
                            if (entity1.getLowestRidingEntity() == entity.getLowestRidingEntity() && !entity1.canRiderInteract())
                            {
                                if (d2 == 0.0D)
                                {
                                    pointedEntity = entity1;
                                    vec3d3 = raytraceresult.hitVec;
                                }
                            }
                            else
                            {
                                pointedEntity = entity1;
                                vec3d3 = raytraceresult.hitVec;
                                d2 = d3;
                            }
                        }
                    }
                }
	                if (pointedEntity != null && flag && vec3d.distanceTo(vec3d3) > 3.0D)
                {
                    pointedEntity = null;
                    Minecraft.getMinecraft().objectMouseOver = new RayTraceResult(RayTraceResult.Type.MISS, vec3d3, (EnumFacing)null, new BlockPos(vec3d3));
                }
	                if (pointedEntity != null && (d2 < d1 || Minecraft.getMinecraft().objectMouseOver == null))
                {
                    Minecraft.getMinecraft().objectMouseOver = new RayTraceResult(pointedEntity, vec3d3);
	                    if (pointedEntity instanceof EntityLivingBase || pointedEntity instanceof EntityItemFrame)
                    {
                        Minecraft.getMinecraft().pointedEntity = pointedEntity;
                    }
                }
	                Minecraft.getMinecraft().mcProfiler.endSection();
            }
        }
        return pointedEntity;
	}
}
