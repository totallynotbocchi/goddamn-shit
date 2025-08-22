package goddamn.shit

import net.minecraft.item.ToolMaterial
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ArmorItem
import net.minecraft.registry.tag.TagKey
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.block.Block
import net.minecraft.recipe.Ingredient
import net.minecraft.component.type.FoodComponent
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents

object ModFoodComponents {
	val SHIT = FoodComponent.Builder()
		.alwaysEdible()
		.nutrition(1)
		.statusEffect(StatusEffectInstance(StatusEffects.NAUSEA, Utils.inTicks(10), 1), 1f)
		.build()
}

object ShitToolMaterial : ToolMaterial {
	override fun getDurability(): Int = 50
	override fun getMiningSpeedMultiplier(): Float = 0.7f
	override fun getAttackDamage(): Float = 2f
	override fun getInverseTag(): TagKey<Block> = BlockTags.INCORRECT_FOR_WOODEN_TOOL
	override fun getEnchantability(): Int = 30
	override fun getRepairIngredient(): Ingredient = Ingredient.ofItems(ModItems.SHIT)
}

object ShitArmorMaterial {
	val enchantability = 30
	val kbResistance = 0f
	val toughness = 1f
	val durabilityMult = 2
	val supplier = { Ingredient.ofItems(ModItems.SHIT) } 
	val defense = mapOf(
		ArmorItem.Type.HELMET to 1,
		ArmorItem.Type.CHESTPLATE to 2,
		ArmorItem.Type.LEGGINGS to 1,
		ArmorItem.Type.BOOTS to 1
	)

	// like a singleton
	val MATERIAL = ShitArmorMaterial.registerMaterial("shit", this.defense)

	private fun registerMaterial(id: String, defensePoints: Map<ArmorItem.Type, Int>): RegistryEntry<ArmorMaterial> {
		var materialID = Identifier.of(GoddamnShitClient.MOD_ID, id)

		val layers: List<ArmorMaterial.Layer> = listOf(
			ArmorMaterial.Layer(materialID, "", false)
		)

		var material: ArmorMaterial = ArmorMaterial(
			defensePoints,
			this.enchantability,
			RegistryEntry.of(SoundManager.FART),
			this.supplier,
			layers,
			this.toughness,
			this.kbResistance
		)

		material = Registry.register(Registries.ARMOR_MATERIAL, materialID, material)
		return RegistryEntry.of(material)
	}
		
	fun init() {}
}
