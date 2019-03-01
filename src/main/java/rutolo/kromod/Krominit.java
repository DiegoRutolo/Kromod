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
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rutolo.kromod.blocks.BloqueMagico;
import rutolo.kromod.blocks.OreMagico;
import rutolo.kromod.items.CetroMagico;
import rutolo.kromod.items.GalletaMagica;
import rutolo.kromod.items.GemaCuracion;
import rutolo.kromod.items.Grimorio;
import rutolo.kromod.items.ItemMagico;
import rutolo.kromod.items.hechizos.BolaDeFuego;
import rutolo.kromod.items.hechizos.Shunpo;

@Mod.EventBusSubscriber(modid=Referencia.MODID)
public class Krominit {
	
	public static final CreativeTabs tabKromod = new CreativeTabs("tabKromod") {
				@Override
				public ItemStack getTabIconItem() {
					return new ItemStack(items.get(Referencia.CETRO));
				}
				
				@Override
				public boolean hasSearchBar() {
					return true;
				}
			}.setBackgroundImageName("item_search.png");
	
	// estas listas contienen todos los objetos
	public static Map<String,Item>	items	= new HashMap<String,Item>();
	public static Map<String,Block>	bloques	= new HashMap<String,Block>();
	
	public static void itemsYbloques() {
		items.put(Referencia.GALLETA_MAGICA, new GalletaMagica());
		items.put(Referencia.GEMA_CURACION, new GemaCuracion());
		
		bloques.put(Referencia.ORICALCO_ORE, new OreMagico(Referencia.ORICALCO_ORE));
		items.put(Referencia.ORICALCO_INGOT, new ItemMagico(Referencia.ORICALCO_INGOT));
		bloques.put(Referencia.ORICALCO_BLOCK, new BloqueMagico(Referencia.ORICALCO_BLOCK, Material.IRON));
		bloques.get(Referencia.ORICALCO_BLOCK).setHardness(2f);
		bloques.get(Referencia.ORICALCO_BLOCK).setHarvestLevel("pickaxe", 2);
		
		items.put(Referencia.ESCOTRACO_DUST, new ItemMagico(Referencia.ESCOTRACO_DUST).setMaxStackSize(16));
		bloques.put(Referencia.ESCOTRACO_ORE, new OreMagico(Referencia.ESCOTRACO_ORE, items.get(Referencia.ESCOTRACO_DUST), 1, 3));
		
		items.put(Referencia.CETRO, new CetroMagico());
		items.put(Referencia.GRIMORIO, new Grimorio());
		
		items.put(Referencia.H_SHUNPO, new Shunpo());
		items.put(Referencia.H_BOLA_DE_FUEGO, new BolaDeFuego());
//		items.put(Referencia.H_EMPUJON, new Empujon());
	}
	
	public static void recetas() {
		GameRegistry.addSmelting(bloques.get(Referencia.ORICALCO_ORE), new ItemStack(items.get(Referencia.ORICALCO_INGOT)), 0.9f);
	}
	
	public static void lootTables() {
		LootTableList.register(new ResourceLocation(Referencia.MODID, "hechizos"));
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
