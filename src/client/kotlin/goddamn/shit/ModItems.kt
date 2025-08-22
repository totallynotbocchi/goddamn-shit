package goddamn.shit

import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.SwordItem
import net.minecraft.item.ItemGroup
import net.minecraft.item.ArmorItem
import net.minecraft.util.Identifier
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.Registries
import net.minecraft.component.type.FoodComponent
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.recipe.Ingredient
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.registry.FuelRegistry
import kotlin.collections.map

object ModItems {
	// materials
	val SHIT: Item = this.register(
		Item(Item.Settings().food(ModFoodComponents.SHIT)),
		"shit"
	)

	// tools
	val SHIT_SWORD = this.register(
		SwordItem(ShitToolMaterial, Item.Settings()),
		"shit_sword"
	)

	// armor
	val SHIT_HELMET: Item = this.register(ArmorItem(ShitArmorMaterial.MATERIAL,
	   ArmorItem.Type.HELMET,
		Item.Settings().maxDamage(ShitArmorMaterial.durabilityMult)
	), "shit_helmet")


	val SHIT_CHESTPLATE: Item = this.register(ArmorItem(ShitArmorMaterial.MATERIAL,
	   ArmorItem.Type.CHESTPLATE,
		Item.Settings().maxDamage(ShitArmorMaterial.durabilityMult)
	), "shit_chestplate")


	val SHIT_LEGGINGS: Item = this.register(ArmorItem(ShitArmorMaterial.MATERIAL,
	   ArmorItem.Type.LEGGINGS,
		Item.Settings().maxDamage(ShitArmorMaterial.durabilityMult)
	), "shit_leggings")


	val SHIT_BOOTS: Item = this.register(ArmorItem(ShitArmorMaterial.MATERIAL,
	   ArmorItem.Type.BOOTS,
		Item.Settings().maxDamage(ShitArmorMaterial.durabilityMult)
	), "shit_boots")

	// methods
	fun register(item: Item, id: String): Item {
		GoddamnShitClient.LOGGER.info("Registering item: ${id}")

		val identf: Identifier = Identifier.of(GoddamnShitClient.MOD_ID, id)
		return Registry.register(Registries.ITEM, identf, item)
	}

	fun addToGroup(group: RegistryKey<ItemGroup>, item: Item) {
		ItemGroupEvents.modifyEntriesEvent(group).register{ it.add(item) }
	}
	
	fun init() {
		ShitArmorMaterial.init()

		FuelRegistry.INSTANCE.add(this.SHIT, Utils.inTicks(10))
		this.addToGroup(ItemGroups.INGREDIENTS, this.SHIT)
		this.addToGroup(ItemGroups.COMBAT, this.SHIT_SWORD)
		this.addToGroup(ItemGroups.COMBAT, this.SHIT_HELMET)
		this.addToGroup(ItemGroups.COMBAT, this.SHIT_CHESTPLATE)
		this.addToGroup(ItemGroups.COMBAT, this.SHIT_LEGGINGS)
		this.addToGroup(ItemGroups.COMBAT, this.SHIT_BOOTS)
	}
}
