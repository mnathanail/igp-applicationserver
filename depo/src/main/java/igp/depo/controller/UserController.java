package igp.depo.controller;


import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import igp.depo.model.AitisiModel;
import igp.depo.model.ForeasModel;
import igp.depo.service.AitisiService;
import igp.depo.service.ForeasService;

@RestController
public class UserController {
	
	@Autowired
	private ForeasService foreasService;
	
	@Autowired
	private AitisiService aitisiService;
	
	@GetMapping("/")
	public String index(){
	return "silence is gold";
	}

	@RequestMapping(value = "/{foreasId}/create", method = RequestMethod.POST)
	public ResponseEntity<String> create(@Valid @RequestBody AitisiModel aitisi, BindingResult result, @PathVariable("foreasId") Integer foreasId){
		
		if(result.hasErrors() || this.aitisiService.createAitisi(foreasId,aitisi)==null ) {
			return new ResponseEntity<String>("Apotuxia dhmiourgias",HttpStatus.BAD_REQUEST);
        }

	this.aitisiService.createAitisi(foreasId,aitisi);
	return new ResponseEntity<String>("Epituxhmenh dimiourgia!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/aitisis/{foreasId}", method = RequestMethod.GET)
	public ResponseEntity<?> getAitisisForea(@PathVariable("foreasId") Integer foreasId){
		
		if(this.aitisiService.fetchAitisis(foreasId).isEmpty())
			return new ResponseEntity<String>("Δεν βρέθηκαν αιτήσεις για τον φορέα",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Set<AitisiModel>>(this.aitisiService.fetchAitisis(foreasId),HttpStatus.OK);
	}

	
	@RequestMapping(value = "/loginusername", method = RequestMethod.POST)
	public ForeasModel foreasUsername(@RequestBody ForeasModel foreas) {
		
		if(foreasService.findByUsername(foreas.getUsername())!=null) {
			return foreasService.findByUsername(foreas.getUsername());
		}
	    return foreasService.findByUsername(foreas.getUsername());
	}
	
}
