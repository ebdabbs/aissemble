package com.boozallen.aissemble.configuration.policy;

import com.boozallen.aissemble.core.policy.configuration.policy.DefaultPolicy;

public class DefaultPropertyRegenerationPolicy  extends DefaultPolicy implements PropertyRegenerationPolicy {

    /**
     * Default constructor.
     */
    public DefaultPropertyRegenerationPolicy() {
        super();
    }

    /**
     * Constructor that sets the policy identifier.
     * 
     * @param policyIdentifier
     */
    public DefaultPropertyRegenerationPolicy(String policyIdentifier) {
        super(policyIdentifier);
    }
    
}
