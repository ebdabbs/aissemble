package com.boozallen.aissemble.configuration.policy;

import com.boozallen.aissemble.configuration.policy.json.PropertyRegenerationPolicyInput;
import com.boozallen.aissemble.core.policy.configuration.policy.DefaultPolicy;
import com.boozallen.aissemble.core.policy.configuration.policy.Policy;

/*-
 * #%L
 * aiSSEMBLE::Foundation::Configuration::Store
 * %%
 * Copyright (C) 2021 Booz Allen
 * %%
 * This software package is licensed under the Booz Allen Public License. All Rights Reserved.
 * #L%
 */

import com.boozallen.aissemble.core.policy.configuration.policymanager.AbstractPolicyManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Class used for loading and configuring policies for determining when to regenerate a given {@link Property}.
 */
public class PropertyRegenerationPolicyManager extends AbstractPolicyManager {
    
    private static PropertyRegenerationPolicyManager instance;

    private Map<String, PropertyRegenerationPolicy> propertyRegenerationPolicies;

    public static final PropertyRegenerationPolicyManager getInstance() {
        if (instance == null) {
            synchronized (PropertyRegenerationPolicyManager.class) {
                instance = new PropertyRegenerationPolicyManager();
            }
        }
        return instance;
    }

    /**
     * Gets the property regeneration specific policies.
     * @return map of policies
     */
    public Map<String, PropertyRegenerationPolicy> getPropertyRegenerationPolicies() {
        if(this.propertyRegenerationPolicies == null) {
            this.propertyRegenerationPolicies = new HashMap<>();
            Map<String, Policy> policies = super.getPolicies();
            if(policies != null) {
                for (Map.Entry<String, Policy> entry : policies.entrySet()) {
                    String key = entry.getKey();
                    Policy value = entry.getValue();
                    if(value instanceof PropertyRegenerationPolicy) {
                        this.propertyRegenerationPolicies.put(key, (PropertyRegenerationPolicy) value);
                    }
                }
            }
        }

        return this.propertyRegenerationPolicies;
    }

    /**
     * Method that allows subclasses to override the type reference with a
     * subclass.
     * 
     * @return
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Class getDeserializationClass() {
        return PropertyRegenerationPolicyInput.class;
    }

    /**
     * Method that allows subclasses to use an extended type for the policy
     * class.
     * 
     * @param identifier
     * @return
     */
    @Override
    public DefaultPolicy createPolicy(String policyIdentifier) {
        return new DefaultPropertyRegenerationPolicy(policyIdentifier);
    }
}
