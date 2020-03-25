package igp.depo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CERT")
public class Cert {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "COMPANYID")
  private Integer companyId;
  
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


public Cert(Integer companyId, @NotBlank @Size(min = 3, max = 100) String regulatedActivity, boolean document1,
		boolean document2, boolean document3, boolean document4, boolean document5, boolean document6,
		boolean document7, boolean document8, boolean document9, boolean document10, boolean document11,
		boolean document12, boolean document13, boolean document14) {
	this.companyId = companyId;
	this.regulatedActivity = regulatedActivity;
	this.document1 = document1;
	this.document2 = document2;
	this.document3 = document3;
	this.document4 = document4;
	this.document5 = document5;
	this.document6 = document6;
	this.document7 = document7;
	this.document8 = document8;
	this.document9 = document9;
	this.document10 = document10;
	this.document11 = document11;
	this.document12 = document12;
	this.document13 = document13;
	this.document14 = document14;
}


public Integer getCompanyId() {
	return companyId;
}


public void setCompanyId(Integer companyId) {
	this.companyId = companyId;
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
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
	result = prime * result + (document1 ? 1231 : 1237);
	result = prime * result + (document10 ? 1231 : 1237);
	result = prime * result + (document11 ? 1231 : 1237);
	result = prime * result + (document12 ? 1231 : 1237);
	result = prime * result + (document13 ? 1231 : 1237);
	result = prime * result + (document14 ? 1231 : 1237);
	result = prime * result + (document2 ? 1231 : 1237);
	result = prime * result + (document3 ? 1231 : 1237);
	result = prime * result + (document4 ? 1231 : 1237);
	result = prime * result + (document5 ? 1231 : 1237);
	result = prime * result + (document6 ? 1231 : 1237);
	result = prime * result + (document7 ? 1231 : 1237);
	result = prime * result + (document8 ? 1231 : 1237);
	result = prime * result + (document9 ? 1231 : 1237);
	result = prime * result + ((regulatedActivity == null) ? 0 : regulatedActivity.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cert other = (Cert) obj;
	if (companyId == null) {
		if (other.companyId != null)
			return false;
	} else if (!companyId.equals(other.companyId))
		return false;
	if (document1 != other.document1)
		return false;
	if (document10 != other.document10)
		return false;
	if (document11 != other.document11)
		return false;
	if (document12 != other.document12)
		return false;
	if (document13 != other.document13)
		return false;
	if (document14 != other.document14)
		return false;
	if (document2 != other.document2)
		return false;
	if (document3 != other.document3)
		return false;
	if (document4 != other.document4)
		return false;
	if (document5 != other.document5)
		return false;
	if (document6 != other.document6)
		return false;
	if (document7 != other.document7)
		return false;
	if (document8 != other.document8)
		return false;
	if (document9 != other.document9)
		return false;
	if (regulatedActivity == null) {
		if (other.regulatedActivity != null)
			return false;
	} else if (!regulatedActivity.equals(other.regulatedActivity))
		return false;
	return true;
}


@Override
public String toString() {
	return "Cert [companyId=" + companyId + ", regulatedActivity=" + regulatedActivity + ", document1=" + document1
			+ ", document2=" + document2 + ", document3=" + document3 + ", document4=" + document4 + ", document5="
			+ document5 + ", document6=" + document6 + ", document7=" + document7 + ", document8=" + document8
			+ ", document9=" + document9 + ", document10=" + document10 + ", document11=" + document11 + ", document12="
			+ document12 + ", document13=" + document13 + ", document14=" + document14 + "]";
}


    

   
}
