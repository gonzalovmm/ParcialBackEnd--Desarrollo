package com.example.main.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MutanteValidator implements ConstraintValidator<ValidMutante, String[]> {

    private static final String VALID_CHARACTERS = "ATCG";

    @Override
    public void initialize(ValidMutante constraintAnnotation) {
    }

    @Override
    public boolean isValid(String[] dna, ConstraintValidatorContext context) {
        if (dna == null) {
            return false;
        }

        int n = dna.length;
        if (n == 0) {
            return false;
        }

        for (String sequence : dna) {
            if (sequence == null || sequence.length() != n) {
                return false;
            }
            for (char c : sequence.toCharArray()) {
                if (VALID_CHARACTERS.indexOf(c) == -1) {
                    return false;
                }
            }
        }

        return true;
    }
}
