package igp.depo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import igp.depo.model.Cert;


@Repository
public interface CertDao extends JpaRepository<Cert, Integer> {

	 
	@Modifying(clearAutomatically = true)
    @Query("UPDATE Cert c SET c.regulatedActivity = :regulatedActivity WHERE c.companyId = :companyId")
    public void updateCert(@Param("companyId") int companyId, @Param("regulatedActivity") String regulatedActivity);
	
	@Modifying(clearAutomatically = true)
    @Query("DELETE FROM Cert c WHERE c.companyId = :companyId")
	public void deleteCert(@Param("companyId") int companyId);
	
	
}
