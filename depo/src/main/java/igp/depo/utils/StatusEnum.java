package igp.depo.utils;

import java.io.Serializable;

public enum StatusEnum implements Serializable{

	PENDING("PENDING"), ACCEPTED("ACCEPTED"), REJECTED("REJECTED");
	 
    private String code;
 
    private StatusEnum(String code) {
        this.code = code;
    }
 
    public String getCode() {
        return code;
    }
	
}
