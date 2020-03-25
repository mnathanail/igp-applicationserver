package igp.depo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import igp.depo.model.Cert;

public interface CertService {
	
	List<Cert> findAll();
	void saveAll(Cert... certs);
	
	Cert save(Cert cert);
	Optional<Cert> findById(int id);
	
	void bulkCreate();
	
	public void updateCert(Cert cert);
	public void deleteCert(int id);

	
}
