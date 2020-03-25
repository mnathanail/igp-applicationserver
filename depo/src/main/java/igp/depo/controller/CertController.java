package igp.depo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import igp.depo.model.Cert;
import igp.depo.model.CertResponseModel;
import igp.depo.service.CertService;


@RestController
@RequestMapping("/")
public class CertController {
	
	@Autowired
	private CertService certService;
	
	
	@GetMapping("/")
	public String index(){
		
	return "silence is gold";
	}
	
	@GetMapping("/bulkcreate")
	public CertResponseModel bulkcreate() {
	this.certService.bulkCreate();
	return new CertResponseModel("Fake Certifications are created");
	}
	
	@PostMapping("/bulksave")
	public CertResponseModel saveAll(@RequestBody Cert... cert){
	this.certService.saveAll(cert);
	return new CertResponseModel("Certifications are created");
	}
	
	
	@PutMapping("/update")
	public CertResponseModel updateCert(@RequestBody Cert cert) {
		this.certService.updateCert(cert);
		return new CertResponseModel("Certification succesfully updated");
	}
	
	@RequestMapping("/delete/{id}")
	public CertResponseModel deleteCert(@PathVariable("id") int id) {
		this.certService.deleteCert(id);
	return new CertResponseModel("Certification succesfully deleted");
	}
	
	
	@PostMapping("/create")
	public CertResponseModel create(@RequestBody Cert cert){
	this.certService.save(cert);
	return new CertResponseModel("Success");
	}
	
	
	@GetMapping("/findall")
	public List<Cert> findAll(){
	List<Cert> certs = this.certService.findAll();
	return certs;
	}
	
	
	@RequestMapping("/search/{id}")
	public Optional<Cert> search(@PathVariable("id") Integer id){
	Optional<Cert> cert = this.certService.findById(id);
	return cert;
	}


}
