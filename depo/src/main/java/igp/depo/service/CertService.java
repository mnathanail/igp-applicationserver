package igp.depo.service;

import java.util.List;
import java.util.Optional;

import igp.depo.model.Cert;

public interface CertService {
	
	List<Cert> findAll();
	void saveAll(Cert... certs);
	
	Cert save(Cert cert);
	
	Optional<Cert> findById(Integer id);
	
	public void updateCert(Cert cert);
	public void deleteCert(int id);
	
	Cert createCert(Integer foreasId, Cert cert);
	
	 Cert bindCert(Integer certId, Integer foreasId);

	
}
