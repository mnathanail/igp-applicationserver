package igp.depo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;

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
	  
	  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinColumn(name = "aitisi_foreas_id_fk", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  private ForeasModel foreas;


	  @NotNull
	  @Column(name = "REGULATEDACTIVITY")
	  private String regulatedActivity;
	  
	  
	  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinColumn(name = "regulated_activity_id_fk", nullable = false)
	  private RegulatedActivity activity;
	  
	
	  @Column(name = "DOCUMENT1")
	  private boolean document1;
	  
	 
	  @Column(name = "DOCUMENT2")
	  private boolean document2;
	  
	
	  @Column(name = "DOCUMENT3")
	  private boolean document3;
	  
	
	  @Column(name = "DOCUMENT4")
	  private boolean document4;
	  
	
	  @Column(name = "DOCUMENT5")
	  private boolean document5;
	  
	
	  @Column(name = "DOCUMENT6")
	  private boolean document6;
	  
	
	  @Column(name = "DOCUMENT7")
	  private boolean document7;
	  
	
	  @Column(name = "DOCUMENT8")
	  private boolean document8;
	  
	
	  @Column(name = "DOCUMENT9")
	  private boolean document9;
	  
	
	  @Column(name = "DOCUMENT10")
	  private boolean document10;
	  
	
	  @Column(name = "DOCUMENT11")
	  private boolean document11;
	  
	
	  @Column(name = "DOCUMENT12")
	  private boolean document12;
	  
	
	  @Column(name = "DOCUMENT13")
	  private boolean document13;
	  
	
	  @Column(name = "DOCUMENT14")
	  private boolean document14;
	  
	  @Column(name = "DATE", nullable = false, updatable = true, insertable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	  private LocalDateTime submition_date = LocalDateTime.now(ZoneId.of( "Europe/Athens" ));
	  
	  @Column(name = "EXPIRATIONDATE", nullable = true, updatable = true, insertable = true, columnDefinition = "TIMESTAMP")
	  private LocalDateTime submition_date_expiration;
	  
	  @Column(name = "COMPANY")
	  private String foreasTitle;
	  
	  @Embedded
	  private StatusKey status;

	  
	public AitisiModel() {}


	public Integer getId() {
		return aitisiId;
	}


	public void setId(Integer id) {
		this.aitisiId = id;
	}

	
	public int getForea_id(){
	    return foreas.getFid();
	}
	
	
	public void setForea_id(Integer id){
	   this.foreas.setFid(id);
	}
	

	@JsonIgnore
	public ForeasModel getForeas() {
		return foreas;
	}

	@JsonIgnore
	public void setForeas(ForeasModel foreas) {
		this.foreas = foreas;
	}
	
	
	// REGULATED ACTIVITY KEY START
	
	public String getRegulatedActivity() {
		return regulatedActivity;
	}


	public void setRegulatedActivity(String regulatedActivity) {
		this.regulatedActivity = regulatedActivity;
	}
	
	// REGULATED ACTIVITY KEY END
	
	// REGULATED ACTIVITY OBJECT START
	
	
	
	public int getActivity_id(){
	    return activity.getActivityId();
	}


	public void setActivity_id(Integer id){
	   this.activity.setActivityId(id);
	}
	
	@JsonIgnore
	public RegulatedActivity getActivity() {
		return activity;
	}
	
	@JsonIgnore
	public void setActivity(RegulatedActivity regulatedActivity) {
		this.activity = regulatedActivity;
	}
	// REGULATED ACTIVITY OBJECT END


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


	public StatusKey getStatus() {
		return status;
	}


	public void setStatus(StatusKey status) {
		this.status = status;
	}


	public LocalDateTime getSubmition_date() {
		return submition_date;
	}


	public void setSubmition_date(LocalDateTime submition_date) {
		this.submition_date = submition_date;
	}


	public LocalDateTime getSubmition_date_expiration() {
		return submition_date_expiration;
	}


	public void setSubmition_date_expiration(LocalDateTime submition_date_expiration) {
		this.submition_date_expiration = submition_date_expiration;
	}


	public String getForeasTitle() {
		return this.foreas.getDistinctiveTitle();
	}


	public void setForeasTitle(String foreasTitle) {
		this.foreasTitle = foreasTitle;
	}
	
	

}