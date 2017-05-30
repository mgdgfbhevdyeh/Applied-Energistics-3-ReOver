package appeng.core.spatial.definitions;

import appeng.api.bootstrap.DefinitionFactory;
import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.definitions.Definitions;
import appeng.core.spatial.api.definitions.ISpatialItemDefinitions;
import net.minecraft.item.Item;

public class SpatialItemDefinitions extends Definitions<Item, IItemDefinition<Item>>
		implements ISpatialItemDefinitions {

	public SpatialItemDefinitions(DefinitionFactory registry){
		init(/*registry.buildDefaultItemBlocks()*/);
	}

}
