package igp.depo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import igp.depo.model.Document;

@Repository
public interface DocumentDao extends JpaRepository<Document, Long>{

}
