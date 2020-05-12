package igp.depo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import igp.depo.model.RegulatedActivity;


@Repository
public interface RegulatedActivityDao extends JpaRepository<RegulatedActivity, Integer> {
	
	RegulatedActivity findByName(String name);
	
	@Query("SELECT r FROM RegulatedActivity r")
	List<RegulatedActivity> findAllRegulatedActivities();
	
}