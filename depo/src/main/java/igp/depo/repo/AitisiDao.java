package igp.depo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import igp.depo.model.AitisiModel;

@Repository
public interface AitisiDao extends JpaRepository<AitisiModel, Integer> {	
	
	@Query("SELECT a FROM AitisiModel a")
	List<AitisiModel> findAllAitisis();
	
	@Query("FROM AitisiModel WHERE extract(month FROM submition_date) = :month")
	List<AitisiModel> findAitisisByMonth(@Param("month") Integer month);
	
}
