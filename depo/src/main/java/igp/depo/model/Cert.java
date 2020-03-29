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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CERT")
public class Cert implements Serializable {
  
  private static final long serialVersionUID = 6679436979964698781L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "COMPANYID")
  private Integer companyId;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "FK_FOREAS", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Foreas foreas;
  
  
  @OneToMany(mappedBy ="toCert", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<Document> documents;
  
  @NotBlank
  @Size(min = 3, max = 100)
  @Column(name = "ACTIVITY")
  private String regulatedActivity;
  
  
public Cert() {}


public Cert(Set<Document> documents, @NotBlank @Size(min = 3, max = 100) String regulatedActivity) {
	super();
	this.documents = documents;
	this.regulatedActivity = regulatedActivity;
}


public Integer getCompanyId() {
	return companyId;
}


public void setCompanyId(Integer companyId) {
	this.companyId = companyId;
}

@JsonIgnore
public int getForea_id(){
    return foreas.getFid();
}

@JsonIgnore
public Foreas getForeas() {
	return foreas;
}


@JsonIgnore
public void setForeas(Foreas foreas) {
	this.foreas = foreas;
}


public Set<Document> getDocuments() {
	return documents;
}


public void setDocuments(Set<Document> documents) {
	this.documents = documents;
}


public String getRegulatedActivity() {
	return regulatedActivity;
}


public void setRegulatedActivity(String regulatedActivity) {
	this.regulatedActivity = regulatedActivity;
}







    

   
}
