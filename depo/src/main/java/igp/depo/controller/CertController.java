package igp.depo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
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
import igp.depo.model.Document;
import igp.depo.model.Foreas;
import igp.depo.service.CertService;
import igp.depo.service.DocumentService;
import igp.depo.service.ForeasService;


@RestController
@RequestMapping("/")
public class CertController {
	
	@Autowired
	private CertService certService;
	
	@Autowired
	private ForeasService foreasService;
	
	@Autowired
	private DocumentService documentService;
	
	@GetMapping("/")
	public String index(){
		
	return "silence is gold";
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
	
	@RequestMapping(value = "bindcert/{certId}/{foreasId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cert createDoc(@PathVariable(value = "certId") Integer certId, @PathVariable(value = "foreasId") Integer foreasId) {
        return this.certService.bindCert(certId, foreasId);
    }
	
	@PostMapping("/newforeas")
	public CertResponseModel newForeas(@Valid @RequestBody Foreas foreas,  final BindingResult bindingResult){
		
		if(bindingResult.hasErrors() || this.foreasService.save(foreas)==false )
			return new CertResponseModel("Kati phge strava :(");
			
	return new CertResponseModel("Neos Foreas!");
	}

	
    @RequestMapping(value = "/{foreasId}/createcert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Cert createCert(@PathVariable(value = "foreasId") Integer foreasId, @RequestBody Cert cert) {
        return this.certService.createCert(foreasId, cert);
    }
    
    @GetMapping("/findallforeis")
	public List<Foreas> findAllForeis(){
	List<Foreas> foreis = this.foreasService.findAll();
	return foreis;
	}
    
    
    
	
    @PostMapping("/newdoc")
	public CertResponseModel newDoc(@RequestBody Document document){
	this.documentService.save(document);
	return new CertResponseModel("Neo Document!");
	}
    
    @RequestMapping(value = "/{certId}/createdoc", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Document createDoc(@PathVariable(value = "certId") Integer certId, @RequestBody Document document) {
        return this.documentService.createDoc(certId, document);
    }
    
    @RequestMapping(value = "binddoc/{docId}/{certId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Document bindDoc(@PathVariable(value = "docId") Long docId, @PathVariable(value = "certId") Integer certId) {
        return this.documentService.bindDoc(docId, certId);
    }
    
	@GetMapping("/bulkcreate")
	public CertResponseModel bulkcreate() {
	this.documentService.bulkCreate();
	return new CertResponseModel("Fake Documents are created");
	}

	@GetMapping("/findalldocs")
	public List<Document> findAllDocs(){
	List<Document> docs = this.documentService.findAll();
	return docs;
	}

}
