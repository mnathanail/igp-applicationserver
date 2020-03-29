package igp.depo.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Validator {
	
	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


	public boolean validateEmail(final String hex) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
	


public boolean isNumeric(String... isNum) {
	
	 boolean flag = true;

     for(String s : isNum) {
    	s = s.replaceAll("\\s+","");
    	
     try {
       Double.parseDouble(s);
     } catch (NumberFormatException e) {
    	 System.out.println(s + " is not a number");
    	 flag = false;
    	 break;
     }
     }
     
     return flag?true:false;
}
	
}
