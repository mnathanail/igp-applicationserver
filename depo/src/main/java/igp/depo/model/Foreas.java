package igp.depo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "FOREAS")
public class Foreas implements Serializable{

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
	private String phoneNumber;
	
	@Column(name = "FAX")
	private String fax;
	
	@NotBlank
	@Column(name = "EMAIL")
	private String email;
	
	@NotBlank
	@Column(name = "CONTACTMEMBER")
	private String contactMember;
	
	@NotBlank
	@Size(min = 4, max = 30)
	@Column(name = "USERNAME")
	private String username;
	
	@NotBlank
	@Size(min = 8, max = 30)
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(mappedBy = "foreas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Cert> certifications;
	
	private boolean active;
    private String roles;
	
	
	public Foreas() {}
	
	

	public Foreas(@NotBlank @Size(min = 4, max = 30) String username,
			@NotBlank @Size(min = 8, max = 30) String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public Foreas(@NotBlank @Size(min = 4, max = 30) String username,
			@NotBlank @Size(min = 8, max = 30) String password, boolean active, String roles) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}



	public Foreas(@NotBlank @Size(min = 2, max = 30) String name, @NotBlank @Size(min = 2, max = 30) String surname,
			@NotBlank String distinctiveTitle, @NotBlank @Size(min = 9, max = 9) String afm, @NotBlank String doy,
			@NotBlank String gemh, @NotBlank String address, @NotBlank String phoneNumber, String fax,
			@NotBlank String email, @NotBlank String contactMember, @NotBlank @Size(min = 4, max = 30) String username,
			@NotBlank @Size(min = 8, max = 30) String password, boolean active, String roles) {
		super();
		this.name = name;
		this.surname = surname;
		this.distinctiveTitle = distinctiveTitle;
		this.afm = afm;
		this.doy = doy;
		this.gemh = gemh;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.fax = fax;
		this.email = email;
		this.contactMember = contactMember;
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}



	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}
	
	public Set<Cert> getCertifications() {
		return certifications;
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

	public void setCertifications(Set<Cert> certifications) {
		this.certifications = certifications;
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
	
	

	


}
