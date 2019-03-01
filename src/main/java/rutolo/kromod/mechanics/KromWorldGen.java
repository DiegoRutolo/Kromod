package rutolo.kromod.mechanics;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import rutolo.kromod.Krominit;
import rutolo.kromod.Referencia;

public class KromWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random rnd, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		if (world.provider.getDimension() == 0) {
			//ores
			oreGenerator(Krominit.bloques.get(Referencia.ORICALCO_ORE).getDefaultState(), 7, 5, 5, 30, 
					BlockMatcher.forBlock(Blocks.STONE), world, rnd, chunkX, chunkZ);
			if (world.getBiome(new BlockPos(chunkX*16, 20, chunkZ*16)).equals(Biomes.EXTREME_HILLS) ) {
				oreGenerator(Krominit.bloques.get(Referencia.ESCOTRACO_ORE).getDefaultState(), 20, 2, 5, 50, 
						BlockMatcher.forBlock(Blocks.STONE), world, rnd, chunkX, chunkZ);
			}
			
			//estructuras
			if (
					world.getBiome(new BlockPos(chunkX*16, 20, chunkZ*16)).equals(Biomes.PLAINS) || 
					world.getBiome(new BlockPos(chunkX*16, 20, chunkZ*16)).equals(Biomes.SAVANNA_PLATEAU) ||
					world.getBiome(new BlockPos(chunkX*16, 20, chunkZ*16)).equals(Biomes.FOREST) ||
					world.getBiome(new BlockPos(chunkX*16, 20, chunkZ*16)).equals(Biomes.BIRCH_FOREST) ||
					world.getBiome(new BlockPos(chunkX*16, 20, chunkZ*16)).equals(Biomes.ROOFED_FOREST)
				) {
				if (rnd.nextInt(999)+1 <= 1) {
					torreGenerator(world, rnd, chunkX*16, chunkZ*16);
				}
			}
		}
	}
	
	private void oreGenerator(IBlockState b, int taMax, int prob, int minH, int maxH,
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
	
	private boolean torreGenerator(World world, Random rnd, int x, int z) {
		return torreGenerator(world, rnd, x, getGroundFromAbove(world, x, z)-1, z);
	}
	
	private boolean torreGenerator(World world, Random rnd, int x, int y, int z) {
		WorldServer worldServer = (WorldServer) world;
		MinecraftServer minecraftServer = world.getMinecraftServer();
		TemplateManager templateManager = worldServer.getStructureTemplateManager();
		Template template = templateManager.getTemplate(minecraftServer, new ResourceLocation(Referencia.MODID+":torre"));
		BlockPos pos = new BlockPos(x, y, z);
		
		if (template == null) {
			System.out.println("Error de estructura");
			return false;
		}
		
		if (!canSpawnHere(template, worldServer, pos)) {
			return false;
		}
		
		IBlockState iBlockState = world.getBlockState(pos);
		world.notifyBlockUpdate(pos, iBlockState, iBlockState, 3);
		
		PlacementSettings placementSettings = (new PlacementSettings()).setMirror(Mirror.NONE)
				.setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk((ChunkPos) null)
				.setReplacedBlock((Block) null).setIgnoreStructureBlock(false);
		
		template.getDataBlocks(pos, placementSettings);
		template.addBlocksToWorld(world, pos.add(0, 1, 0), placementSettings);
		
		// loot
		Map<BlockPos, String> map = template.getDataBlocks(pos, placementSettings);
		for (Entry<BlockPos, String> e : map.entrySet()) {
			String inv = e.getValue();
			switch (inv) {
				case "biblio_baul":
				case "lab_baul":
				case "atic_baul":
				case "lab_pot":
					BlockPos pos2 = e.getKey();
					world.setBlockState(pos2.up(), Blocks.AIR.getDefaultState(), 3);
					TileEntity tileEntity = world.getTileEntity(pos2);
					
					if (tileEntity instanceof TileEntityChest) {
						((TileEntityChest) tileEntity).setLootTable(new ResourceLocation(Referencia.MODID+":tabla_generica"), rnd.nextLong());
					}
					break;
				case "hall_arm":
					break;
				default:
					break;
			}
		}
		
		return true;
	}
	
	// https://github.com/JavaMan7/Tutorial_mod/blob/master/src/main/java/com/javaman/tutorial_mod/WorldGen/ModWorldGenerator.java
	public static boolean canSpawnHere(Template template, World world, BlockPos posAboveGround) {
		int zwidth = template.getSize().getZ();
		int xwidth = template.getSize().getX();
		
		// check all the corners to see which ones are replaceable
		boolean corner1 = isCornerValid(world, posAboveGround);
		boolean corner2 = isCornerValid(world, posAboveGround.add(xwidth, 0, zwidth));
		
		// if Y > 20 and all corners pass the test, it's okay to spawn the structure
		return posAboveGround.getY() > 31 && corner1 && corner2;
	}
	
	public static boolean isCornerValid(World world, BlockPos pos) {
		int variation = 3;
		int highestBlock = getGroundFromAbove(world, pos.getX(), pos.getZ());
		
		if (highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation)
			return true;
				
		return false;
	}
	
	public static int getGroundFromAbove(World world, int x, int z) {
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 31)
		{
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround =  blockAt == Blocks.WATER||blockAt == Blocks.FLOWING_WATER||blockAt == Blocks.GRASS || blockAt == Blocks.SAND || blockAt == Blocks.SNOW || blockAt == Blocks.SNOW_LAYER || blockAt == Blocks.GLASS||blockAt == Blocks.MYCELIUM;
		}

		return y;
	}
}
