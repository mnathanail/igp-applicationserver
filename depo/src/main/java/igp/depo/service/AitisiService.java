package igp.depo.service;

import java.util.Set;

import igp.depo.model.AitisiModel;

public interface AitisiService {
	
	AitisiModel createAitisi(Integer foreasId, AitisiModel aitisi);
	Set<AitisiModel> fetchAitisis (Integer foreasId);
}
