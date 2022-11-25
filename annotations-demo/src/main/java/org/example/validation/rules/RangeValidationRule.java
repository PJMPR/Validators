package org.example.validation.rules;

import org.example.validation.ValidationResult;
import org.example.validation.annotations.NotNull;
import org.example.validation.annotations.Range;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RangeValidationRule extends ValidationRule {

    @Override
    protected String prepareMessage(Annotation annotation) {
        var range = (Range) annotation;
        return range.message().formatted(range.min(), range.max());
    }

    @Override
    protected Class<? extends Annotation> getAnnotationClass() {
        return Range.class;
    }

    @Override
    protected boolean checkRule(ValidationResult<?> validationResult, Field field, Annotation annotation) throws IllegalAccessException {
        var range = (Range) annotation;
        return field.getInt(validationResult.getValidatedObject())<= range.max()
                && field.getInt(validationResult.getValidatedObject())>= range.min();
    }
}
