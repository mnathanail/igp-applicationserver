package igp.depo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import igp.depo.model.AitisiModel;

@Repository
public interface AitisiDao extends JpaRepository<AitisiModel, Integer> {	
	
}
