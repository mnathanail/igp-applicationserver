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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "REGULATEDACTIVITY")
public class RegulatedActivity implements Serializable{

	private static final long serialVersionUID = 164370265357275394L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ACTIVITYID")
	private Integer activityId;

	
	@Column(name = "ACTIVITYNAME")
	private String name;
	
	
	@OneToMany(mappedBy = "activity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AitisiModel> aitisis;


	public Integer getActivityId() {
		return activityId;
	}


	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}


	public String getName() {
		return name;
	}


	public void setName(String activityName) {
		this.name = activityName;
	}

	@JsonIgnore
	public Set<AitisiModel> getAitisis() {
		return aitisis;
	}

	@JsonIgnore
	public void setAitisis(Set<AitisiModel> aitisis) {
		this.aitisis = aitisis;
	}
	
	

}
