package igp.depo.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import igp.depo.validations.NumberValidator;

@Target({FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { NumberValidator.class })
public @interface NumberValidation {

	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
