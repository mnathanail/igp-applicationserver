package com.diaulos.igp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CERT")
public class Cert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	@Column(name = "regulatedActivity")
	private String regulatedActivity;
	@Column(name = "document1")
	private boolean document1;
	@Column(name = "document2")
	private boolean document2;
	@Column(name = "document3")
	private boolean document3;
	@Column(name = "document4")
	private boolean document4;
	@Column(name = "document5")
	private boolean document5;
	@Column(name = "document6")
	private boolean document6;
	@Column(name = "document7")
	private boolean document7;
	@Column(name = "document8")
	private boolean document8;
	@Column(name = "document9")
	private boolean document9;
	@Column(name = "document10")
	private boolean document10;
	@Column(name = "document11")
	private boolean document11;
	@Column(name = "document12")
	private boolean document12;
	@Column(name = "document13")
	private boolean document13;
	@Column(name = "document14")
	private boolean document14;




	public Cert(int companyId, String regulatedActivity, boolean document1, boolean document2, boolean document3,
			boolean document4, boolean document5, boolean document6, boolean document7, boolean document8,
			boolean document9, boolean document10, boolean document11, boolean document12, boolean document13,
			boolean document14) {
		super();
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

	/*
	 * @Id
	 *	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 *	private Integer cId;
	 *
	 * @NotBlank
	 *
	 * @Size(min = 3, max = 100)
	 *
	 * @Column(name = "NAME") private String cName;
	 *
	 * @Column(name = "TIN") private String cTin;
	 *
	 * @Column(name = "TITLE") private String cTitle;
	 */


	// Getter Methods

	public int getCompanyId() {
		return this.companyId;
	}

	public String getRegulatedActivity() {
		return this.regulatedActivity;
	}

	public boolean getDocument1() {
		return this.document1;
	}

	public boolean getDocument2() {
		return this.document2;
	}

	public boolean getDocument3() {
		return this.document3;
	}

	public boolean getDocument4() {
		return this.document4;
	}

	public boolean getDocument5() {
		return this.document5;
	}

	public boolean getDocument6() {
		return this.document6;
	}

	public boolean getDocument7() {
		return this.document7;
	}

	public boolean getDocument8() {
		return this.document8;
	}

	public boolean getDocument9() {
		return this.document9;
	}

	public boolean getDocument10() {
		return this.document10;
	}

	public boolean getDocument11() {
		return this.document11;
	}

	public boolean getDocument12() {
		return this.document12;
	}

	public boolean getDocument13() {
		return this.document13;
	}

	public boolean getDocument14() {
		return this.document14;
	}

	// Setter Methods

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public void setRegulatedActivity(String regulatedActivity) {
		this.regulatedActivity = regulatedActivity;
	}

	public void setDocument1(boolean document1) {
		this.document1 = document1;
	}

	public void setDocument2(boolean document2) {
		this.document2 = document2;
	}

	public void setDocument3(boolean document3) {
		this.document3 = document3;
	}

	public void setDocument4(boolean document4) {
		this.document4 = document4;
	}

	public void setDocument5(boolean document5) {
		this.document5 = document5;
	}

	public void setDocument6(boolean document6) {
		this.document6 = document6;
	}

	public void setDocument7(boolean document7) {
		this.document7 = document7;
	}

	public void setDocument8(boolean document8) {
		this.document8 = document8;
	}

	public void setDocument9(boolean document9) {
		this.document9 = document9;
	}

	public void setDocument10(boolean document10) {
		this.document10 = document10;
	}

	public void setDocument11(boolean document11) {
		this.document11 = document11;
	}

	public void setDocument12(boolean document12) {
		this.document12 = document12;
	}

	public void setDocument13(boolean document13) {
		this.document13 = document13;
	}

	public void setDocument14(boolean document14) {
		this.document14 = document14;
	}

}
