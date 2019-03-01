package rutolo.kromod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LootHandler {
	
	private static final String[] TABLAS = {
		"inject/cetro",
		"inject/hechizos"
	};
	
	public LootHandler() {
		for (String s : TABLAS) {
			LootTableList.register(new ResourceLocation(Referencia.MODID, s));
		}
	}

	@SubscribeEvent
	public void lootLoad(LootTableLoadEvent ev) {
		String prefix = "minecraft:chests/";
		String name = ev.getName().toString();
		
		if (name.startsWith(prefix)) {
			String file = name.substring(name.indexOf(prefix) + prefix.length());
			switch (file) {
				case "abandoned_mineshaft":
				case "desert_pyramid":
				case "jungle_temple":
				case "simple_dungeon":
				case "stronghold_corridor":
				case "village_blacksmith":
				case "spawn_bonus_chest":
					LootEntry e = new LootEntryTable(new ResourceLocation("kromod:inject/cetro"), 1, 1, null, "krom_cetro_inj_entry");
					LootPool p = new LootPool(new LootEntry[] {e}, new LootCondition[0], new RandomValueRange(1, 1), new RandomValueRange(0), "krom_cetro_inj_pool");
					ev.getTable().addPool(p);
					e = new LootEntryTable(new ResourceLocation("kromod:inject/hechizos"), 1, 1, null, "krom_hechizo_inj_entry");
					p = new LootPool(new LootEntry[] {e}, new LootCondition[0], new RandomValueRange(1, 1), new RandomValueRange(0), "krom_hechizo_inj_pool");
					ev.getTable().addPool(p);
					break;
				default: 
					break;
			}
		}
	}
	
}
