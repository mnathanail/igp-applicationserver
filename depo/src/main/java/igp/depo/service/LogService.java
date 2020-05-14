package igp.depo.service;

import java.util.List;

import igp.depo.model.LogModel;

public interface LogService {

	List<LogModel> findForeasLogs(int foreasid);
	
}
