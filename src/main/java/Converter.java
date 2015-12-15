import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

public class Converter {

	public static <T> T convert(Class<T> klass, 
						 HttpServletRequest request) 
								 throws InstantiationException, 
								 IllegalAccessException {
		T t = klass.newInstance();
		
		Field[] fields = klass.getDeclaredFields();
		
		for(Field f : fields) {
			String name = f.getName();
			String value = request.getParameter(name);
			if(value != null) {
				f.setAccessible(true);
				if(f.isAnnotationPresent(Type.class)) {
					Type type = f.getAnnotation(Type.class);
					TypeConverterEnum converterEnum 
						= TypeConverterEnum.findByType(type.value());
					
					TypeConverter<?> c = converterEnum.getConverter();
					
					f.set(t, c.convert(value));
				} else {
					f.set(t, value);
				}
			}
		} 
		
		return t;
	} 
	
}
