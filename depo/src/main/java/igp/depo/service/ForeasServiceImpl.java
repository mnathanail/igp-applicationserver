package igp.depo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import igp.depo.model.ForeasModel;
import igp.depo.model.StatusKey;
import igp.depo.repo.ForeasDao;
import igp.depo.utils.StatusEnum;


@Service
public class ForeasServiceImpl implements ForeasService{
	
	@Autowired
	private ForeasDao foreasDao;

	
	@Override
	@Transactional
	public ForeasModel foreasLogin(String username, String password) {
		
		ForeasModel foreas = foreasDao.findByUsername(username);
		try {
			if(foreas == null)
				return null;
			if(!foreas.getPassword().equals(password))
				return null;
		}catch(Exception e) {
			return null;
		}
	        return foreas ;
	}
	
	
	@Override
	@Transactional
	public ForeasModel findByUsername(String username){
		return foreasDao.findByUsername(username);
	}
	

	@Override
	@Transactional
	public List<ForeasModel> findAll() {
		return this.foreasDao.findAll();
	}

	@Override
	@Transactional
	public void save(ForeasModel foreas) {
		foreas.setStatus(new StatusKey(StatusEnum.PENDING));
		this.foreasDao.save(foreas);
	}
	
	@Override
	@Transactional
	public Optional<ForeasModel> findById(Integer id) {
		Optional<ForeasModel> foreasRes = foreasDao.findById(id);
		return foreasRes;
	}
	

}
