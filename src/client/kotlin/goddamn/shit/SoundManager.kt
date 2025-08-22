package goddamn.shit

import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry

object SoundManager {
	val FART: SoundEvent = registerSound("fart")

	fun registerSound(id: String): SoundEvent {
		val identf = Identifier.of(GoddamnShitClient.MOD_ID, id)
		return Registry.register(Registries.SOUND_EVENT, identf, SoundEvent.of(identf))
	}

	fun init() {
		GoddamnShitClient.LOGGER.info("Shitty sound system is initializing...")
	}
}
