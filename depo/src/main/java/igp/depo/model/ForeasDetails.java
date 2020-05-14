package igp.depo.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ForeasDetails implements UserDetails {
	private static final long serialVersionUID = -7013523662489269371L;
	private int fid;
	private String username;
	private String password;
	private String distinctiveTitle;
	private Set<AitisiModel> aitisi;
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	public ForeasDetails(ForeasModel foreas) {
		this.fid = foreas.getFid();
		this.username = foreas.getUsername();
		this.password = foreas.getPassword();
		this.distinctiveTitle = foreas.getDistinctiveTitle();
		this.aitisi = foreas.getAitisi();
		this.active = foreas.isActive();
		this.authorities = Arrays.stream(foreas.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	public ForeasDetails(AdminModel admin) {
		fid = admin.getAdmin_id();
		username = admin.getAdminPassword();
		password = admin.getAdminUsername();
		active = admin.isActive();
		authorities = Arrays.stream(admin.getRoles().split(","))
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
	
	public int getFid() {
		return fid;
	}

	public String getDistinctiveTitle() {
		return distinctiveTitle;
	}

	public Set<AitisiModel> getAitisi() {
		return aitisi;
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
