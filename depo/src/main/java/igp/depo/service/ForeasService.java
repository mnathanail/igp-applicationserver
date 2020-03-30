package igp.depo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import igp.depo.model.Foreas;

public interface ForeasService {
	
	List<Foreas> findAll();
	Optional<Foreas> findById(Integer id);
	boolean save(Foreas foreas);
	Optional<Foreas> findByUsername(String username);
	
	boolean foreasLogin(Foreas foreas);
}
