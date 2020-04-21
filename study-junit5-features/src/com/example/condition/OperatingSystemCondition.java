package com.example.condition;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;
import java.util.Optional;

public class OperatingSystemCondition implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        System.err.println("evaluateExecutionCondition() is running...");
        ConditionEvaluationResult result = ConditionEvaluationResult.enabled("@ConditionalOnOperatingSystem is not available");
        Optional<AnnotatedElement> element = extensionContext.getElement();
        Optional<ConditionalOnOperatingSystem> cond = AnnotationUtils.findAnnotation(
                element,ConditionalOnOperatingSystem.class);
        if (cond.isPresent()){
            OperatingSystem os = OperatingSystem.determine();
            OperatingSystem[] values = cond.get().value();
            var found = Arrays.stream(values).filter( value -> value.equals(os))
                                  .findFirst().isPresent();
            if (found)
                result = ConditionEvaluationResult.enabled("test is enabled!");
            else
                result = ConditionEvaluationResult.disabled("test is disabled!");
        }
        return result;
    }
}
