package com.boozallen.aiops.mda.generator;

/*-
 * #%L
 * aiSSEMBLE::Foundation::MDA
 * %%
 * Copyright (C) 2021 Booz Allen
 * %%
 * This software package is licensed under the Booz Allen Public License. All Rights Reserved.
 * #L%
 */

import com.boozallen.aiops.mda.generator.util.PipelineUtils;
import com.boozallen.aiops.mda.metamodel.element.Pipeline;
import com.boozallen.aiops.mda.metamodel.element.Step;
import org.technologybrewery.fermenter.mda.generator.GenerationContext;

import java.util.stream.Collectors;

import static com.boozallen.aiops.mda.generator.util.PipelineUtils.isGenericStep;

public class GenericStepPythonGenerator extends TargetedPipelineStepPythonGenerator {
    /*--~-~-~~
     * Usages:
     * | Target                  | Template                            | Generated File   |
     * |-------------------------|-------------------------------------|------------------|
     * | pythonGenericStepImpl   | pipeline-common/generic.step.py.vm  | impl/${name}.py  |
     * | pySparkGenericStepImpl  | pipeline-common/generic.step.py.vm  | impl/${name}.py  |
     */

    @Override
    protected boolean shouldGenerateStep(Step step, GenerationContext generationContext) {
        return isGenericStep(step);
    }
}
