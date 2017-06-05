package appeng.core.worldgen;

import appeng.api.bootstrap.DefinitionFactory;
import appeng.api.bootstrap.InitializationComponentsHandler;
import appeng.api.definitions.IDefinition;
import appeng.api.definitions.IDefinitions;
import appeng.api.module.AEStateEvent;
import appeng.api.module.Module;
import appeng.api.module.Module.ModuleEventHandler;
import appeng.core.AppEng;
import appeng.core.lib.bootstrap.InitializationComponentsHandlerImpl;
import appeng.core.worldgen.api.IWorldGen;
import appeng.core.worldgen.definitions.WorldGenBlockDefinitions;
import appeng.core.worldgen.definitions.WorldGenItemDefinitions;
import appeng.core.worldgen.definitions.WorldGenTileDefinitions;
import appeng.core.worldgen.proxy.WorldGenProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.SidedProxy;

@Module(IWorldGen.NAME)
public class AppEngWorldGen implements IWorldGen {

	@Module.Instance(NAME)
	public static final AppEngWorldGen INSTANCE = null;

	@SidedProxy(modId = AppEng.MODID, clientSide = "appeng.core.worldgen.proxy.WorldGenClientProxy", serverSide = "appeng.core.worldgen.proxy.WorldGenServerProxy")
	public static WorldGenProxy proxy;

	private InitializationComponentsHandler initHandler = new InitializationComponentsHandlerImpl();

	private DefinitionFactory registry;

	private WorldGenItemDefinitions itemDefinitions;
	private WorldGenBlockDefinitions blockDefinitions;
	private WorldGenTileDefinitions tileDefinitions;

	@Override
	public <T, D extends IDefinitions<T, ? extends IDefinition<T>>> D definitions(Class<T> clas){
		if(clas == Item.class){
			return (D) itemDefinitions;
		}
		if(clas == Block.class){
			return (D) blockDefinitions;
		}
		if(clas == TileEntity.class){
			return (D) tileDefinitions;
		}
		return null;
	}

	@ModuleEventHandler
	public void preInit(AEStateEvent.AEPreInitializationEvent event){
		registry = event.factory(initHandler, proxy);
		this.itemDefinitions = new WorldGenItemDefinitions(registry);
		this.blockDefinitions = new WorldGenBlockDefinitions(registry);
		this.tileDefinitions = new WorldGenTileDefinitions(registry);

		this.itemDefinitions.init(registry);
		this.blockDefinitions.init(registry);
		this.tileDefinitions.init(registry);

		initHandler.preInit();
		proxy.preInit(event);
	}

	@ModuleEventHandler
	public void init(AEStateEvent.AEInitializationEvent event){
		initHandler.init();
		proxy.init(event);
	}

	@ModuleEventHandler
	public void postInit(AEStateEvent.AEPostInitializationEvent event){
		initHandler.postInit();
		proxy.postInit(event);
	}

	@ModuleEventHandler
	public void handleIMCEvent(AEStateEvent.ModuleIMCMessageEvent event){

	}

	/*@ModuleEventHandler
	public void serverAboutToStart(FMLServerAboutToStartEvent event){

	}

	@ModuleEventHandler
	public void serverStarting(FMLServerStartingEvent event){

	}

	@ModuleEventHandler
	public void serverStopping(FMLServerStoppingEvent event){

	}

	@ModuleEventHandler
	public void serverStopped(FMLServerStoppedEvent event){

	}*/

}
