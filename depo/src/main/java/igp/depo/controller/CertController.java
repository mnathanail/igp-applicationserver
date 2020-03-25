package igp.depo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import igp.depo.model.Cert;
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
	public String bulkcreate() {
	this.certService.bulkCreate();
	return "Fake Certifications are created";
	}
	
	@PostMapping("/bulksave")
	public String saveAll(@RequestBody Cert... cert){
	this.certService.saveAll(cert);
	return "Certification are saved";
	}
	
	
	@PostMapping("/create")
	public String create(@RequestBody Cert cert){
	this.certService.save(cert);
	return "Certification is created";
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
