package rutolo.kromod.network;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ShunpoReqHandler implements IMessageHandler<ShunpoReq, IMessage> {

	@Override
	public IMessage onMessage(ShunpoReq message, MessageContext ctx) {
		EntityPlayerMP pj = ctx.getServerHandler().player;
		double x = message.x;
		double y = message.y;
		double z = message.z;
		pj.getServerWorld().addScheduledTask(() -> {
			pj.getServerWorld().playSound(null, pj.getPosition(), SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
			pj.attemptTeleport(x, y, z);
			System.out.println("intento de tp a ("+x+", "+y+", "+z+") en server");
	    });
		return null;
	}
}
