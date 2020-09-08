package org.flowable.serverless;

import java.util.List;
import java.util.Map;

import org.flowable.eventregistry.api.EventDefinition;
import org.flowable.eventregistry.impl.EventDefinitionQueryImpl;
import org.flowable.eventregistry.impl.persistence.entity.EventDefinitionEntity;
import org.flowable.eventregistry.impl.persistence.entity.EventDefinitionEntityManager;

/**
 * @author Valentin Zickner
 */
public class NoDbEventDefinitionEntityManager implements EventDefinitionEntityManager {

    @Override
    public EventDefinitionEntity findLatestEventDefinitionByKey(String eventDefinitionKey) {
        return (EventDefinitionEntity) ServerlessUtil.EVENT_DEFINITION;
    }

    @Override
    public EventDefinitionEntity findLatestEventDefinitionByKeyAndTenantId(String eventDefinitionKey, String tenantId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<EventDefinition> findEventDefinitionsByQueryCriteria(EventDefinitionQueryImpl eventQuery) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long findEventDefinitionCountByQueryCriteria(EventDefinitionQueryImpl eventQuery) {
        throw new UnsupportedOperationException();
    }

    @Override
    public EventDefinitionEntity findEventDefinitionByDeploymentAndKey(String deploymentId, String eventDefinitionKey) {
        throw new UnsupportedOperationException();
    }

    @Override
    public EventDefinitionEntity findEventDefinitionByDeploymentAndKeyAndTenantId(String deploymentId, String eventDefinitionKey, String tenantId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public EventDefinitionEntity findEventDefinitionByKeyAndVersionAndTenantId(String eventDefinitionKey, Integer eventVersion, String tenantId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<EventDefinition> findEventDefinitionsByNativeQuery(Map<String, Object> parameterMap) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long findEventDefinitionCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateEventDefinitionTenantIdForDeployment(String deploymentId, String newTenantId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteEventDefinitionsByDeploymentId(String deploymentId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public EventDefinitionEntity create() {
        throw new UnsupportedOperationException();
    }

    @Override
    public EventDefinitionEntity findById(String entityId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(EventDefinitionEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void insert(EventDefinitionEntity entity, boolean fireCreateEvent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public EventDefinitionEntity update(EventDefinitionEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public EventDefinitionEntity update(EventDefinitionEntity entity, boolean fireUpdateEvent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(EventDefinitionEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(EventDefinitionEntity entity, boolean fireDeleteEvent) {
        throw new UnsupportedOperationException();
    }

}
