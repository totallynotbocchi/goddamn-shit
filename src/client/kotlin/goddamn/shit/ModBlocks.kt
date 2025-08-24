package goddamn.shit

import net.minecraft.block.Block
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.block.AbstractBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.util.Identifier
import net.minecraft.registry.Registry
import net.minecraft.registry.Registries
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents

object ModBlocks {
	val PILE_OF_SHIT = this.register(
		Block(AbstractBlock.Settings
			.create()
			.sounds(BlockSoundGroup.HONEY)
			.strength(0.05f, 0.05f)
		),
		"pile_of_shit"
	)

	fun register(block: Block, name: String): Block {
		val id = Identifier.of(GoddamnShitClient.MOD_ID, name)

		val item = BlockItem(block, Item.Settings())
		Utils.addToGroup(ItemGroups.NATURAL, item)
		ModItems.register(item, name)

		return Registry.register(Registries.BLOCK, id, block)
	}

	fun init() {
	}
}
