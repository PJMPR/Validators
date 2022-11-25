package org.example.validation.rules;

import org.example.validation.ValidationResult;
import org.example.validation.annotations.Regex;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class RegexValidationRule extends ValidationRule {
    @Override
    protected String prepareMessage(Annotation annotation) {
        var regex = (Regex) annotation;
        return regex.message();
    }

    @Override
    protected Class<? extends Annotation> getAnnotationClass() {
        return Regex.class;
    }

    @Override
    protected boolean checkRule(ValidationResult<?> validationResult, Field field, Annotation annotation) throws IllegalAccessException {
        String value = (String)field.get(validationResult.getValidatedObject());
        var regex = (Regex) annotation;
        return value.matches(regex.pattern());
    }
}
