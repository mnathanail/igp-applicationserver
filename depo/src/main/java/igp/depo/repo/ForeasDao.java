package igp.depo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import igp.depo.model.ForeasModel;

@Repository
public interface ForeasDao extends JpaRepository<ForeasModel, Integer> {
	
	ForeasModel findByUsername(String username);
	ForeasModel findByName(String name);
	ForeasModel findByEmail(String email);
	
}
