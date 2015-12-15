public enum TypeConverterEnum {

	STRING_TO_DATE((byte) 1, 
				   TypeConverterDate.class,
				   TypeEnum.DATA);
	
	private byte code;
	private TypeConverter<?> converter;
	private TypeEnum type;
	
	private TypeConverterEnum(byte code, 
							  Class<?> converter,
							  TypeEnum type) {
		this.code = code;
		try {
			this.converter = (TypeConverter<?>)converter.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		this.type = type;
	}
	
	public static TypeConverterEnum findByType(TypeEnum t) {
		for(TypeConverterEnum e : values()) {
			if(e.type.getCode() == t.getCode()) {
				return e;
			}
		}
		return null;
	}
	
	public byte getCode() {
		return code;
	}
	
	public TypeConverter<?> getConverter() {
		return converter;
	}
	
}
