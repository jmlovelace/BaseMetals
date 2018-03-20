package com.mcmoddev.basemetals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mcmoddev.basemetals.proxy.CommonProxy;
import com.mcmoddev.lib.data.SharedStrings;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLMissingMappingsEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * This is the entry point for this Mod. If you are writing your own Mod that
 * uses this Mod, the classes of interest to you are the init classes (classes
 * in package com.mcmoddev.basemetals.init) and the CrusherRecipeRegistry class
 * (in package com.mcmoddev.basemetals.registry). Note that you should add
 * 'dependencies = "required-after:basemetals"' to your &#64;Mod annotation
 * (e.g. <br>
 * &#64;Mod(modid = "moremetals", name="More Metals!", version = "1.2.3",
 * dependencies = "required-after:basemetals") <br>
 * )
 *
 * @author Jasmine Iwanek
 *
 */
@Mod(
		modid = BaseMetals.MODID,
		name = BaseMetals.NAME,
		version = BaseMetals.VERSION,
		dependencies = "required-after:forge@[12.18.3.2185,);after:tconstruct;after:ic2;after:taiga;before:buildingbricks",
		acceptedMinecraftVersions = "[1.10.2]",
		certificateFingerprint = "@FINGERPRINT@",
		updateJSON = BaseMetals.UPDATEJSON)
public class BaseMetals {

	@Instance
	public static BaseMetals instance;

	/** ID of this Mod */
	public static final String MODID = "basemetals";

	/** Display name of this Mod */
	protected static final String NAME = "Base Metals";

	/**
	 * Version number, in Major.Minor.Patch format. The minor number is
	 * increased whenever a change is made that has the potential to break
	 * compatibility with other mods that depend on this one.
	 */
	public static final String VERSION = "2.5.0-beta4";

	protected static final String UPDATEJSON = SharedStrings.UPDATE_JSON_URL + "BaseMetals/master/update.json";

	private static final String PROXY_BASE = SharedStrings.MMD_PROXY_GROUP + MODID + SharedStrings.DOT_PROXY_DOT;

	@SidedProxy(clientSide = PROXY_BASE + SharedStrings.CLIENTPROXY, serverSide = PROXY_BASE
			+ SharedStrings.SERVERPROXY)
	public static CommonProxy proxy;

	public static final Logger logger = LogManager.getFormatterLogger(BaseMetals.MODID);

	static {
		// Forge says this needs to be statically initialized here.
		FluidRegistry.enableUniversalBucket();
	}

	@EventHandler
	public void onFingerprintViolation(FMLFingerprintViolationEvent event) {
		logger.warn(SharedStrings.INVALID_FINGERPRINT);
	}

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	@EventHandler
	public static void onRemap(FMLMissingMappingsEvent event) {
		proxy.onRemap(event);
	}
}
