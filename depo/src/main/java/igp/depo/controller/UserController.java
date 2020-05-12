package igp.depo.controller;


import java.util.List;
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
import igp.depo.model.RegulatedActivity;
import igp.depo.model.StatusKey;
import igp.depo.service.AitisiService;
import igp.depo.service.ForeasDetailsService;
import igp.depo.service.ForeasService;
import igp.depo.service.RegulatedActivityService;

@RestController
public class UserController {
	
	@Autowired
	private ForeasService foreasService;
	
	@Autowired
	private AitisiService aitisiService;
	
	@Autowired
	private ForeasDetailsService userDetailsService;
	
	@Autowired
	private RegulatedActivityService regulatedActivityService;
	
	@GetMapping("/")
	public String index(){
	return "silence is gold";
	}
	
	@RequestMapping(value = "/newforeas", method = RequestMethod.POST)
	public ResponseEntity<?> newForeas(@Valid @RequestBody ForeasModel foreas, BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<String>("Kati phge strava", HttpStatus.BAD_REQUEST);
        }

	return new ResponseEntity<ForeasModel>(this.userDetailsService.save(foreas),HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{foreasId}/create", method = RequestMethod.POST)
	public ResponseEntity<?> create(@Valid @RequestBody AitisiModel aitisi, BindingResult result, @PathVariable("foreasId") Integer foreasId){
		
		if(result.hasErrors() || this.aitisiService.createAitisi(foreasId,aitisi)==null ) {
			return new ResponseEntity<String>("Apotuxia dhmiourgias",HttpStatus.BAD_REQUEST);
        }

	
	return new ResponseEntity<AitisiModel>(this.aitisiService.createAitisi(foreasId,aitisi),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/aitisis/{foreasId}", method = RequestMethod.GET)
	public ResponseEntity<?> getAitisisForea(@PathVariable("foreasId") Integer foreasId){
		
		if(this.aitisiService.fetchAitisis(foreasId).isEmpty())
			return new ResponseEntity<String>("Δεν βρέθηκαν αιτήσεις για τον φορέα",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<Set<AitisiModel>>(this.aitisiService.fetchAitisis(foreasId),HttpStatus.OK);
	}
	
	
	/*@RequestMapping(value = "/loginforeas", method = RequestMethod.POST)
	public ForeasModel loginForeas(@RequestBody ForeasModel foreas) {
		
		if(foreasService.findByUsername(foreas.getUsername())!=null) {
			return foreasService.findByUsername(foreas.getUsername());
		}
	    return foreasService.findByUsername(foreas.getUsername());
	}*/

	
	@RequestMapping(value = "/loginusername", method = RequestMethod.POST)
	public ForeasModel foreasUsername(@RequestBody ForeasModel foreas) {
		
		if(foreasService.findByUsername(foreas.getUsername())!=null) {
			return foreasService.findByUsername(foreas.getUsername());
		}
	    return foreasService.findByUsername(foreas.getUsername());
	}
	
	
	@RequestMapping(value = "/status/{aitisiId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAitisisForea(@PathVariable("aitisiId") Integer aitisiId, @RequestBody StatusKey status){
		
		if(this.aitisiService.updateAitisi(aitisiId, status)==null)
			return new ResponseEntity<String>("Αποτυχία αλλαγής",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<AitisiModel>(this.aitisiService.updateAitisi(aitisiId, status),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/foreas/{foreasId}", method = RequestMethod.GET)
	public ResponseEntity<?> getForeas(@PathVariable("foreasId") Integer foreasId){
		
		if(this.foreasService.findById(foreasId)==null)
			return new ResponseEntity<String>("Δεν υπάρχει χρήστης με αυτό το id",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<ForeasModel>(this.foreasService.findById(foreasId).get(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/updateforeas/{foreasId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAitisisForea(@PathVariable("foreasId") Integer foreasId, @RequestBody ForeasModel foreas){
		
		if(this.userDetailsService.updateForeas(foreasId, foreas)==null)
			return new ResponseEntity<String>("Αποτυχία αλλαγής",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<ForeasModel>(this.userDetailsService.updateForeas(foreasId, foreas),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/admin/getaitisis", method = RequestMethod.GET)
	public  ResponseEntity<?> getAitisis(){
		if(this.aitisiService.findAllAitisis() == null)
			return new ResponseEntity<String>("Δεν υπάρχουν αιτήσεις",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<AitisiModel>>(this.aitisiService.findAllAitisis(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/admin/batchcreate", method = RequestMethod.POST)
	public void batchCreate(){
		regulatedActivityService.batchCreate();
	}
	
	@RequestMapping(value = "/getregulatedactivities", method = RequestMethod.GET)
	public ResponseEntity<?> getRegulatedActivites(){
		if(this.regulatedActivityService.getRegulatedActivities().isEmpty())
			return new ResponseEntity<String>("Δεν υπάρχουν δραστηριοτητες φορέα",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<RegulatedActivity>>(this.regulatedActivityService.getRegulatedActivities(),HttpStatus.OK);
	}
	
}
