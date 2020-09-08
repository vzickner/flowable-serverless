package org.flowable.serverless;

import java.util.Collections;

import org.flowable.common.engine.impl.persistence.StrongUuidGenerator;
import org.flowable.eventregistry.impl.cfg.StandaloneEventRegistryEngineConfiguration;

/**
 * @author Valentin Zickner
 */
public class NoDbEventEngineConfiguration extends StandaloneEventRegistryEngineConfiguration {

    public NoDbEventEngineConfiguration() {
        this.usingRelationalDatabase = false;
        this.enableEventRegistryChangeDetectionAfterEngineCreate = false;
        this.idGenerator = new StrongUuidGenerator();

        //this.customSessionFactories = Collections.singletonList(this.dbSqlSessionFactory); // Needs to be set as initDbSqlSessionFactory won't be hit due to usingRelationalDatabase = false
    }

    @Override
    public void initEntityManagers() {
        super.initEntityManagers();

        this.eventDefinitionEntityManager = new NoDbEventDefinitionEntityManager();
        this.channelDefinitionEntityManager = new NoDbChannelDefinitionEntityManager();
    }
}
