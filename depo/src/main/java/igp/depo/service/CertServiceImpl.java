package igp.depo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import igp.depo.model.Cert;
import igp.depo.repo.CertDao;

@Service
public class CertServiceImpl implements CertService {
	
	@Autowired
	CertDao certDao;
	
	@Override
	@Transactional
	public List<Cert> findAll(){
		List<Cert> certs = this.certDao.findAll();
		List<Cert> certRes = new ArrayList<>();
		for (Cert cert : certs) {
			certRes.add(new Cert(cert.getCompanyId(),cert.getRegulatedActivity(),cert.isDocument1(),cert.isDocument2(),cert.isDocument3(),cert.isDocument4(),cert.isDocument5(),cert.isDocument6(),cert.isDocument7(),cert.isDocument8(),cert.isDocument9(),cert.isDocument10(),cert.isDocument11(),cert.isDocument12(),cert.isDocument13(),cert.isDocument14()));
		}
		return certRes;
	}
	
	
	@Override
	@Transactional
	public void saveAll(Cert... certs){
		for (Cert cert : certs) {
		certDao.save(new Cert(cert.getCompanyId(),cert.getRegulatedActivity(),cert.isDocument1(),cert.isDocument2(),cert.isDocument3(),cert.isDocument4(),cert.isDocument5(),cert.isDocument6(),cert.isDocument7(),cert.isDocument8(),cert.isDocument9(),cert.isDocument10(),cert.isDocument11(),cert.isDocument12(),cert.isDocument13(),cert.isDocument14()));
		}
	}
	

	@Override
	@Transactional
	public void bulkCreate(){
		
		this.certDao.saveAll(Arrays.asList(
	            new Cert(2,"Paidotopoi",true,false,true,true,true,true,false,true,true,false,true,true,true,true)
              , new Cert(3,"Klinikh",true,false,true,true,true,true,false,true,true,false,true,true,true,true)
              , new Cert(4,"Xenodoxeio",true,false,true,true,true,true,false,true,true,false,true,true,true,true)
              ));
		
	}
	
	@Override
	@Transactional
	public Cert save(Cert cert){
		Cert certRes = this.certDao.save(new Cert(cert.getCompanyId(),cert.getRegulatedActivity(),cert.isDocument1(),cert.isDocument2(),cert.isDocument3(),cert.isDocument4(),cert.isDocument5(),cert.isDocument6(),cert.isDocument7(),cert.isDocument8(),cert.isDocument9(),cert.isDocument10(),cert.isDocument11(),cert.isDocument12(),cert.isDocument13(),cert.isDocument14()));
		return certRes;
	}
	
	@Override
	@Transactional
	public Optional<Cert> findById(int id) {
		Optional<Cert> certRes = this.certDao.findById(id);
		return certRes;
	}

}
