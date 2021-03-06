package appeng.core.api.bootstrap;

import appeng.api.bootstrap.IDefinitionBuilder;
import appeng.api.definitions.IItemDefinition;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import javax.annotation.Nullable;

public interface IItemBuilder<I extends Item, II extends IItemBuilder<I, II>> extends IDefinitionBuilder<I, IItemDefinition<I>, II> {

	II creativeTab(CreativeTabs tab);

	/**
	 * Loads default model for this item
	 * @return <tt>this</tt>
	 */
	II defaultModel();

}
