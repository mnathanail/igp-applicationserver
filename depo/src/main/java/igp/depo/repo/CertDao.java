package igp.depo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import igp.depo.model.Cert;


@Repository
public interface CertDao extends JpaRepository<Cert, Integer> {

	 
	
}
