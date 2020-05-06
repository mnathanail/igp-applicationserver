package igp.depo.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.io.Serializable;
import java.util.stream.Stream; 

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<StatusEnum, String>, Serializable {

	private static final long serialVersionUID = -1932079774886371355L;

	@Override
    public String convertToDatabaseColumn(StatusEnum status) {
        if (status == null) {
            return null;
        }
        return status.getCode();
    }
 
    @Override
    public StatusEnum convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
 
        return Stream.of(StatusEnum.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
	
	
}
