package rutolo.kromod.mechanics;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import rutolo.kromod.Krominit;
import rutolo.kromod.Referencia;

public class OreGen implements IWorldGenerator {

	@Override
	public void generate(Random rnd, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		if (world.provider.getDimension() == 0) {
			runGenerator(Krominit.bloques.get(Referencia.ORICALCO_ORE).getDefaultState(), 7, 5, 5, 30, 
					BlockMatcher.forBlock(Blocks.STONE), world, rnd, chunkX, chunkZ);
			if (world.getBiome(new BlockPos(chunkX*16, 20, chunkZ*16)).equals(Biomes.EXTREME_HILLS) ) {
				runGenerator(Krominit.bloques.get(Referencia.ESCOTRACO_ORE).getDefaultState(), 20, 2, 5, 50, 
						BlockMatcher.forBlock(Blocks.STONE), world, rnd, chunkX, chunkZ);
			}
		}
		
	}
	
	private void runGenerator(IBlockState b, int taMax, int prob, int minH, int maxH,
			Predicate<IBlockState> br, World world, Random rnd, int chunkX, int chunkZ) {
		
		if (minH < 0 || maxH > 256 || minH > maxH) {
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
		}
		
		WorldGenMinable generador = new WorldGenMinable(b, taMax, br);
		int difH = maxH - minH + 1;
		for (int i = 0; i < prob; i++) {
			int x = chunkX*16 + rnd.nextInt(16);
			int y = minH + rnd.nextInt(difH);
			int z = chunkZ*16 + rnd.nextInt(16);
			
			generador.generate(world, rnd, new BlockPos(x, y, z));
		}
	}
	
}
