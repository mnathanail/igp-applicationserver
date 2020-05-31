package igp.depo.service;

import java.util.List;
import java.util.Optional;
import igp.depo.model.ForeasModel;

public interface ForeasService {
	List<ForeasModel> findAll();
	Optional<ForeasModel> findById(Integer id);
	ForeasModel findByUsername(String username);
	ForeasModel foreasLogin(String username, String password);
	
	void sendmail(String recipient, String msg);
}
