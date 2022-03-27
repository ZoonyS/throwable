package zoony.throwable.entities.common;

import net.fabricmc.api.ModInitializer;
import zoony.throwable.entities.common.init.ThrowableItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Throwable implements ModInitializer {
	public static final String MODID = "throwable";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ThrowableItems.init();
	}
}
