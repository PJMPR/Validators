package org.example.validation.rules;

import org.example.validation.ValidationResult;
import org.example.validation.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NotNullValidationRule extends ValidationRule {

    @Override
    protected String prepareMessage(Annotation annotation) {
        var notNull = (NotNull) annotation;
        return notNull.message();
    }

    @Override
    protected Class<? extends Annotation> getAnnotationClass() {
        return NotNull.class;
    }

    @Override
    protected boolean checkRule(ValidationResult<?> validationResult, Field field, Annotation annotation) throws IllegalAccessException {
        return field.get(validationResult.getValidatedObject())!=null;
    }
}
