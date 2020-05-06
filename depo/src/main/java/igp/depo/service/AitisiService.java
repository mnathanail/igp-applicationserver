package igp.depo.service;

import java.util.Set;

import igp.depo.model.AitisiModel;
import igp.depo.model.StatusKey;

public interface AitisiService {
	
	AitisiModel createAitisi(Integer foreasId, AitisiModel aitisi);
	Set<AitisiModel> fetchAitisis (Integer foreasId);
	
	AitisiModel updateAitisi(Integer aitisiId, StatusKey status);
}
