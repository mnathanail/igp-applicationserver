package igp.depo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "AITISI")
public class AitisiModel implements Serializable {
	  
	  private static final long serialVersionUID = 6679436979964698781L;

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "AITISID")
	  private Integer aitisiId;
	  
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "aitisi_foreas_id_fk", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  private ForeasModel foreas;

	  @NotBlank
	  @Size(min = 3, max = 100)
	  @Column(name = "ACTIVITY")
	  private String regulatedActivity;
	  
	
	  @Column(name = "DOC1")
	  private boolean docname1;
	  
	 
	  @Column(name = "DOC2")
	  private boolean docname2;
	  
	
	  @Column(name = "DOC3")
	  private boolean docname3;
	  
	
	  @Column(name = "DOC4")
	  private boolean docname4;
	  
	
	  @Column(name = "DOC5")
	  private boolean docname5;
	  
	
	  @Column(name = "DOC6")
	  private boolean docname6;
	  
	
	  @Column(name = "DOC7")
	  private boolean docname7;
	  
	
	  @Column(name = "DOC8")
	  private boolean docname8;
	  
	
	  @Column(name = "DOC9")
	  private boolean docname9;
	  
	
	  @Column(name = "DOC10")
	  private boolean docname10;
	  
	
	  @Column(name = "DOC11")
	  private boolean docname11;
	  
	
	  @Column(name = "DOC12")
	  private boolean docname12;
	  
	
	  @Column(name = "DOC13")
	  private boolean docname13;
	  
	
	  @Column(name = "DOC14")
	  private boolean docname14;
	  
	  @Column(name = "DATE", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	  private LocalDateTime submition_date = LocalDateTime.now();
	  
	  @Embedded
	  private StatusKey status;

	  
	public AitisiModel() {}


	public Integer getId() {
		return aitisiId;
	}


	public void setId(Integer id) {
		this.aitisiId = id;
	}

	@JsonIgnore
	public int getForea_id(){
	    return foreas.getFid();
	}

	@JsonIgnore
	public ForeasModel getForeas() {
		return foreas;
	}


	@JsonIgnore
	public void setForeas(ForeasModel foreas) {
		this.foreas = foreas;
	}

	public String getRegulatedActivity() {
		return regulatedActivity;
	}

	public void setRegulatedActivity(String regulatedActivity) {
		this.regulatedActivity = regulatedActivity;
	}


	public boolean isDocname1() {
		return docname1;
	}


	public void setDocname1(boolean docname1) {
		this.docname1 = docname1;
	}


	public boolean isDocname2() {
		return docname2;
	}


	public void setDocname2(boolean docname2) {
		this.docname2 = docname2;
	}


	public boolean isDocname3() {
		return docname3;
	}


	public void setDocname3(boolean docname3) {
		this.docname3 = docname3;
	}


	public boolean isDocname4() {
		return docname4;
	}


	public void setDocname4(boolean docname4) {
		this.docname4 = docname4;
	}


	public boolean isDocname5() {
		return docname5;
	}


	public void setDocname5(boolean docname5) {
		this.docname5 = docname5;
	}


	public boolean isDocname6() {
		return docname6;
	}


	public void setDocname6(boolean docname6) {
		this.docname6 = docname6;
	}


	public boolean isDocname7() {
		return docname7;
	}


	public void setDocname7(boolean docname7) {
		this.docname7 = docname7;
	}


	public boolean isDocname8() {
		return docname8;
	}


	public void setDocname8(boolean docname8) {
		this.docname8 = docname8;
	}


	public boolean isDocname9() {
		return docname9;
	}


	public void setDocname9(boolean docname9) {
		this.docname9 = docname9;
	}


	public boolean isDocname10() {
		return docname10;
	}


	public void setDocname10(boolean docname10) {
		this.docname10 = docname10;
	}


	public boolean isDocname11() {
		return docname11;
	}


	public void setDocname11(boolean docname11) {
		this.docname11 = docname11;
	}


	public boolean isDocname12() {
		return docname12;
	}


	public void setDocname12(boolean docname12) {
		this.docname12 = docname12;
	}


	public boolean isDocname13() {
		return docname13;
	}


	public void setDocname13(boolean docname13) {
		this.docname13 = docname13;
	}


	public boolean isDocname14() {
		return docname14;
	}


	public void setDocname14(boolean docname14) {
		this.docname14 = docname14;
	}


	public StatusKey getStatus() {
		return status;
	}


	public void setStatus(StatusKey status) {
		this.status = status;
	}

}