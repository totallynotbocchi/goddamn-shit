package goddamn.shit

import net.minecraft.registry.RegistryKey
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents

object Utils {
	fun <T : Number>inTicks(sec: T): Int {
		return sec.toInt() * 20
	}

	fun addToGroup(group: RegistryKey<ItemGroup>, item: Item) {
		ItemGroupEvents.modifyEntriesEvent(group).register{ it.add(item) }
	}
}
