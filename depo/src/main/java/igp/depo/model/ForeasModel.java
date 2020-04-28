package igp.depo.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import igp.depo.annotations.EmailValidation;
import igp.depo.annotations.NumberValidation;
import igp.depo.annotations.UniqueUsername;

@Entity
@Table(name = "FOREAS")
public class ForeasModel implements Serializable{

	private static final long serialVersionUID = -4831428130684547448L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "FOREASID")
	private Integer fid;

	
	@NotBlank
	@Size(min = 2, max = 30)
	@Column(name = "NAME")
	private String name;
	
	@NotBlank
	@Size(min = 2, max = 30)
	@Column(name = "SURNAME")
	private String surname;
	
	@NotBlank
	@Column(name = "TITLE")
	private String distinctiveTitle;
	
	@NotBlank
	@Size(min = 9, max = 9)
	@NumberValidation(message="Incorrect Number")
	private String afm;
	
	@NotBlank
	@Column(name = "DOY")
	private String doy;
	
	@NotBlank
	@Column(name = "GEMH")
	private String gemh;
	
	@NotBlank
	@Column(name = "ADDRESS")
	private String address;
	
	@NotBlank
	@Column(name = "PHONE")
	@NumberValidation(message="Incorrect Number")
	private String phoneNumber;
	
	@Column(name = "FAX")
	private String fax;
	
	@NotBlank
	@Column(name = "EMAIL")
	@EmailValidation(message="Incorrect Email")
	private String email;
	
	@NotBlank
	@Column(name = "CONTACTMEMBER")
	private String contactMember;
	
	@NotBlank
	@Size(min = 4, max = 30)
	@Column(name = "USERNAME")
	@UniqueUsername(message="Username already exists")
	private String username;
	
	@NotBlank
	@Column(name = "PASSWORD", columnDefinition="text", length=10485760)
	private String password;
	
	@OneToMany(mappedBy = "foreas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AitisiModel> aitisi;
	
	private boolean active = true;
	
    private String roles = "ROLE_USER";
    
    @Embedded
    private StatusKey status;
 
    
	public ForeasModel() {}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDistinctiveTitle() {
		return distinctiveTitle;
	}

	public void setDistinctiveTitle(String distinctiveTitle) {
		this.distinctiveTitle = distinctiveTitle;
	}

	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public String getDoy() {
		return doy;
	}
	
	public void setDoy(String doy) {
		this.doy = doy;
	}

	public String getGemh() {
		return gemh;
	}

	public void setGemh(String gemh) {
		this.gemh = gemh;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactMember() {
		return contactMember;
	}

	public void setContactMember(String contactMember) {
		this.contactMember = contactMember;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}


	public Set<AitisiModel> getAitisi() {
		return aitisi;
	}


	public void setAitisi(Set<AitisiModel> aitisi) {
		this.aitisi = aitisi;
	}

	public StatusKey getStatus() {
		return status;
	}

	public void setStatus(StatusKey status) {
		this.status = status;
	}

}
