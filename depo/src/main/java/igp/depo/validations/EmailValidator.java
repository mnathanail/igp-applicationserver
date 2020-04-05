package igp.depo.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import igp.depo.annotations.EmailValidation;
import igp.depo.repo.ForeasDao;

public class EmailValidator implements ConstraintValidator<EmailValidation,String>{

	@Autowired
	ForeasDao foreasDao;
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	
	@Override
	public void initialize(EmailValidation constraintAnnotation) {
	}

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if(foreasDao==null) 
			return true;
		
	    pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(value);
		return  matcher.matches() && foreasDao.findByEmail(value)==null;
	}

	
}
