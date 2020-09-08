package org.flowable.serverless;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEventDispatcher;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.common.engine.impl.persistence.entity.ByteArrayRef;
import org.flowable.engine.delegate.event.impl.FlowableEventBuilder;
import org.flowable.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.flowable.engine.impl.persistence.CountingExecutionEntity;
import org.flowable.engine.impl.persistence.entity.ExecutionEntity;
import org.flowable.engine.impl.persistence.entity.ExecutionEntityManagerImpl;
import org.flowable.engine.impl.persistence.entity.data.ExecutionDataManager;
import org.flowable.engine.impl.util.CommandContextUtil;
import org.flowable.engine.impl.util.EventUtil;
import org.flowable.variable.api.persistence.entity.VariableInstance;
import org.flowable.variable.service.impl.persistence.entity.VariableInstanceEntity;

/**
 * @author Valentin Zickner
 */
public class CustomExecutionEntityManagerImpl extends ExecutionEntityManagerImpl {

    public CustomExecutionEntityManagerImpl(ProcessEngineConfigurationImpl processEngineConfiguration,
            ExecutionDataManager executionDataManager) {
        super(processEngineConfiguration, executionDataManager);
    }

    @Override
    protected void deleteVariables(ExecutionEntity executionEntity, CommandContext commandContext, boolean enableExecutionRelationshipCounts,
            boolean eventDispatcherEnabled) {
        if (!enableExecutionRelationshipCounts ||
                (enableExecutionRelationshipCounts && ((CountingExecutionEntity) executionEntity).getVariableCount() > 0)) {

            Collection<VariableInstance> executionVariables = executionEntity.getVariableInstancesLocal().values();
            if (!executionVariables.isEmpty()) {

                List<ByteArrayRef> variableByteArrayRefs = new ArrayList<>();
                for (VariableInstance variableInstance : executionVariables) {
                    if (variableInstance instanceof VariableInstanceEntity) {
                        VariableInstanceEntity variableInstanceEntity = (VariableInstanceEntity) variableInstance;

                        if (variableInstanceEntity.getByteArrayRef() != null && variableInstanceEntity.getByteArrayRef().getId() != null) {
                            variableByteArrayRefs.add(variableInstanceEntity.getByteArrayRef());
                        }

                        if (eventDispatcherEnabled) {
                            FlowableEventDispatcher eventDispatcher = CommandContextUtil.getEventDispatcher(commandContext);
                            if (eventDispatcher != null) {
                                eventDispatcher.dispatchEvent(EventUtil.createVariableDeleteEvent(variableInstanceEntity));
                                eventDispatcher.dispatchEvent(FlowableEventBuilder.createEntityEvent(FlowableEngineEventType.ENTITY_DELETED, variableInstance));
                            }
                        }
                    }
                }

                // First byte arrays that reference variable, then variables in bulk
                for (ByteArrayRef variableByteArrayRef : variableByteArrayRefs) {
                    getByteArrayEntityManager().deleteByteArrayById(variableByteArrayRef.getId());
                }

                CommandContextUtil.getVariableService(commandContext).deleteVariablesByExecutionId(executionEntity.getId());
            }
        }
    }

}
