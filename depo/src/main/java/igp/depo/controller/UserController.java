package igp.depo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping("/newforeas")
	public ResponseEntity<String> newForeas(@Valid @RequestBody ForeasModel foreas, BindingResult result){
		
		if(result.hasErrors()) {
			return new ResponseEntity<String>("Kati phge strava",HttpStatus.BAD_REQUEST);
        }
	this.foreasService.save(foreas);	
	return new ResponseEntity<String>("Kalosorises",HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/loginforeas", method = RequestMethod.POST)
	public ResponseEntity<ForeasModel> foreasLogin(@RequestBody ForeasModel foreas) {
		
		if(foreasService.foreasLogin(foreas.getUsername(), foreas.getPassword())!=null) {
			return new ResponseEntity<ForeasModel>(this.foreasService.foreasLogin(foreas.getUsername(), foreas.getPassword()),HttpStatus.OK);
		}
	    return new ResponseEntity<ForeasModel>(this.foreasService.foreasLogin(foreas.getUsername(), foreas.getPassword()), HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping("/{foreasId}/create")
	public ResponseEntity<String> create(@Valid @RequestBody AitisiModel aitisi, BindingResult result, @PathVariable("foreasId") Integer foreasId){
		
		if(result.hasErrors() || this.aitisiService.createAitisi(foreasId,aitisi)==null ) {
			return new ResponseEntity<String>("Apotuxia dhmiourgias",HttpStatus.BAD_REQUEST);
        }

	this.aitisiService.createAitisi(foreasId,aitisi);
	return new ResponseEntity<String>("Epituxhmenh dimiourgia!",HttpStatus.OK);
	}
	


}
