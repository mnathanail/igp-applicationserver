package igp.depo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import igp.depo.model.Cert;
import igp.depo.model.Document;
import igp.depo.repo.CertDao;
import igp.depo.repo.DocumentDao;


@Service
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	DocumentDao documentDao;
	
	@Autowired
	CertDao certDao;
	
	
	@Override
	@Transactional
	  public Document createDoc(Integer certId, Document document) {
	        Set<Document> docs = new HashSet<>();
	        Optional<Cert> byId = this.certDao.findById(certId);
	        Cert cert = byId.get();

	        //doc -> cert
	        document.setToCert(cert);
	        
	        docs.add(this.documentDao.save(document));
	        
	        //foreas -> cert
	        cert.setDocuments(docs);

	        return document;
	    }
	
	
	@Override
	@Transactional
	public List<Document> findAll(){
		List<Document> docs = this.documentDao.findAll();
		List<Document> docRes = new ArrayList<>();
		for (Document doc : docs) {
			docRes.add(doc);
		}
		return docRes;
	}
	
	
	@Override
	@Transactional
	public void saveAll(Document... docs){
		for (Document doc : docs) {
			documentDao.save(doc);
		}
	}
	
	@Override
	@Transactional
	public void bulkCreate(){ 
		this.documentDao.saveAll(Arrays.asList(
	            new Document("Eforia",true)
              , new Document("Protodikio",true)
              , new Document("AsfalistikosForeas",true)
              , new Document("Eforia1",true)
              , new Document("Protodikio1",true)
              , new Document("AsfalistikosForeas1",true)
              , new Document("Eforia2",true)
              , new Document("Protodikio2",true)
              , new Document("AsfalistikosForeas2",true)
              , new Document("Eforia3",true)
              , new Document("Protodikio3",true)
              , new Document("AsfalistikosForeas3",true)
              , new Document("ESYD1",true)
              , new Document("ESYD2",true)
              ));
	}
	
	@Override
	@Transactional
	public Document save(Document doc){
		return this.documentDao.save(doc);
	}
	
	@Override
	@Transactional
	public Optional<Document> findById(Long id) {
		return this.documentDao.findById(id);
	}
	

}
