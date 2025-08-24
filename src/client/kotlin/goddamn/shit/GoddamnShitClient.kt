package goddamn.shit

import net.fabricmc.api.ClientModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object GoddamnShitClient : ClientModInitializer {
	var MOD_ID: String = "goddamn-shit"
	var LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitializeClient() {
		LOGGER.info("A goddamm shit is starting...")
		SoundManager.init()
		ModItems.init()
		ModBlocks.init()
	}
}
