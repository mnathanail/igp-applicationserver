package igp.depo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import igp.depo.model.CertResponseModel;
import igp.depo.model.Foreas;
import igp.depo.service.ForeasService;

@RestController
public class UserController {
	
	@Autowired
	private ForeasService foreasService;
	
	
	@PostMapping("/loginforeas")
	public CertResponseModel foreasLogin(@RequestBody Foreas foreas){
	return foreasService.foreasLogin(foreas) ? new CertResponseModel("Kalosorises ") : new CertResponseModel("Lanthasmena stoixeia ");  
	}

}
