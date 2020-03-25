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
    @Query("UPDATE Cert c SET c.regulatedActivity = :regulatedActivity, c.document1 = :doc1, c.document2 = :doc2, c.document3 = :doc3, c.document4 = :doc4, c.document5 = :doc5, c.document6 = :doc6, c.document7 = :doc7, c.document8 = :doc8, c.document9 = :doc9, c.document10 = :doc10, c.document11 = :doc11, c.document12 = :doc12, c.document13 = :doc13, c.document14 = :doc14  WHERE c.companyId = :companyId")
    public void updateCert(@Param("companyId") int companyId, @Param("regulatedActivity") String regulatedActivity, @Param("doc1") boolean doc1, @Param("doc2") boolean doc2, @Param("doc3") boolean doc3, @Param("doc4") boolean doc4, @Param("doc5") boolean doc5, @Param("doc6") boolean doc6, @Param("doc7") boolean doc7, @Param("doc8") boolean doc8, @Param("doc9") boolean doc9, @Param("doc10") boolean doc10, @Param("doc11") boolean doc11, @Param("doc12") boolean doc12, @Param("doc13") boolean doc13, @Param("doc14") boolean doc14);
	
	@Modifying(clearAutomatically = true)
    @Query("DELETE FROM Cert c WHERE c.companyId = :companyId")
	public void deleteCert(@Param("companyId") int companyId);
	
	
}
