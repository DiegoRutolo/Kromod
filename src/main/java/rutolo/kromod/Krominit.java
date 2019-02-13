package rutolo.kromod;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rutolo.kromod.blocks.BloqueMagico;
import rutolo.kromod.blocks.OreMagico;
import rutolo.kromod.items.ItemMagico;

@Mod.EventBusSubscriber(modid=Referencia.MODID)
public class Krominit {
	
	public static final CreativeTabs tabKromod =new CreativeTabs("tabKromod") {
				@Override
				public ItemStack getTabIconItem() {
					return new ItemStack(items.get(cetro));
				}
				
				@Override
				public boolean hasSearchBar() {
					return true;
				}
			}.setBackgroundImageName("item_search.png");
	
	// estas listas contienen todos los objetos
	public static Map<String,Item>	items	= new HashMap<String,Item>();
	public static Map<String,Block>	bloques	= new HashMap<String,Block>();
	
	// nombres de los objetos, porque no me apetece equivocarme cada vez que tengo que escribir la String
	static String cetro = Referencia.cetro;
	static String oricalcoOre = Referencia.oricalcoOre;
	static String oricalcoIngot = Referencia.oricalcoIngot;
	static String oricalcoBlock = Referencia.oricalcoBlock;
	// static String escotracoIngot = Referencia.escotracoIngot;
	static String escotracoDust = Referencia.escotracoDust;
	static String escotracoOre = Referencia.escotracoOre;
	
	public static void init() {
		items.put(cetro, new ItemMagico(cetro).setMaxStackSize(1));
		
		bloques.put(oricalcoOre, new OreMagico(oricalcoOre));
		items.put(oricalcoIngot, new ItemMagico(oricalcoIngot));
		bloques.put(oricalcoBlock, new BloqueMagico(oricalcoBlock, Material.IRON));
		bloques.get(oricalcoBlock).setHardness(2f);
		bloques.get(oricalcoBlock).setHarvestLevel("pickaxe", 2);
		
		// items.put(escotracoIngot, new ItemMagico(escotracoIngot));
		items.put(escotracoDust, new ItemMagico(escotracoDust).setMaxStackSize(16));
		bloques.put(escotracoOre, new OreMagico(escotracoOre, items.get(escotracoDust), 1, 3));
	}
	
	public static void recetas() {
		GameRegistry.addSmelting(bloques.get(oricalcoOre), new ItemStack(items.get(oricalcoIngot)), 0.9f);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		for (Map.Entry<String,Block> entrada : bloques.entrySet()) {
			event.getRegistry().register(entrada.getValue());
		}
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		for (Map.Entry<String, Block> entrada : bloques.entrySet()) {
			event.getRegistry().register(new ItemBlock(entrada.getValue()).setRegistryName(entrada.getValue().getRegistryName()));
		}
	}
	
	@SubscribeEvent
	public static void reisterItems(RegistryEvent.Register<Item> event) {
		for (Map.Entry<String, Item> entrada : items.entrySet()) {
			event.getRegistry().register(entrada.getValue());
		}
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		for (Map.Entry<String, Item> entrada : items.entrySet()) {
			registrameEsta(entrada.getValue());
		}
		for (Map.Entry<String, Block> entrada : bloques.entrySet()) {
			registrameEsta(Item.getItemFromBlock(entrada.getValue()));
		}
	}
	
	static void registrameEsta(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
