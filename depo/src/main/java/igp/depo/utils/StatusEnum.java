package igp.depo.utils;

public enum StatusEnum {

	PENDING("PENDING"), ACCEPTED("ACCEPTED"), REJECTED("REJECTED");
	 
    private String code;
 
    private StatusEnum(String code) {
        this.code = code;
    }
 
    public String getCode() {
        return code;
    }
	
}
