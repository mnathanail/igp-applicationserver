package igp.depo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import igp.depo.model.ForeasDetails;
import igp.depo.model.ForeasModel;
import igp.depo.model.StatusKey;
import igp.depo.repo.ForeasDao;
import igp.depo.utils.StatusEnum;

@Service
public class ForeasDetailsService implements UserDetailsService {
	
	@Autowired
	private ForeasDao foreasDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ForeasModel foreas = foreasDao.findByUsername(username);
		
		if(foreas == null)
			new UsernameNotFoundException("username "+username+" not found.");
		
		return new ForeasDetails(foreas);

	}

	@Transactional
	public ForeasModel save(ForeasModel foreas) {
		foreas.setPassword(bcryptEncoder.encode(foreas.getPassword()));
		foreas.setStatus(new StatusKey(StatusEnum.PENDING));
		return this.foreasDao.save(foreas);
	}
}
