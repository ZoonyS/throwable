package zoony.throwable.entities.common;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThrowableEntities implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("throwable");

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");

	}
}
