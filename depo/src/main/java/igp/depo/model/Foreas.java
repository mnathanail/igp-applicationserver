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

@Entity
@Table(name = "FOREAS")
public class Foreas implements Serializable{

	private static final long serialVersionUID = -4831428130684547448L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "FOREASID")
	private Integer fid;
	
	@OneToMany(mappedBy = "foreas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Cert> certifications;
	
	@Column(name = "NAME")
	private String name;
	
	
	public Foreas() { }
	

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}
	
	public Set<Cert> getCertifications() {
		return certifications;
	}

	public void setCertifications(Set<Cert> certifications) {
		this.certifications = certifications;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
