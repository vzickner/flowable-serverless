package org.flowable.serverless;

import java.util.List;
import java.util.Map;

import org.flowable.eventregistry.api.ChannelDefinition;
import org.flowable.eventregistry.impl.ChannelDefinitionQueryImpl;
import org.flowable.eventregistry.impl.persistence.entity.ChannelDefinitionEntity;
import org.flowable.eventregistry.impl.persistence.entity.ChannelDefinitionEntityManager;

/**
 * @author Valentin Zickner
 */
public class NoDbChannelDefinitionEntityManager implements ChannelDefinitionEntityManager {

    @Override
    public ChannelDefinitionEntity findLatestChannelDefinitionByKey(String channelDefinitionKey) {
        return ServerlessUtil.CHANNEL_DEFINITION;
    }

    @Override
    public ChannelDefinitionEntity findLatestChannelDefinitionByKeyAndTenantId(String channelDefinitionKey, String tenantId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ChannelDefinition> findChannelDefinitionsByQueryCriteria(ChannelDefinitionQueryImpl eventQuery) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long findChannelDefinitionCountByQueryCriteria(ChannelDefinitionQueryImpl eventQuery) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChannelDefinitionEntity findChannelDefinitionByDeploymentAndKey(String deploymentId, String channelDefinitionKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChannelDefinitionEntity findChannelDefinitionByDeploymentAndKeyAndTenantId(String deploymentId, String channelDefinitionKey, String tenantId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChannelDefinitionEntity findChannelDefinitionByKeyAndVersionAndTenantId(String channelDefinitionKey, Integer channelVersion, String tenantId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ChannelDefinition> findChannelDefinitionsByNativeQuery(Map<String, Object> parameterMap) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long findChannelDefinitionCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateChannelDefinitionTenantIdForDeployment(String deploymentId, String newTenantId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteChannelDefinitionsByDeploymentId(String deploymentId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChannelDefinitionEntity create() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChannelDefinitionEntity findById(String entityId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(ChannelDefinitionEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(ChannelDefinitionEntity entity, boolean fireCreateEvent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChannelDefinitionEntity update(ChannelDefinitionEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChannelDefinitionEntity update(ChannelDefinitionEntity entity, boolean fireUpdateEvent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(ChannelDefinitionEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(ChannelDefinitionEntity entity, boolean fireDeleteEvent) {
        throw new UnsupportedOperationException();
    }

}
