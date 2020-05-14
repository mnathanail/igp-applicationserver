package igp.depo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import igp.depo.annotations.UniqueUsername;



@Entity
@Table(name = "MINISTRY")
public class AdminModel implements Serializable{
	
	private static final long serialVersionUID = 1438176707430182907L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ADMINID")
	private Integer admin_id;
	
	@NotBlank
	@Size(min = 4, max = 30)
	@Column(name = "ADMINUSERNAME")
	@UniqueUsername(message="Username already exists")
	private String adminusername;
	
	@NotBlank
	@Column(name = "ADMINPASSWORD", columnDefinition="text", length=10485760)
	private String adminpassword;

    private boolean active = true;
	
    private String roles = "ROLE_ADMIN";

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdminUsername() {
		return adminusername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminusername = adminUsername;
	}

	public String getAdminPassword() {
		return adminpassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminpassword = adminPassword;
	}

	@JsonIgnore
	public boolean isActive() {
		return active;
	}

	@JsonIgnore
	public void setActive(boolean active) {
		this.active = active;
	}

	@JsonIgnore
	public String getRoles() {
		return roles;
	}

	@JsonIgnore
	public void setRoles(String roles) {
		this.roles = roles;
	}
    
}





