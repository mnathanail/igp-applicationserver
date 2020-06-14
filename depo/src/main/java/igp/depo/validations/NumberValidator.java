package igp.depo.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import igp.depo.annotations.NumberValidation;

public class NumberValidator implements ConstraintValidator<NumberValidation,String> {

	
	@Override
	public void initialize(NumberValidation constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
	     try {
	    	 if(value == null || value.isEmpty()) return true;
	       value = value.replaceAll("\\s+","");
	       Double.parseDouble(value);
	     } catch (NumberFormatException e) {
	    	 return false;
	     }
		
		return true;
	}

}
