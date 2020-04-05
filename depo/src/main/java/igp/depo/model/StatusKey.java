package igp.depo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import igp.depo.utils.StatusEnum;

@Embeddable
public class StatusKey implements Serializable {

	private static final long serialVersionUID = 5192241183689825178L;
	
	@NotNull
	@Column(name = "STATUS")
	private StatusEnum status = StatusEnum.PENDING;
	
	public StatusKey(){}

	public StatusKey(@NotNull StatusEnum status) {
		this.status = status;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

}
