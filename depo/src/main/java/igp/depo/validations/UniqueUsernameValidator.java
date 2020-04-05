package igp.depo.validations;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import igp.depo.annotations.UniqueUsername;
import igp.depo.repo.ForeasDao;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{

	@Autowired
	ForeasDao foreasDao;

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
	
		if(foreasDao==null) 
			return true;

		return foreasDao.findByUsername(username)==null;
	}

}
