package igp.depo.service;

import java.util.List;
import java.util.Optional;

import igp.depo.model.Document;


public interface DocumentService {
	
	List<Document> findAll();
	void saveAll(Document... documents);
	
	Document save(Document document);
	
	Optional<Document> findById(Long id);
	
	public void bulkCreate();
	
	//public void updateDoc(Document document);
	//public void deleteDoc(long id);
	
	Document createDoc(Integer certId, Document document);

}
