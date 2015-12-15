import java.util.Date;

public enum TypeEnum {

	DATA((byte) 1, Date.class), 
	STRING((byte) 2, String.class);
	
	private byte code;
	private Class<?> type; 
	
	private TypeEnum(byte code, Class<?> type) {
		this.code = code;
		this.type = type;
	}
	
	public byte getCode() {
		return code;
	}
	
	public Class<?> getType() {
		return type;
	}
	
}
