package igp.depo.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import igp.depo.model.Foreas;
import igp.depo.model.ForeasDetails;
import igp.depo.repo.ForeasDao;

import java.util.Optional;

@Service
 public class MyUserDetailsService implements UserDetailsService {

   @Autowired
    ForeasDao foreasRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Foreas> foreas = foreasRepository.findByUsername(username);

        foreas.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return foreas.map(ForeasDetails::new).get();
    }
}