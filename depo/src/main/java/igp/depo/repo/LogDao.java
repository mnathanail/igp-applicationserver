package igp.depo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import igp.depo.model.LogModel;

@Repository
public interface LogDao extends JpaRepository<LogModel, Integer>{

	@Query("SELECT m FROM LogModel m WHERE m.foreasid = ?1")
	List<LogModel> findAllForeasLogs(Integer foreasid);
	
}
