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
  
  @Column(name = "DOC1")
  private boolean document1;
  
  @Column(name = "DOC2")
  private boolean document2;
  
  @Column(name = "DOC3")
  private boolean document3;
  
  @Column(name = "DOC4")
  private boolean document4;
  
  @Column(name = "DOC5")
  private boolean document5;
  
  @Column(name = "DOC6")
  private boolean document6;
  
  @Column(name = "DOC7")
  private boolean document7;
  
  @Column(name = "DOC8")
  private boolean document8;
  
  @Column(name = "DOC9")
  private boolean document9;
  
  @Column(name = "DOC10")
  private boolean document10;
  
  @Column(name = "DOC11")
  private boolean document11;
  
  @Column(name = "DOC12")
  private boolean document12;
  
  @Column(name = "DOC13")
  private boolean document13;
  
  @Column(name = "DOC14")
  private boolean document14;
  
  
public Cert() {}


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


public boolean isDocument1() {
	return document1;
}


public void setDocument1(boolean document1) {
	this.document1 = document1;
}


public boolean isDocument2() {
	return document2;
}


public void setDocument2(boolean document2) {
	this.document2 = document2;
}


public boolean isDocument3() {
	return document3;
}


public void setDocument3(boolean document3) {
	this.document3 = document3;
}


public boolean isDocument4() {
	return document4;
}


public void setDocument4(boolean document4) {
	this.document4 = document4;
}


public boolean isDocument5() {
	return document5;
}


public void setDocument5(boolean document5) {
	this.document5 = document5;
}


public boolean isDocument6() {
	return document6;
}


public void setDocument6(boolean document6) {
	this.document6 = document6;
}


public boolean isDocument7() {
	return document7;
}


public void setDocument7(boolean document7) {
	this.document7 = document7;
}


public boolean isDocument8() {
	return document8;
}


public void setDocument8(boolean document8) {
	this.document8 = document8;
}


public boolean isDocument9() {
	return document9;
}


public void setDocument9(boolean document9) {
	this.document9 = document9;
}


public boolean isDocument10() {
	return document10;
}


public void setDocument10(boolean document10) {
	this.document10 = document10;
}


public boolean isDocument11() {
	return document11;
}


public void setDocument11(boolean document11) {
	this.document11 = document11;
}


public boolean isDocument12() {
	return document12;
}


public void setDocument12(boolean document12) {
	this.document12 = document12;
}


public boolean isDocument13() {
	return document13;
}


public void setDocument13(boolean document13) {
	this.document13 = document13;
}


public boolean isDocument14() {
	return document14;
}


public void setDocument14(boolean document14) {
	this.document14 = document14;
}


@Override
public String toString() {
	return "Cert [companyId=" + companyId + ", foreas=" + foreas + ", regulatedActivity=" + regulatedActivity
			+ ", document1=" + document1 + ", document2=" + document2 + ", document3=" + document3 + ", document4="
			+ document4 + ", document5=" + document5 + ", document6=" + document6 + ", document7=" + document7
			+ ", document8=" + document8 + ", document9=" + document9 + ", document10=" + document10 + ", document11="
			+ document11 + ", document12=" + document12 + ", document13=" + document13 + ", document14=" + document14
			+ "]";
}





    

   
}
