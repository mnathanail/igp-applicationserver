package igp.depo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import igp.depo.model.Cert;
import igp.depo.model.Document;
import igp.depo.model.Foreas;
import igp.depo.repo.CertDao;
import igp.depo.repo.DocumentDao;
import igp.depo.repo.ForeasDao;

@Service
public class CertServiceImpl implements CertService {
	
	@Autowired
	CertDao certDao;
	
	@Autowired
	ForeasDao foreasDao;
	
	@Autowired
	DocumentDao documentDao;
	
	
	@Override
	@Transactional
	  public Cert createCert(Integer foreasId, Cert cert) {
	        Set<Cert> certs = new HashSet<>();
	        //Foreas foreas1 = new Foreas();

	        Optional<Foreas> byId = this.foreasDao.findById(foreasId);
	        Foreas foreas = byId.get();

	        //cert -> foreas
	        cert.setForeas(foreas);

	        //Cert cert1 = this.certDao.save(cert);
	        
	        certs.add(this.certDao.save(cert));
	        //foreas1.setCertifications(certs);
	        
	        //foreas -> cert
	        foreas.setCertifications(certs);

	        //return cert1;
	        return cert;
	    }
	
	
	@Override
	@Transactional
	  public Cert bindCert(Integer certId, Integer foreasId) {
	        
		Set<Cert> certs = new HashSet<>();
		
	        Optional<Cert> certById = this.certDao.findById(certId);
	        Optional<Foreas> foreasById = this.foreasDao.findById(foreasId);
	       
	        Foreas foreas = foreasById.get();
	        Cert cert = certById.get();
	        
	        
	        if(cert.getForeas() != null) {
	        	
	        	// Defensive copy
	        	Set<Cert> certs1 = new HashSet<>();
	        	Set<Document> docs = new HashSet<>();
	        	docs.addAll(cert.getDocuments());
	        	Cert cert1 = new Cert(cert.getDocuments(),cert.getRegulatedActivity());
	        	cert1.setForeas(foreas);
	        	cert1.setDocuments(docs);
	        	certs1.add(this.certDao.save(cert1));
	        	foreas.setCertifications(certs);
		        return cert1;
	        }
	     
	        cert.setForeas(foreas);
	        certs.add(this.certDao.save(cert));
	        foreas.setCertifications(certs);

	        return cert;
	    }
	
	@Override
	@Transactional
	public void updateCert(Cert cert) {
		this.certDao.updateCert(cert.getCompanyId(),cert.getRegulatedActivity());
	}
	
	@Override
	@Transactional
	public void deleteCert(int id) {
		this.certDao.deleteCert(id);
	}
	
	@Override
	@Transactional
	public List<Cert> findAll(){
		List<Cert> certs = this.certDao.findAll();
		List<Cert> certRes = new ArrayList<>();
		for (Cert cert : certs) {
			certRes.add(cert);
		}
		return certRes;
	}
	
	
	@Override
	@Transactional
	public void saveAll(Cert... certs){
		for (Cert cert : certs) {
		certDao.save(cert);
		}
	}
	
	@Override
	@Transactional
	public Cert save(Cert cert){
		return this.certDao.save(cert);
	}
	
	@Override
	@Transactional
	public Optional<Cert> findById(Integer id) {
		return this.certDao.findById(id);
	}

}
