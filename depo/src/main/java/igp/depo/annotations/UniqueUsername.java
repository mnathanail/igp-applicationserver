package igp.depo.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import igp.depo.validations.UniqueUsernameValidator;

@Service
@Transactional(rollbackFor = Exception.class, timeout = 5)
@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface UniqueUsername {
	
	String message();

	Class<?>[] groups() default { };
	
	Class<? extends Payload>[] payload() default { };

}
