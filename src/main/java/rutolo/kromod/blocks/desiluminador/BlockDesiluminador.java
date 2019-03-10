package rutolo.kromod.blocks.desiluminador;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import rutolo.kromod.Kromod;
import rutolo.kromod.Referencia;
import rutolo.kromod.blocks.BloqueMagico;

public class BlockDesiluminador extends BloqueMagico {
	
	public BlockDesiluminador() {
		super(Referencia.DESILUMINADOR, Material.IRON);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if (!world.isRemote) {
			player.openGui(Kromod.instance, Referencia.GUI_DESILUMINADOR, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
}
