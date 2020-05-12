package igp.depo.service;

import java.util.List;

import igp.depo.model.RegulatedActivity;

public interface RegulatedActivityService {
	
	void batchCreate();
	
	List<RegulatedActivity> getRegulatedActivities();

}
