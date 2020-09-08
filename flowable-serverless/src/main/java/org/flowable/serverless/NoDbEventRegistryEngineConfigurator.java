package org.flowable.serverless;

import org.flowable.eventregistry.impl.configurator.EventRegistryEngineConfigurator;

/**
 * @author Valentin Zickner
 */
public class NoDbEventRegistryEngineConfigurator extends EventRegistryEngineConfigurator {

    public NoDbEventRegistryEngineConfigurator() {
        this.eventEngineConfiguration = new NoDbEventEngineConfiguration();
    }

}
