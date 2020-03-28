package igp.depo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import igp.depo.model.Foreas;

@Repository
public interface ForeasDao extends JpaRepository<Foreas, Integer> {
	
	

}
