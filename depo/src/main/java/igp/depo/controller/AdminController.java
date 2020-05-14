package igp.depo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import igp.depo.model.AdminModel;
import igp.depo.service.ForeasDetailsService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	private ForeasDetailsService userDetailsService;
	
	@RequestMapping(value = "/newadmin", method = RequestMethod.POST)
	public ResponseEntity<?> newForeas(@Valid @RequestBody AdminModel admin, BindingResult result){
		if(result.hasErrors()) {
			return new ResponseEntity<String>("Kati phge strava", HttpStatus.BAD_REQUEST);
        }

	return new ResponseEntity<AdminModel>(this.userDetailsService.save(admin),HttpStatus.CREATED);
	}

}

