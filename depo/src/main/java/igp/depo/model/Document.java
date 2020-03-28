package igp.depo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="DOCUMENT")
public class Document implements Serializable{

	private static final long serialVersionUID = -2881709001151205852L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOCID")
	private Long id;
	
	@Column(name="DOCNAME")
	private String docName;
	
	@Column(name="VALID")
	private boolean isValid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_CERT", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cert toCert;
	
	public Document() {}

	public Document(String docName, boolean isValid) {
		super();
		this.docName = docName;
		this.isValid = isValid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	
	@JsonIgnore
	public int certId() {
		return this.toCert.getCompanyId();
	}
	
	@JsonIgnore
	public Cert getToCert() {
		return this.toCert;
	}

	@JsonIgnore
	public void setToCert(Cert toCert) {
		this.toCert = toCert;
	}

	
	
	@Override
	public String toString() {
		return "Document [id=" + id + ", docName=" + docName + ", isValid=" + isValid + "]";
	}
	
}
