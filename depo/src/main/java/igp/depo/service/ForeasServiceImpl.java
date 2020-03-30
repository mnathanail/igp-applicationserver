package igp.depo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import igp.depo.model.Foreas;
import igp.depo.repo.ForeasDao;
import igp.depo.validations.Validator;


@Service
public class ForeasServiceImpl implements ForeasService{
	
	@Autowired
	ForeasDao foreasDao;

	@Autowired
	Validator validate;
	
	@Override
	@Transactional
	public boolean foreasLogin(Foreas foreas) {
		
		
		
		try {
			Optional<Foreas> f = foreasDao.findByUsername(foreas.getUsername());
			Foreas f1 = f.get();
			if(f1 == null)
				return false;
			if(!f1.getPassword().equals(foreas.getPassword()))
				return false;
		}catch(Exception e) {
			return false;
		}
	        return true ;
	
	}
	
	
	@Override
	@Transactional
	public Optional<Foreas> findByUsername(String username){
		return this.foreasDao.findByUsername(username);
	}

	@Override
	@Transactional
	public List<Foreas> findAll() {
		return this.foreasDao.findAll();
	}

	@Override
	@Transactional
	public boolean save(Foreas foreas) {
		
		if(!( validate.validateEmail(foreas.getEmail()) && validate.isNumeric(foreas.getAfm(),foreas.getFax(),foreas.getPhoneNumber())))
			return false;
		
		List<Foreas> foreis = foreasDao.findAll();
		
		for(Foreas f : foreis) {
			if((f.getUsername().equals(foreas.getUsername()) || f.getEmail().equals(foreas.getEmail()) || f.getAfm().equals(foreas.getAfm()))) {
				return false;
			}
		}
			this.foreasDao.save(foreas);
			return true;
	}
	
	@Override
	@Transactional
	public Optional<Foreas> findById(Integer id) {
		Optional<Foreas> foreasRes = foreasDao.findById(id);
		return foreasRes;
	}

}
