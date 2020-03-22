package com.diaulos.igp.model;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;

	@NotBlank
	@Size(min = 3, max = 100)
	@Column(name = "NAME")
	private String cName;

	@Column(name = "TIN")
	private String cTin;

	@Column(name = "TITLE")
	private String cTitle;

	public Cert() {
	}

	public Cert(Integer cId, String cName, String cTin, String cTitle) {
		this.cId = cId;
		this.cName = cName;
		this.cTin = cTin;
		this.cTitle = cTitle;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcTin() {
		return cTin;
	}

	public void setcTin(String cTin) {
		this.cTin = cTin;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	@Override
	public String toString() {
		return "Cert [cId=" + cId + ", cName=" + cName + ", cTin=" + cTin + ", cTitle=" + cTitle + "]";
	}

}
