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
import igp.depo.model.Foreas;
import igp.depo.repo.CertDao;
import igp.depo.repo.ForeasDao;

@Service
public class CertServiceImpl implements CertService {
	
	@Autowired
	CertDao certDao;
	
	@Autowired
	ForeasDao foreasDao;
	
	
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
	public void updateCert(Cert cert) {
		this.certDao.updateCert(cert.getCompanyId(),cert.getRegulatedActivity(),cert.isDocument1(),cert.isDocument2(),cert.isDocument3(),cert.isDocument4(),cert.isDocument5(),cert.isDocument6(),cert.isDocument7(),cert.isDocument8(),cert.isDocument9(),cert.isDocument10(),cert.isDocument11(),cert.isDocument12(),cert.isDocument13(),cert.isDocument14());
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
	public void bulkCreate(){
		
		/*this.certDao.saveAll(Arrays.asList(
	            new Cert(2,"Paidotopoi",true,false,true,true,true,true,false,true,true,false,true,true,true,true)
              , new Cert(3,"Klinikh",true,false,true,true,true,true,false,true,true,false,true,true,true,true)
              , new Cert(4,"Xenodoxeio",true,false,true,true,true,true,false,true,true,false,true,true,true,true)
              ));*/
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
