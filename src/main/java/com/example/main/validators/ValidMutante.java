package com.example.main.validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MutanteValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMutante {
    String message() default "Secuencia DNA inavalida";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
