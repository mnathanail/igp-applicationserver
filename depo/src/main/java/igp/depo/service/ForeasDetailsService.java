package igp.depo.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import igp.depo.model.AdminModel;
import igp.depo.model.AitisiModel;
import igp.depo.model.ForeasDetails;
import igp.depo.model.ForeasModel;
import igp.depo.model.StatusKey;
import igp.depo.repo.AdminDao;
import igp.depo.repo.ForeasDao;
import igp.depo.utils.StatusEnum;

@Service
public class ForeasDetailsService implements UserDetailsService {
	
	@Autowired
	private ForeasDao foreasDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ForeasModel foreas = foreasDao.findByUsername(username);
		
		if(foreas == null) {
			
			AdminModel admin = adminDao.findByAdminusername(username);
			
			if(admin != null) 
				return new ForeasDetails(admin);

			new UsernameNotFoundException("username "+username+" not found.");
		}
		
		return new ForeasDetails(foreas);

	}
	
	@Transactional
	public AdminModel save(AdminModel admin) {
		admin.setAdminPassword(bcryptEncoder.encode(admin.getAdminPassword()));
		return this.adminDao.save(admin);
	}
	

	@Transactional
	public ForeasModel save(ForeasModel foreas) {
		foreas.setPassword(bcryptEncoder.encode(foreas.getPassword()));
		foreas.setStatus(new StatusKey(StatusEnum.PENDING));
		return this.foreasDao.save(foreas);
	}
	
	
	
	@Transactional
	public ForeasModel updateForeas(Integer foreasId, ForeasModel foreas) {
		
		 if (this.foreasDao.findById(foreasId).isPresent()){
			 
			 ForeasModel existingForeas = this.foreasDao.findById(foreasId).get();

			 existingForeas.setName(foreas.getName());
			 existingForeas.setSurname(foreas.getSurname());
			 existingForeas.setDistinctiveTitle(foreas.getDistinctiveTitle());
			 
			 
			 if (existingForeas.getAitisi()!=null) {
			 for(AitisiModel aitisi : existingForeas.getAitisi()) {
				 aitisi.setForeasTitle(existingForeas.getDistinctiveTitle());
			 }
			 }

			 existingForeas.setAfm(foreas.getAfm());
			 existingForeas.setDoy(foreas.getDoy());
			 existingForeas.setGemh(foreas.getGemh());
			 existingForeas.setAddress(foreas.getAddress());
			 existingForeas.setPhoneNumber(foreas.getPhoneNumber());
			 existingForeas.setFax(foreas.getFax());
			 existingForeas.setEmail(foreas.getEmail());
			 existingForeas.setContactMember(foreas.getContactMember());
			 existingForeas.setUsername(foreas.getUsername());
			 existingForeas.setPassword(bcryptEncoder.encode(foreas.getPassword()));
			 
			 
			 String[] nums = new String[] {
					 existingForeas.getAfm(), existingForeas.getGemh(), existingForeas.getPhoneNumber()
					 };
			 
			 for(String num: nums) {
				 try {
					num = num.replaceAll("\\s+","");
				       Double.parseDouble(num);
				     } catch (NumberFormatException e) {
				    	 return null;
				     } }
			 
			 pattern = Pattern.compile(EMAIL_PATTERN);
			 matcher = pattern.matcher(existingForeas.getEmail());			 
			 
if (matcher.matches()) {
	existingForeas = this.foreasDao.save(existingForeas);
    return existingForeas;
}
else return null;

	        }else{
	            return null;
	        }
	}
	
	
}
