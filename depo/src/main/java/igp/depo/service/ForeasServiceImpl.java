package igp.depo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import igp.depo.model.Foreas;
import igp.depo.repo.ForeasDao;


@Service
public class ForeasServiceImpl implements ForeasService{
	
	@Autowired
	ForeasDao foreasDao;


	@Override
	public List<Foreas> findAll() {
		return this.foreasDao.findAll();
	}

	@Override
	public Foreas save(Foreas foreas) {
		return this.foreasDao.save(foreas);
	}
	
	@Override
	@Transactional
	public Optional<Foreas> findById(Integer id) {
		Optional<Foreas> foreasRes = foreasDao.findById(id);
		return foreasRes;
	}

}
