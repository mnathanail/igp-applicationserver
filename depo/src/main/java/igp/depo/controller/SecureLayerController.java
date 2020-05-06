package igp.depo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import igp.depo.model.ForeasModel;
import igp.depo.service.ForeasDetailsService;

@RestController
@CrossOrigin
public class SecureLayerController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ForeasDetailsService userDetailsService;
	
	
	@RequestMapping(value = "/loginforeas", method = RequestMethod.POST)
	public ResponseEntity<?> foreasUsername(@RequestBody ForeasModel foreas) throws Exception {
		authenticate(foreas.getUsername(), foreas.getPassword());
		
		if(userDetailsService.loadUserByUsername(foreas.getUsername())!=null) {
			return ResponseEntity.ok(userDetailsService.loadUserByUsername(foreas.getUsername()));
		}
	    return new ResponseEntity<String>("Ο χρήστης δεν βρέθηκε..",HttpStatus.BAD_REQUEST);
	}
	
	/*

	@PostMapping("/newforeas")
	public ResponseEntity<?> newForeas(@Valid @RequestBody ForeasModel foreas, BindingResult result){
		
		if(result.hasErrors()) {
			return new ResponseEntity<String>("Kati phge strava", HttpStatus.BAD_REQUEST);
        }
		return ResponseEntity.ok(userDetailsService.save(foreas));
	}
	*/

	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
	
}
