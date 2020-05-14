package igp.depo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import igp.depo.model.LogModel;
import igp.depo.repo.LogDao;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logDao;
	
	@Override
	@Transactional
	public List<LogModel> findForeasLogs(int foreasid) {
		
		return this.logDao.findAllForeasLogs(foreasid);
		
	}
	
}
