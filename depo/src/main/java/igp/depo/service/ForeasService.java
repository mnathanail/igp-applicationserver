package igp.depo.service;

import java.util.List;
import java.util.Optional;

import igp.depo.model.Foreas;

public interface ForeasService {
	
	List<Foreas> findAll();
	Optional<Foreas> findById(Integer id);
	Foreas save(Foreas foreas);
}
