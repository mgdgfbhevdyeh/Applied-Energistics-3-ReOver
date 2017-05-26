package appeng.core.lib.bootstrap;

import appeng.api.definitions.IDefinition;

import java.util.function.Consumer;

public interface IDefinitionBuilder<T, D extends IDefinition<T>, B extends IDefinitionBuilder<T, D, B>> {

	B build(Consumer<D> callback);

	B preInit(Consumer<D> callback);

	B init(Consumer<D> callback);

	B postInit(Consumer<D> callback);

	D build();

}
