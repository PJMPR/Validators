package org.example.validation.rules;

import org.example.SampleObject;
import org.example.validation.ValidationResult;

public interface ICheckValidationRule {
    void validate(ValidationResult<?> validationResult);
}
