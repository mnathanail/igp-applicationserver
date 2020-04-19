package igp.depo.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ForeasDetails implements UserDetails {
	private static final long serialVersionUID = -7013523662489269371L;
	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	public ForeasDetails(ForeasModel foreas) {
		this.username = foreas.getUsername();
		this.password = foreas.getPassword();
		this.active = foreas.isActive();
		this.authorities = Arrays.stream(foreas.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	public ForeasDetails() {}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public String getUsername() {
		return this.username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return this.active;
	}
	
	
	

}
