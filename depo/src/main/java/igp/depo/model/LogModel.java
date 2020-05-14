package igp.depo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HISTORYLOGS")
public class LogModel implements Serializable{

	private static final long serialVersionUID = -7776187650223138588L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "LOGID")
	private Integer logId;
	
	@Column(name = "FOREASLOGID")
	private Integer foreasid;
	
	@Column(name = "LOGDATE", nullable = false, updatable = true, insertable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime submition_date = LocalDateTime.now(ZoneId.of( "Europe/Athens" ));
	
	@Column(name = "LOGMESSAGE")
	private String message;
	
	public LogModel() {}

	public LogModel(Integer foreasid, String message) {
		this.foreasid = foreasid;
		this.message = message;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getForeasid() {
		return foreasid;
	}

	public void setForeas_id(Integer foreasid) {
		this.foreasid = foreasid;
	}

	public LocalDateTime getSubmition_date() {
		return submition_date;
	}

	public void setSubmition_date(LocalDateTime submition_date) {
		this.submition_date = submition_date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
