package appeng.decorative.definitions;

import appeng.api.bootstrap.DefinitionFactory;
import appeng.api.definitions.IItemDefinition;
import appeng.core.lib.definitions.Definitions;
import appeng.decorative.api.definitions.IDecorativeItemDefinitions;
import net.minecraft.item.Item;

public class DecorativeItemDefinitions extends Definitions<Item, IItemDefinition<Item>>
		implements IDecorativeItemDefinitions {

	public DecorativeItemDefinitions(DefinitionFactory registry){
		init(/*registry.buildDefaultItemBlocks()*/);
	}

}
