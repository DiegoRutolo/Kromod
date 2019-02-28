package rutolo.kromod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class KromEventHandler {

	@SubscribeEvent
	public void lootLoad(LootTableLoadEvent ev) {
		if (ev.getName().toString().equals("minecraft:chests/spawn_bonus_chest")) {
			LootEntry e = new LootEntryTable(new ResourceLocation("kromod:inject/cetro"), 1, 1, null, "cetro_inj_entry");
			LootPool p = new LootPool(new LootEntry[] {e}, new LootCondition[0], new RandomValueRange(1, 1), new RandomValueRange(0), "cetro_inj_pool");
			ev.getTable().addPool(p);
			e = new LootEntryTable(new ResourceLocation("kromod:inject/hechizos"), 1, 1, null, "hechizo_inj_entry");
			p = new LootPool(new LootEntry[] {e}, new LootCondition[0], new RandomValueRange(1, 1), new RandomValueRange(0), "hechizo_inj_pool");
			ev.getTable().addPool(p);
		}
	}
}
